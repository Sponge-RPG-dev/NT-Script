package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.ScriptContext;
import cz.neumimto.nts.annotations.ScriptMeta;
import cz.neumimto.nts.ntsBaseVisitor;
import cz.neumimto.nts.ntsParser;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.bytecode.Removal;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.NullConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.matcher.ElementMatchers;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

public class VisitorImpl extends ntsBaseVisitor<List<StackManipulation>> {

    private final ScriptContext scriptContext;

    private List<StackManipulation> impl = new ArrayList<>();

    public VisitorImpl(ScriptContext scriptContext) {
        this.scriptContext = scriptContext;
    }

    @Override
    public List<StackManipulation> visitAssignment_statement(ntsParser.Assignment_statementContext ctx) {
        TerminalNode variableIdentifier = ctx.VARIABLE_IDENTIFIER();
        Optional<Variable> var = scriptContext.getVariable(variableIdentifier.getText());
        if (var.isPresent()) {
            Variable variable = var.get();
            impl.add(variable.store());
        } else {
            ntsParser.RvalContext rval = ctx.rval();
            visitRval(rval);
            Variable variable = scriptContext.createNewVariable(variableIdentifier.getText(), rval);
            impl.add(variable.store());
        }
        return impl;
    }

    @Override
    public List<StackManipulation> visitType_literal(ntsParser.Type_literalContext ctx) {
        impl.add(new TextConstant(ctx.getText().substring(1, ctx.getText().length() - 1)));
        return impl;
    }

    @Override
    public List<StackManipulation> visitType_bool(ntsParser.Type_boolContext ctx) {
        String text = ctx.getText();
        boolean b = parseBoolean(text);
        impl.add(IntegerConstant.forValue(b));
        return impl;
    }

    @Override
    public List<StackManipulation> visitType_integer(ntsParser.Type_integerContext ctx) {
        String text = ctx.getText();
        impl.add(IntegerConstant.forValue(Integer.parseInt(text)));
        return impl;
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
    public List<StackManipulation> visitVariable_reference(ntsParser.Variable_referenceContext ctx) {
        String text = ctx.variable.getText();
        Optional<Variable> variable = scriptContext.getVariable(text);
        if (variable.isPresent()) {
            Variable variable1 = variable.get();
            impl.add(variable1.load());
        } else {
            throw new RuntimeException("unknown variable reference " + text);
        }
        return impl;
    }

    @Override
    public List<StackManipulation> visitReturn_statement(ntsParser.Return_statementContext ctx) {
        var rtype = ctx.rval();


        if (rtype.type_enum() != null || rtype.type_literal() != null) {
            visitChildren(rtype);
            impl.add(MethodReturn.REFERENCE);

        } else if (rtype.type_integer() != null || rtype.type_bool() != null) {
            visitChildren(rtype.type_integer());
            impl.add(MethodReturn.INTEGER);

        } else {
            impl.add(MethodReturn.VOID);
        }
        return impl;
    }

    @Override
    public List<StackManipulation> visitType_enum(ntsParser.Type_enumContext ctx) {
        String type = ctx.type.getText();
        String value = ctx.value.getText();
        Enum enumValue = scriptContext.getEnumValue(type, value);
        impl.add(FieldAccess.forEnumeration(new EnumerationDescription.ForLoadedEnumeration(enumValue)));
        return impl;
    }

    @Override
    public List<StackManipulation> visitFunction_call(ntsParser.Function_callContext ctx) {
        String functionName = ctx.function_name.getText();
        Object mechanic = scriptContext.findMechanic(functionName);

        impl.add(MethodVariableAccess.loadThis());

        FieldDescription.InDefinedShape field = scriptContext.getInsnType().getDeclaredFields()
                .filter(ElementMatchers.named(mechanic.getClass().getSimpleName()))
                .getOnly();

        impl.add(FieldAccess.forField(field).read());

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
                    argImpl.add(IntegerConstant.forValue(0));
                } else if (Object.class.isAssignableFrom(parameter.getType())) {
                    argImpl.add(NullConstant.INSTANCE);
                }
            } else {
                ntsParser.RvalContext value = argument.value;
                String name = argument.name.getText();
                visitChildren(value);
            }
        }
        impl.addAll(argImpl);

        Method method = scriptContext.findHandler(mechanic, functionName);
        impl.add(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(method)));

        if (method.getReturnType() != void.class && ctx.getParent() instanceof ntsParser.StatementContext) {
            impl.add(Removal.SINGLE);
        }
        return impl;
    }

    @Override
    public List<StackManipulation> visitIf_statement(ntsParser.If_statementContext ctx) {
        visitChildren(ctx.condition_expression());
        Label ifLabel = new Label();
        impl.add(new Branching.IfEq(ifLabel));
        visitChildren(ctx.statement_list());
        impl.add(new Branching.Mark(ifLabel));

        return impl;
    }

    @Override
    public List<StackManipulation> visitForeach_statement(ntsParser.Foreach_statementContext ctx) {

        visitChildren(ctx.iterable());

        try {
            Method m_iterator = Iterable.class.getDeclaredMethod("iterator");
            Method m_hasNext = Iterator.class.getDeclaredMethod("hasNext");
            Method m_next = Iterator.class.getDeclaredMethod("next");

            var iterator = MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(m_iterator));
            impl.add(iterator);
            Variable variable = scriptContext.createNewVariable(UUID.randomUUID().toString());
            impl.add(variable.store());

            Label forLabel = new Label(); //label2
            impl.add(new Branching.Mark(forLabel));
            //hasNext
            impl.add(variable.load());
            impl.add(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(m_hasNext)));
            Label hasNextLabel = new Label();
            impl.add(new Branching.IfEq(hasNextLabel));

            impl.add(variable.load());
            impl.add(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(m_next)));
            Variable nextObj = scriptContext.createNewVariable(ctx.variable_reference().getText());
            impl.add(nextObj.store());

            // body
            visitChildren(ctx.statement_list());


            impl.add(new Branching.GoTo(forLabel));
            impl.add(new Branching.Mark(hasNextLabel));

        } catch (Exception e) {
            e.printStackTrace();
        }

        return impl;
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

    public List<? extends StackManipulation> getImpl() {
        return impl;
    }

    public ScriptContext getScriptContext() {
        return scriptContext;
    }
}
