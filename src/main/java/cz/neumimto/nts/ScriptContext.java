package cz.neumimto.nts;

import cz.neumimto.nts.bytecode.Variable;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;

import javax.swing.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.util.*;


import static cz.neumimto.nts.annotations.ScriptMeta.Function;
import static cz.neumimto.nts.annotations.ScriptMeta.Handler;


public class ScriptContext {

    private List<Scope> scopes = new ArrayList<>();
    private Scope current;
    private final Collection<Object> mechanics;
    private final Set<Class<?>> enums;
    private TypeDescription insnType;

    public ScriptContext(LinkedHashMap<String, Variable> variables, Collection<Object> mechanics, Set<Class<?>> enums) {
        this.scopes.add(new Scope(variables, Collections.emptyList(), null));
        this.current = scopes.get(0);
        this.mechanics = mechanics;
        this.enums = enums;
    }

    public List<Scope> getScopes() {
        return scopes;
    }


    public static Executable findHandler(Object mechanic, String functionName) {
        Class<?> mClass = mechanic.getClass();
        String rootVal = mClass.isAnnotationPresent(Function.class) ? mClass.getAnnotation(Function.class).value() : "";
        for (Method declaredMethod : mClass.getDeclaredMethods()) {
            if (declaredMethod.isAnnotationPresent(Function.class)) {
                rootVal += declaredMethod.getAnnotation(Function.class).value();
            }
            if (declaredMethod.isAnnotationPresent(Handler.class) && rootVal.equalsIgnoreCase(functionName)) {
                return declaredMethod;
            }
        }
        throw new RuntimeException("Mechanic is missing @Handler function " + mClass);
    }


    public Executable findExecutableElement(String functionName) {
        String rootVal;
        for (Object mechanic : mechanics) {
            rootVal = "";
            if (mechanic instanceof Class<?> c) {

                String i = rootVal;
                if (c.isAnnotationPresent(Function.class)) {
                    i += c.getAnnotation(Function.class).value();
                }
                for (Constructor<?> constructor : c.getConstructors()) {
                    String fn = i;
                    if (constructor.isAnnotationPresent(Function.class)) {
                        fn += constructor.getAnnotation(Function.class).value();
                    }

                    if (constructor.isAnnotationPresent(Handler.class) && functionName.equalsIgnoreCase(fn)) {
                        return constructor;
                    }
                }
            } else {
                String i = rootVal;

                if (mechanic.getClass().isAnnotationPresent(Function.class)) {
                    i += mechanic.getClass().getAnnotation(Function.class).value();
                }
                for (Method declaredMethod : mechanic.getClass().getDeclaredMethods()) {
                    String fn = i;

                    if (declaredMethod.isAnnotationPresent(Function.class)) {
                        fn += declaredMethod.getAnnotation(Function.class).value();
                    }
                    if (declaredMethod.isAnnotationPresent(Handler.class) && functionName.equalsIgnoreCase(fn)) {
                        return declaredMethod;
                    }
                }
            }
        }
        throw new RuntimeException("Unknown mechanic " + functionName);
    }

    @Deprecated
    public static Object findMechanic(String functionName, Collection<Object> mechanics) {
        String rootVal = "";
        for (Object mechanic : mechanics) {
            rootVal = "";
            if (mechanic.getClass().isAnnotationPresent(Function.class)) {
                rootVal = mechanic.getClass().getAnnotation(Function.class).value();
            }
            if (functionName.equalsIgnoreCase(rootVal)) {
                return mechanic;
            }
            try {
                findHandler(mechanic, functionName);
                return mechanic;
            } catch (RuntimeException e) {}
        }
        throw new RuntimeException("Unknown mechanic " + functionName);
    }

    public Scope currentScope() {
        return current;
    }

    public Optional<Variable> getVariable(String variable) {
        return Optional.ofNullable(currentScope().findVariable(variable));
    }

    public Variable createNewVariable(String variable, ntsParser.Assignment_valuesContext type) {
        var var = new Variable(currentScope().getNextVariableOffset(), getRalReturnType(type), getRalRuntimeType(type));
        currentScope().variables.put(variable, var);
        return var;
    }

    public Variable createNewVariable(String variable) {
        var var = new Variable(currentScope().getNextVariableOffset(), MethodVariableAccess.REFERENCE, null);
        currentScope().variables.put(variable, var);
        return var;
    }

    protected MethodVariableAccess getRalReturnType(ntsParser.Assignment_valuesContext val) {
        if (val.lambda() != null) {
            return MethodVariableAccess.REFERENCE;
        }
        ntsParser.RvalContext rval = val.rval();
        if (rval.type_literal() != null) {
            return MethodVariableAccess.REFERENCE;
        } else if (rval.type_double() != null) {
            return MethodVariableAccess.DOUBLE;
        } else if (rval.function_call() != null) {
            return MethodVariableAccess.REFERENCE;
        } else if (rval.type_bool() != null) {
            return MethodVariableAccess.INTEGER;
        } else if (rval.type_comparison() != null) {
            return MethodVariableAccess.INTEGER;
        } else if (rval.variable_reference() != null) {
            return MethodVariableAccess.of(new TypeDescription.ForLoadedType(currentScope().variables.get(rval.getText()).getRuntimeType()));
        }
        throw new RuntimeException("Unknown type " + rval.getText());
    }

    private Class getRalRuntimeType(ntsParser.Assignment_valuesContext val) {
        if (val.lambda() != null) {
            return Runnable.class;
        }
        ntsParser.RvalContext rval = val.rval();
        if (rval.type_literal() != null) {
            return String.class;
        } else if (rval.type_double() != null) {
            return double.class;
        } else if (rval.function_call() != null) {
            return null;
        } else if (rval.type_bool() != null) {
            return boolean.class;
        } else if (rval.variable_reference() != null) {
            return currentScope().findVariable(rval.getText()).getRuntimeType();
        } else if (rval.type_comparison() != null) {
            return double.class;
        }
        throw new RuntimeException("Unknown type " + rval.getText());
    }

    public Enum getEnumValue(String type, String value) {
        for (Class anEnum : enums) {
            if (anEnum.getSimpleName().equalsIgnoreCase(type)) {
                return Enum.valueOf(anEnum, value);
            }
        }
        throw new RuntimeException("Unknown enum value " + type + "." + value);
    }

    public void setInsnType(TypeDescription insnType) {
        this.insnType = insnType;
    }

    public TypeDescription getInsnType() {
        return insnType;
    }


    public void endScope(Scope scope) {
        this.current = scope.parent;
    }

    public void startScope(Scope scope) {
        this.current = scope;
    }

    public Scope createNewScopeWithVars(Map<String, Variable> fnVars, Scope currentScope) {
        LinkedHashMap<String, Variable> fixedOffsets = new LinkedHashMap<>();


        int offset = 1;
        for (Map.Entry<String, Variable> e : fnVars.entrySet()) {
            fixedOffsets.put(e.getKey(), e.getValue().copyWithNewOffset(offset)); //(0 THIS)
            offset += e.getValue().getOffsetSize();
        }

        var scope = new Scope(fixedOffsets, Collections.emptyList(), currentScope);
        scope.fnVars = fnVars;
        scope.id = scopes.size() - 1;
        scopes.add(scope);
        return scope;
    }
}
