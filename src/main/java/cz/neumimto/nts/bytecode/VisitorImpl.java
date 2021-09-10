package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.ScriptContext;
import cz.neumimto.nts.annotations.ScriptMeta;
import cz.neumimto.nts.ntsBaseVisitor;
import cz.neumimto.nts.ntsParser;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatchers;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.stream.Collectors;

public class VisitorImpl extends ntsBaseVisitor<ScriptContext> {

    private final ScriptContext scriptContext;

    public VisitorImpl(ScriptContext scriptContext) {
        this.scriptContext = scriptContext;
    }

    protected void addInsn(StackManipulation sm) {
        scriptContext.currentScope().add(sm);
    }
    
    @Override
    public ScriptContext visitAssignment_statement(ntsParser.Assignment_statementContext ctx) {
        TerminalNode variableIdentifier = ctx.VARIABLE_IDENTIFIER();
        Optional<Variable> var = scriptContext.getVariable(variableIdentifier.getText());
        if (var.isPresent()) {
            Variable variable = var.get();
            addInsn(variable.store());
        } else {
            var value = ctx.assignment_values();
            visitAssignment_values(value);
            Variable variable = scriptContext.createNewVariable(variableIdentifier.getText(), ctx.assignment_values());
            addInsn(variable.store());
        }
        return scriptContext;
    }

    @Override
    public ScriptContext visitType_literal(ntsParser.Type_literalContext ctx) {
        addInsn(new TextConstant(ctx.getText().substring(1, ctx.getText().length() - 1)));
        return scriptContext;
    }

    @Override
    public ScriptContext visitType_bool(ntsParser.Type_boolContext ctx) {
        String text = ctx.getText();
        boolean b = parseBoolean(text);
        addInsn(IntegerConstant.forValue(b));
        return scriptContext;
    }

    @Override
    public ScriptContext visitType_integer(ntsParser.Type_integerContext ctx) {
        String text = ctx.getText();
        addInsn(IntegerConstant.forValue(Integer.parseInt(text)));
        return scriptContext;
    }

    protected boolean parseBoolean(String text) {
        if (text.equalsIgnoreCase("t") || text.equalsIgnoreCase("true")) {
            return true;
        } else if (text.equalsIgnoreCase("f") || text.equalsIgnoreCase("false")) {
            return false;
        }
        throw new RuntimeException("Unknown boolean value " + text);
    }


    @Override
    public ScriptContext visitVariable_reference(ntsParser.Variable_referenceContext ctx) {
        String text = ctx.variable.getText();
        Optional<Variable> variable = scriptContext.getVariable(text);
        if (variable.isPresent()) {
            Variable variable1 = variable.get();
            addInsn(variable1.load());
        } else {
            throw new RuntimeException("unknown variable reference " + text);
        }
        return scriptContext;
    }

    @Override
    public ScriptContext visitReturn_statement(ntsParser.Return_statementContext ctx) {
        var rtype = ctx.rval();


        if (rtype.type_enum() != null || rtype.type_literal() != null) {
            visitChildren(rtype);
            addInsn(MethodReturn.REFERENCE);

        } else if (rtype.type_integer() != null || rtype.type_bool() != null) {
            visitChildren(rtype.type_integer());
            addInsn(MethodReturn.INTEGER);

        } else {
            addInsn(MethodReturn.VOID);
        }
        return scriptContext;
    }

    @Override
    public ScriptContext visitType_enum(ntsParser.Type_enumContext ctx) {
        String type = ctx.type.getText();
        String value = ctx.value.getText();
        Enum enumValue = scriptContext.getEnumValue(type, value);
        addInsn(FieldAccess.forEnumeration(new EnumerationDescription.ForLoadedEnumeration(enumValue)));
        return scriptContext;
    }

    @Override
    public ScriptContext visitFunction_call(ntsParser.Function_callContext ctx) {
        String functionName = ctx.function_name.getText();
        Object mechanic = scriptContext.findMechanic(functionName);

        addInsn(MethodVariableAccess.loadThis());

        FieldDescription.InDefinedShape field = scriptContext.getInsnType().getDeclaredFields()
                .filter(ElementMatchers.named(mechanic.getClass().getSimpleName()))
                .getOnly();

        addInsn(FieldAccess.forField(field).read());

        List<StackManipulation> argImpl = new ArrayList<>();
        Parameter[] parameters = scriptContext.findHandler(mechanic, functionName).getParameters();

        for (Parameter parameter : parameters) {
            ScriptMeta.NamedParam annotation = parameter.getAnnotation(ScriptMeta.NamedParam.class);
            if (annotation == null) {
                continue;
            }
            ntsParser.ArgumentContext argument = findArgumentForNamedParam(ctx.argument(), annotation.value());
            if (argument == null) {
                if (parameter.getType() == int.class || parameter.getType() == boolean.class) {
                    addInsn(IntegerConstant.forValue(0));
                } else if (Object.class.isAssignableFrom(parameter.getType())) {
                    addInsn(NullConstant.INSTANCE);
                }
            } else {
                ntsParser.RvalContext value = argument.value;
                String name = argument.name.getText();
                visitChildren(value);
            }
        }

        Method method = scriptContext.findHandler(mechanic, functionName);
        addInsn(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(method)));

        if (method.getReturnType() != void.class && ctx.getParent() instanceof ntsParser.StatementContext) {
            addInsn(Removal.SINGLE);
        }
        return scriptContext;
    }

    @Override
    public ScriptContext visitIf_statement(ntsParser.If_statementContext ctx) {
        Label ifLabel = new Label();
        ntsParser.Type_comparisonContext type_comparisonContext = ctx.condition_expression().type_comparison();
        if (type_comparisonContext != null) {
            visitChildren(type_comparisonContext.left);
            visitChildren(type_comparisonContext.right);
            String text = type_comparisonContext.op.getText();
            addInsn(Branching.ArithmeticalComp.forToken(text, ifLabel));
        } else {
            visitChildren(ctx.condition_expression());
            addInsn(new Branching.IfEq(ifLabel));
        }
        visitChildren(ctx.statement_list());
        addInsn(new Branching.Mark(ifLabel));

        return scriptContext;
    }

    @Override
    public ScriptContext visitType_comparison(ntsParser.Type_comparisonContext ctx) {
        visitChildren(ctx.left);
        visitChildren(ctx.right);

        return scriptContext;
    }

    @Override
    public ScriptContext visitForeach_statement(ntsParser.Foreach_statementContext ctx) {

        visitChildren(ctx.iterable());

        try {
            Method m_iterator = Iterable.class.getDeclaredMethod("iterator");
            Method m_hasNext = Iterator.class.getDeclaredMethod("hasNext");
            Method m_next = Iterator.class.getDeclaredMethod("next");

            var iterator = MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(m_iterator));
            addInsn(iterator);
            Variable variable = scriptContext.createNewVariable(UUID.randomUUID().toString());
            addInsn(variable.store());

            Label forLabel = new Label(); //label2
            addInsn(new Branching.Mark(forLabel));
            //hasNext
            addInsn(variable.load());
            addInsn(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(m_hasNext)));
            Label hasNextLabel = new Label();
            addInsn(new Branching.IfEq(hasNextLabel));

            addInsn(variable.load());
            addInsn(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(m_next)));
            Variable nextObj = scriptContext.createNewVariable(ctx.variable_reference().getText());
            addInsn(nextObj.store());

            // body
            visitChildren(ctx.statement_list());


            addInsn(new Branching.GoTo(forLabel));
            addInsn(new Branching.Mark(hasNextLabel));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return scriptContext;
    }

    @Override
    public ScriptContext visitLambda(ntsParser.LambdaContext ctx) {
        List<ntsParser.Variable_referenceContext> variable_referenceContexts = ctx.variable_reference();
        Map<String, Variable> fnVars = new TreeMap<>();
        for (ntsParser.Variable_referenceContext var : variable_referenceContexts) {
            String text = var.VARIABLE_IDENTIFIER().getText();
            Optional<Variable> variable = scriptContext.getVariable(text);
            if (variable.isEmpty()) {
                throw new IllegalStateException("Unknown variable " + text);
            }
            fnVars.put(text, variable.get());
        }

        addInsn(MethodVariableAccess.loadThis());

        for (Variable fnVar : fnVars.values()) {
            addInsn(fnVar.load());
        }

        addInsn(new InvokeDynamic());

        scriptContext.createNewScopeWithVars(fnVars);
        visitChildren(ctx.statement_list());
        addInsn(MethodReturn.VOID);
        scriptContext.endScope();

        return scriptContext;
    }

    private ntsParser.ArgumentContext findArgumentForNamedParam(List<ntsParser.ArgumentContext> argument, String value) {
        for (ntsParser.ArgumentContext argumentContext : argument) {
            String text = argumentContext.name.getText();
            if ("".equalsIgnoreCase(argumentContext.value.getText())) {
                continue;
            }
            if (text.equalsIgnoreCase(value)) {
                return argumentContext;
            }
        }
        return null;
    }

    public ScriptContext getImpl() {
        return scriptContext;
    }

    public ScriptContext getScriptContext() {
        return scriptContext;
    }
}
