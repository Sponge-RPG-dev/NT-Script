package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;
import cz.neumimto.nts.bytecode.Branching;
import cz.neumimto.nts.bytecode.FunctionCall;
import cz.neumimto.nts.bytecode.Variable;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
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
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;
import java.util.List;

public class VisitorImpl extends ntsBaseListener {

    private final ScriptContext scriptContext;

    private List<StackManipulation> impl = new ArrayList<>();

    private Map<ntsParser.Function_callContext, FunctionCall> fnCalls = new HashMap<>();
    private Map<ParserRuleContext, Void> fnExitCalls = new HashMap<>();
    //todo fix this
    private Set<ParserRuleContext> alreadyProcessed = new HashSet<>();

    public VisitorImpl(ScriptContext scriptContext) {
        this.scriptContext = scriptContext;
    }

    @Override
    public void exitAssignment_statement(ntsParser.Assignment_statementContext ctx) {
        TerminalNode variableIdentifier = ctx.VARIABLE_IDENTIFIER();
        Optional<Variable> var = scriptContext.getVariable(variableIdentifier.getText());
        if (var.isPresent()) {
            Variable variable = var.get();
            variable.store();
        } else {
            Variable variable = scriptContext.createNewVariable(variableIdentifier.getText(), ctx.rval());
            impl.add(variable.store());
        }
    }

    @Override
    public void enterVariable_reference(ntsParser.Variable_referenceContext ctx) {
        if (!alreadyProcessed.contains(ctx)) {

            Optional<Variable> variable = scriptContext.getVariable(ctx.variable.getText());
            variable.ifPresent(value -> impl.add(value.load()));
            alreadyProcessed.add(ctx);
        }
    }

    @Override
    public void enterType_bool(ntsParser.Type_boolContext ctx) {
        if (!alreadyProcessed.contains(ctx)) {
            String text = ctx.getText();
            boolean result = parseBoolean(text);

            impl.add(IntegerConstant.forValue(result));

            alreadyProcessed.add(ctx);
        }
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
    public void enterType_literal(ntsParser.Type_literalContext ctx) {
        if (!alreadyProcessed.contains(ctx)) {
            impl.add(new TextConstant(ctx.getText().substring(1, ctx.getText().length() - 1)));
            alreadyProcessed.add(ctx);
        }
    }

    @Override
    public void enterType_integer(ntsParser.Type_integerContext ctx) {
        if (!alreadyProcessed.contains(ctx)) {
            impl.add(IntegerConstant.forValue(Integer.parseInt(ctx.getText())));
            alreadyProcessed.add(ctx);
        }
    }

    @Override
    public void exitReturn_statement(ntsParser.Return_statementContext ctx) {
        var rtype = ctx.rval();
        ntsParser.Type_enumContext type_enumContext = rtype.type_enum();
        if (type_enumContext != null) {
            String type = type_enumContext.type.getText();
            String value = type_enumContext.value.getText();

            Enum enumValue = scriptContext.getEnumValue(type, value);
            impl.add(FieldAccess.forEnumeration(new EnumerationDescription.ForLoadedEnumeration(enumValue)));
            impl.add(MethodReturn.REFERENCE);
        } else {
            impl.add(MethodReturn.VOID);
        }
    }

    @Override
    public void enterFunction_call(ntsParser.Function_callContext ctx) {
        if (fnCalls.containsKey(ctx)) {
            return;
        }
        String functionName = ctx.function_name.getText();
        Object mechanic = scriptContext.findMechanic(functionName);
        impl.add(MethodVariableAccess.loadThis());

        FieldDescription.InDefinedShape field = scriptContext.getInsnType().getDeclaredFields()
                .filter(ElementMatchers.named(mechanic.getClass().getSimpleName()))
                .getOnly();

        impl.add(FieldAccess.forField(field).read());

        List<StackManipulation> argImpl = new ArrayList<>();
        Parameter[] parameters = scriptContext.findHandler(mechanic).getParameters();

        //todo remove this lookup, build the argument order in exit
        for (Parameter parameter : parameters) {
            ScriptMeta.NamedParam annotation = parameter.getAnnotation(ScriptMeta.NamedParam.class);
            if (annotation == null) {
                continue;
            }
            ntsParser.ArgumentContext argument = findArgumentForNamedParam(ctx.argument(), annotation.value());
            if (argument == null) {
                argImpl.add(NullConstant.INSTANCE);
            } else {
                ntsParser.RvalContext value = argument.value;
                String name = argument.name.getText();
                if (value.type_literal() != null) {
                    enterType_literal(value.type_literal());
                } else if (value.type_integer() != null) {
                    enterType_integer(value.type_integer());
                } else if (value.type_bool() != null) {
                    enterType_bool(value.type_bool());
                } else if (value.variable_reference() != null) {
                    enterVariable_reference(value.variable_reference());
                } else if (value.function_call() != null) {
                    FunctionCall functionCall = fnCalls.get(value.function_call());
                    if (functionCall == null) {
                       enterFunction_call(value.function_call());
                       fnCalls.put(value.function_call(), null);
                    }
                }
            }
        }
        impl.addAll(argImpl);
        fnCalls.put(ctx, null);
    }

    @Override
    public void exitFunction_call(ntsParser.Function_callContext ctx) {
        if (fnExitCalls.containsKey(ctx)) {
            return;
        }
        String functionName = ctx.function_name.getText();
        Object mechanic = scriptContext.findMechanic(functionName);
        Method method = scriptContext.findHandler(mechanic);
        impl.add(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(method)));
        fnExitCalls.put(ctx, null);
    }



    @Override
    public void enterIf_statement(ntsParser.If_statementContext ctx) {
        ntsParser.Condition_expressionContext expr = ctx.condition_expression();
        if (expr.function_call() != null) {
            enterFunction_call(expr.function_call());
            exitFunction_call(expr.function_call());
        } else if (expr.variable_reference() != null) {
            enterVariable_reference(expr.variable_reference());
            exitVariable_reference(expr.variable_reference());
        }
        Label ifLable = new Label();
        impl.add(new Branching.IfEq(ifLable));
    }

    @Override
    public void exitIf_statement(ntsParser.If_statementContext ctx) {
        super.exitIf_statement(ctx);
        ListIterator<StackManipulation> it = impl.listIterator(impl.size());
        Label ifLabel = null;
        int i = 0;
        while (it.hasPrevious()) {
            StackManipulation previous = it.previous();
            if (previous instanceof Branching.IfEq e) {
                if (i == 0) {
                    ifLabel = e.label();
                    break;
                } else {
                    i--;
                }
            } else if (previous instanceof Branching.Mark m) {
                i++;
            }
        }
        impl.add(new Branching.Mark(ifLabel));
    }

    @Override
    public void enterForeach_statement(ntsParser.Foreach_statementContext ctx) {
        String text = ctx.variable.getText();
        ntsParser.IterableContext iterable = ctx.iterable();
        if (iterable.function_call() != null) {
            enterFunction_call(iterable.function_call());
            exitFunction_call(iterable.function_call());
        } else if (iterable.variable_reference() != null) {
            enterVariable_reference(iterable.variable_reference());
            enterVariable_reference(iterable.variable_reference());
        }

        try {
            Method m_iterator = Iterable.class.getDeclaredMethod("iterator");
            Method m_hasNext = Iterator.class.getDeclaredMethod("hasNext");
            Method m_next = Iterator.class.getDeclaredMethod("next");
            impl.add(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(m_iterator)));
            String iteratorRef = UUID.randomUUID().toString();

            Variable iterator = scriptContext.createNewVariable(iteratorRef);
            impl.add(iterator.store());

            var startLabel = new Label();
            impl.add(new Branching.Mark(startLabel));

            impl.add(iterator.load());
            impl.add(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(m_hasNext)));
            var ifLabel = new Label();
            impl.add(new Branching.IfEq(ifLabel));

            impl.add(iterator.load());
            impl.add(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(m_next)));
            Variable nextRef = scriptContext.createNewVariable(text);
            impl.add(nextRef.store());

            //body

            impl.add(new Branching.GoTo(startLabel));
            impl.add(new Branching.Mark(ifLabel));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void exitForeach_statement(ntsParser.Foreach_statementContext ctx) {
        super.exitForeach_statement(ctx);
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

    public ScriptContext getScriptContext() {
        return scriptContext;
    }

    private class ScriptCompileError extends RuntimeException {
        public ScriptCompileError(String s) {
            super(s);
        }
    }

    public List<StackManipulation> getImpl() {
        return impl;
    }

    public Map<ntsParser.Function_callContext, FunctionCall> getFnCalls() {
        return fnCalls;
    }
}
