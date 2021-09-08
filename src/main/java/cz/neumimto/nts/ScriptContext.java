package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;
import cz.neumimto.nts.bytecode.Variable;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;

import java.lang.reflect.Method;
import java.util.*;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

public class ScriptContext {
    private Scope rootSccpe;
    private Set<Scope> subScopes = new HashSet<>();

    private final Collection<Object> mechanics;
    private final Set<Class<?>> enums;
    private InstrumentedType insnType;

    public ScriptContext(HashMap<String, Variable> variables, Collection<Object> mechanics, Set<Class<?>> enums) {
        this.rootSccpe = new Scope(variables);
        this.mechanics = mechanics;
        this.enums = enums;
    }

    public Method findHandler(Object mechanic, String functionName) {
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

    public Object findMechanic(String functionName) {
        String rootVal = "";
        for (Object mechanic : mechanics) {
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


    public Optional<Variable> getVariable(String variable) {
        return Optional.ofNullable(rootSccpe.variables.get(variable));
    }

    public Variable createNewVariable(String variable, ntsParser.RvalContext type) {
        var var = new Variable(rootSccpe.getNextVariableOffset(), getRalReturnType(type));
        rootSccpe.variables.put(variable, var);
        return var;
    }

    public Variable createNewVariable(String variable) {
        var var = new Variable(rootSccpe.getNextVariableOffset(), MethodVariableAccess.REFERENCE);
        rootSccpe.variables.put(variable, var);
        return var;
    }

    protected MethodVariableAccess getRalReturnType(ntsParser.RvalContext rval) {
        if (rval.type_literal() != null) {
            return MethodVariableAccess.REFERENCE;
        } else if (rval.type_integer() != null) {
            return MethodVariableAccess.INTEGER;
        } else if (rval.function_call() != null) {
            return MethodVariableAccess.REFERENCE;
        } else if (rval.type_bool() != null) {
            return MethodVariableAccess.INTEGER;
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

    public void setInsnType(InstrumentedType insnType) {
        this.insnType = insnType;
    }

    public InstrumentedType getInsnType() {
        return insnType;
    }
}
