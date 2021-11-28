package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.*;
import net.bytebuddy.description.enumeration.EnumerationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.implementation.bytecode.*;
import net.bytebuddy.implementation.bytecode.constant.*;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodReturn;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.matcher.ElementMatchers;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.lang.reflect.*;
import java.util.*;

public class VisitorImpl extends ntsBaseVisitor<ScriptContext> {

    private final ScriptContext scriptContext;

    public VisitorImpl(ScriptContext scriptContext) {
        this.scriptContext = scriptContext;
    }

    protected void addInsn(StackManipulation sm) {
        scriptContext.currentScope().add(sm);
    }

    protected StackManipulation previouusInsn() {
        return scriptContext.currentScope().impl.get(scriptContext.currentScope().impl.size() - 1);
    }

    @Override
    public ScriptContext visitAssignment_statement(ntsParser.Assignment_statementContext ctx) {
        TerminalNode variableIdentifier = ctx.VARIABLE_IDENTIFIER();
        Optional<Variable> var = scriptContext.getVariable(variableIdentifier.getText());

        Variable variable = var.orElseGet(() -> scriptContext.createNewVariable(variableIdentifier.getText(), ctx.assignment_values()));
        visitAssignment_values(ctx.assignment_values());


        if (ctx.assignment_values().rval() != null && ctx.assignment_values().rval().function_call() != null) {
            Executable e = scriptContext.findExecutableElement(ctx.assignment_values().rval().function_call().function_name.getText()).executable;
            if (e instanceof Method m) {
                Type genericReturnType = m.getGenericReturnType();
                if (genericReturnType instanceof ParameterizedType p) {
                    if (p.getActualTypeArguments().length == 1) {
                        variable.setGenericType((Class) p.getActualTypeArguments()[0]);
                    }
                }
            }
        }

        addInsn(variable.store());
        return scriptContext;
    }

    @Override
    public ScriptContext visitGetField_statement(ntsParser.GetField_statementContext ctx) {
        String fieldName = ctx.field.getText();
        Variable variable = scriptContext.getVariable(ctx.fieldOwner.getText()).orElseThrow(() -> new RuntimeException("Unknown variable " + ctx.fieldOwner.getText()));
        addInsn(variable.load());
        String variableName = ctx.fieldOwner.getText();

        Variable c = scriptContext.currentScope().lastVariableOnStack;

        //when we accessing function param
        if (c == null) {
            c = scriptContext.currentScope().findVariable(ctx.fieldOwner.getText());
        }
        Variable fieldOwner = scriptContext.getVariable(variableName).get();

        try {
            Field field = fieldOwner.getRuntimeType().getField(fieldName);
            if (!Modifier.isPublic(field.getModifiers())) {
                throw new NoSuchFieldException();
            }
            addInsn(FieldAccess.forField(new FieldDescription.InDefinedShape.ForLoadedField(field)).read());
            return scriptContext;
        } catch (NoSuchFieldException e) {
            Method[] declaredMethods = fieldOwner.getRuntimeType().getMethods();
            for (Method declaredMethod : declaredMethods) {
                if (Modifier.isPublic(declaredMethod.getModifiers())) {
                    if (declaredMethod.getParameters().length == 0) {
                        String mName = declaredMethod.getName();
                        if (mName.equalsIgnoreCase(fieldName) || mName.equalsIgnoreCase("get"+fieldName)) {
                            addInsn(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(declaredMethod)));
                            return scriptContext;
                        }
                    }
                }
            }
        }
        throw new RuntimeException("Unknown field " + c.getRuntimeType().getSimpleName() + "." + fieldName + ", getter method not found either");
    }

    @Override
    public ScriptContext visitPutField_statement(ntsParser.PutField_statementContext ctx) {

        String fieldName = ctx.field.getText();
        Variable variable = scriptContext.getVariable(ctx.fieldOwner.getText()).get();
        addInsn(variable.load());
        String variableName = ctx.fieldOwner.getText();

        visit(ctx.rval());
        Variable c = scriptContext.currentScope().lastVariableOnStack;
        if (c == null) {
            c = scriptContext.currentScope().findVariable(ctx.fieldOwner.getText());
        }

        Variable fieldOwner = scriptContext.getVariable(variableName).get();
        try {
            Field field = fieldOwner.getRuntimeType().getField(fieldName);

            if (!Modifier.isPublic(field.getModifiers())) {
                throw new NoSuchFieldException();
            }
            if (c != null && c.getRuntimeType() != field.getType() && c.getRuntimeType().isPrimitive()) {
                addInsn(TypeCasts.castPrimitive(c.getRuntimeType(), field.getType()));
            }

            addInsn(FieldAccess.forField(new FieldDescription.InDefinedShape.ForLoadedField(field)).write());
            return scriptContext;
        } catch (NoSuchFieldException e) {
            //assume setter
            Method[] declaredMethods = fieldOwner.getRuntimeType().getMethods();
            for (Method declaredMethod : declaredMethods) {
                if (Modifier.isPublic(declaredMethod.getModifiers())) {
                    if (declaredMethod.getParameters().length == 1) {
                        String mName = declaredMethod.getName();
                        if (mName.equalsIgnoreCase(fieldName) || mName.equalsIgnoreCase("set"+fieldName)) {
                            Class<?> type = declaredMethod.getParameters()[0].getType();
                            if (c != null && c.getRuntimeType() !=  type && c.getRuntimeType().isPrimitive()) {
                                addInsn(TypeCasts.castPrimitive(c.getRuntimeType(), type));
                            }

                            addInsn(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(declaredMethod)));
                            return scriptContext;
                        }
                    }
                }
            }
        }
        throw new RuntimeException("Unknown field " + c.getRuntimeType().getSimpleName() + "." + fieldName + ", setter method not found either");
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
    public ScriptContext visitType_double(ntsParser.Type_doubleContext ctx) {
        String text = ctx.getText();
        addInsn(DoubleConstant.forValue(Double.parseDouble(text)));
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
            scriptContext.currentScope().lastVariableOnStack = variable1;
        } else {
            throw new RuntimeException("unknown variable reference " + text);
        }
        return scriptContext;
    }

    @Override
    public ScriptContext visitTerminal(TerminalNode node) {
        return super.visitTerminal(node);
    }

    @Override
    public ScriptContext visitRval(ntsParser.RvalContext ctx) {
        String text = ctx.getText();
        if (ctx.left == null) {
            visitChildren(ctx);
        } else {
            var left = ctx.left;
            visit(left);
            var right = ctx.right;
            visit(right);
            var op = ctx.op;
            StackManipulation sm = switch (op.getText()) {
                case "+" -> Addition.DOUBLE;
                case "-" -> Subtraction.DOUBLE;
                case "*" -> Multiplication.DOUBLE;
                case "/" -> Division.DOUBLE;
                default -> throw new RuntimeException("Unknown operation " + op.getText());
            };
            addInsn(sm);
        }
        return scriptContext;
    }

    @Override
    public ScriptContext visitReturn_statement(ntsParser.Return_statementContext ctx) {
        var rtype = ctx.rval();


        if (rtype.type_enum() != null || rtype.type_literal() != null) {
            visitChildren(rtype);
            addInsn(MethodReturn.REFERENCE);

        } else if (rtype.type_bool() != null) {
            visitChildren(rtype.type_bool());
            addInsn(MethodReturn.INTEGER);
        } else if (rtype.type_double() != null) {
            visitChildren(rtype.type_double());
            addInsn(MethodReturn.DOUBLE);

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
        Optional<Variable> variable = scriptContext.getVariable("@" + functionName);
        if (variable.isPresent()) {
            Variable variable1 = variable.get();
            if (variable1.getRuntimeType() != null && Runnable.class.isAssignableFrom(variable1.getRuntimeType())) {
                try {
                    addInsn(variable1.load());
                    Method run = Runnable.class.getDeclaredMethod("run");
                    addInsn(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(run)));
                } catch (NoSuchMethodException e) {
                    e.printStackTrace();
                }
                return scriptContext;
            }
        }
        Descriptor d = scriptContext.findExecutableElement(functionName);
        Parameter[] parameters = d.executable.getParameters();

        if (d.executable instanceof Constructor c) {
            addInsn(new New(c.getDeclaringClass()));
            addInsn(Duplication.SINGLE);
        } else if (d.injectedViaField) {
            addInsn(MethodVariableAccess.loadThis());

            FieldDescription.InDefinedShape field = scriptContext.getInsnType().getDeclaredFields()
                    .filter(ElementMatchers.named(d.executable.getDeclaringClass().getSimpleName()))
                    .getOnly();

            addInsn(FieldAccess.forField(field).read());
        }
        int i = 0;
        for (Parameter parameter : parameters) {
            String paramName = d.namedParams.get(i);
            i++;
            ntsParser.ArgumentContext argument = findArgumentForNamedParam(ctx.argument(), paramName);
            if (argument == null) {
                scriptContext.log("Call " + functionName + " is missing value for parameter " + paramName + ", will fallback to default");
                //defaults
                if (parameter.getType() == int.class || parameter.getType() == boolean.class) {
                    addInsn(IntegerConstant.forValue(0));
                } else if (parameter.getType() == double.class) {
                    addInsn(DoubleConstant.forValue(0));
                } else if (parameter.getType() == float.class) {
                    addInsn(FloatConstant.forValue(0));
                } else if (Object.class.isAssignableFrom(parameter.getType())) {
                    addInsn(NullConstant.INSTANCE);
                }
            } else {


                ntsParser.RvalContext value = argument.value;
                String name = argument.name.getText();


                visit(value);

                //typecasts
                //todo this should be better, maybe keep track of last loaded offset on the stack and eventually cast
                handleTypecasts(parameter);
            }
        }

        if (d.executable instanceof Constructor c) {

            addInsn(MethodInvocation.invoke(new MethodDescription.ForLoadedConstructor(c)));
            if (ctx.getParent() instanceof ntsParser.StatementContext) {
                addInsn(Removal.SINGLE);
            }
            ntsParser.Assignment_statementContext parent = null;
            ParserRuleContext prc = ctx.getParent();
            while (prc != null) {
                prc = prc.getParent();
                if (prc instanceof ntsParser.Assignment_statementContext a) {
                    parent = a;
                    break;
                }
            }
            if (parent != null) {
                Variable variable1 = scriptContext.currentScope().findVariable(parent.VARIABLE_IDENTIFIER().getText());
                variable1.setRuntimeType(c.getDeclaringClass());
            }
        } else {
            Method method = (Method) d.executable;
            addInsn(MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(method)));
            if (method.getReturnType() != void.class && ctx.getParent() instanceof ntsParser.StatementContext) {
                addInsn(Removal.SINGLE);
            }
        }

        Token type_cast = ctx.type_cast;
        if (type_cast != null) {
            String text = type_cast.getText();
            Class typeBySimpleName = scriptContext.findTypeBySimpleName(text);
            addInsn(TypeCasts.checkCast(typeBySimpleName));
        }

        return scriptContext;
    }

    private void handleTypecasts(Parameter parameter) {
        Variable c = scriptContext.currentScope().lastVariableOnStack;
        Class rType = c == null ? null : c.getRuntimeType();

        StackManipulation stackManipulation = getImpl().currentScope().impl.get(getImpl().currentScope().impl.size() - 1);
        if (stackManipulation.toString().contains("DoubleConstant")) {
            rType = double.class;
        }
        if (rType == null) {
            return;
        }

        if (parameter.getType() == boolean.class) {
            return;
        }

        if (rType == boolean.class) {
            scriptContext.currentScope().lastVariableOnStack = null;
            return;
        }

        if (parameter.getType().isPrimitive() && rType.isPrimitive()) {
            if (parameter.getType() != rType) {
                TypeCasts.Cast cast = TypeCasts.castPrimitive(rType, parameter.getType());
                addInsn(cast);
            }
        }

        if (rType != parameter.getType() && c!=null&& c.getGenericType() != null) {
            addInsn(TypeCasts.checkCast(c.getGenericType()));
        }
        if (Number.class.isAssignableFrom(rType)) {
            try {
                MethodInvocation.WithImplicitInvocationTargetType v = null;
                if (parameter.getType() == int.class) {
                    v = MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(Number.class.getDeclaredMethod("intValue")));
                } else if (parameter.getType() == double.class) {
                    v = MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(Number.class.getDeclaredMethod("doubleValue")));
                } else if (parameter.getType() == float.class) {
                    v = MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(Number.class.getDeclaredMethod("floatValue")));
                } else if (parameter.getType() == long.class) {
                    v = MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(Number.class.getDeclaredMethod("longValue")));
                }
                addInsn(v);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        scriptContext.currentScope().lastVariableOnStack = null;
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

            //todo generify to typecast
            //TypeCasts.checkCast(nextObj.assumeGenericType());

            if (ctx.iterable().variable_reference() != null) {
                Variable var = scriptContext.currentScope().findVariable(ctx.iterable().variable_reference().getText());
                if (var.getGenericType() != null) {
                    addInsn(TypeCasts.checkCast(var.getGenericType()));
                    nextObj.setRuntimeType(var.getGenericType());
                }
            } else if (ctx.iterable().function_call() != null) {
                Executable executableElement = scriptContext.findExecutableElement(ctx.iterable().function_call().function_name.getText()).executable;
                Type[] genericParameterTypes = executableElement.getGenericParameterTypes();
                if (genericParameterTypes.length == 1) {
                    addInsn(TypeCasts.checkCast((Class) genericParameterTypes[0]));
                    nextObj.setRuntimeType((Class) genericParameterTypes[0]);
                }
            }

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

        addInsn(MethodVariableAccess.loadThis()); //some kind of jvm magic for syntethic methods

        for (Variable fnVar : fnVars.values()) {
            addInsn(fnVar.load());
        }


        Scope currentScope = scriptContext.currentScope();
        Scope scope = scriptContext.createNewScopeWithVars(fnVars, currentScope);

        addInsn(new InvokeDynamic(scriptContext, fnVars, scope.id));

        scriptContext.startScope(scope);
        visitChildren(ctx.statement_list());
        addInsn(MethodReturn.VOID);
        scriptContext.endScope(scope);

        return scriptContext;
    }

    private ntsParser.ArgumentContext findArgumentForNamedParam(List<ntsParser.ArgumentContext> argument, String value) {
        for (ntsParser.ArgumentContext argumentContext : argument) {
            String text = argumentContext.name.getText();
            if ("".equalsIgnoreCase(argumentContext.value.getText())) {
                continue;
            }
            String[] split = value.split("\\|");
            for (String s : split) {
                if (text.equalsIgnoreCase(s)) {
                    return argumentContext;
                }
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
