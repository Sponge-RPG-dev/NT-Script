package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;
import cz.neumimto.nts.bytecode.Variable;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;

import java.lang.reflect.*;
import java.util.*;
import java.util.function.Consumer;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;


import static cz.neumimto.nts.annotations.ScriptMeta.Function;
import static cz.neumimto.nts.annotations.ScriptMeta.Handler;


public class ScriptContext {

    public Consumer<String> loggerDataConsumer;
    private List<Scope> scopes = new ArrayList<>();
    private Scope current;
    private final Collection<Descriptor> mechanics;
    private final Set<Class<?>> enums;
    private final Set<Class<?>> typesSimpleName = new HashSet<>();;
    private TypeDescription insnType;

    public ScriptContext(LinkedHashMap<String, Variable> variables, Collection<Object> mechanics, Set<Class<?>> enums, Consumer<String> loggerDataProvider) {
        this.scopes.add(new Scope(variables, Collections.emptyList(), null));
        this.current = scopes.get(0);
        this.mechanics = remap(mechanics);
        this.enums = enums;
        this.loggerDataConsumer = loggerDataProvider;
    }

    private List<Descriptor> remap(Collection<Object> mechanics) {
        List<Descriptor> d = new ArrayList<>();

        outer: for (Object mechanic : mechanics) {


            if (mechanic instanceof Descriptor de) {
                d.add(de);
                continue;
            }

            if (mechanic instanceof Class<?> c) {
                typesSimpleName.add(c);
                String i = "";
                if (c.isAnnotationPresent(Function.class)) {
                    i += c.getAnnotation(Function.class).value();
                }
                for (Constructor<?> constructor : c.getConstructors()) {
                    Descriptor descriptor = annotatedExecutableToDescriptor(constructor, i);
                    if (descriptor != null) {
                        d.add(descriptor);
                    }
                }
            }

            String i = "";
            if (mechanic.getClass().isAnnotationPresent(Function.class)) {
                i += mechanic.getClass().getAnnotation(Function.class).value();
            }
            for (Method declaredMethod : mechanic.getClass().getDeclaredMethods()) {
                Descriptor descriptor = annotatedExecutableToDescriptor(declaredMethod, i);
                if (descriptor != null) {
                    d.add(descriptor);
                }
            }

        }
        return d;
    }

    private Descriptor annotatedExecutableToDescriptor(Executable e, String fn) {
        if (e.isAnnotationPresent(Function.class)) {
            fn += e.getAnnotation(Function.class).value();
        }

        if (e.isAnnotationPresent(Handler.class)) {
            Parameter[] parameters = e.getParameters();
            var list =Stream.of(parameters)
                    .filter(p->p.isAnnotationPresent(ScriptMeta.NamedParam.class))
                    .map(p->p.getAnnotation(ScriptMeta.NamedParam.class).value())
                    .collect(Collectors.toList());
            return new Descriptor(e,fn, list, true);
        }
        return null;
    }

    public List<Scope> getScopes() {
        return scopes;
    }

    public Descriptor findExecutableElement(String functionName) {
        for (Descriptor mechanic : mechanics) {
            if (mechanic.functionName.equalsIgnoreCase(functionName)) {
                return mechanic;
            }
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
        var.setGenericType(getGenericWrappedType(type));
        currentScope().variables.put(variable, var);
        return var;
    }

    private Class getGenericWrappedType(ntsParser.Assignment_valuesContext type) {
        if (type.rval() == null || type.rval().function_call() == null) {
            return null;
        }
        String fnName = type.rval().function_call().function_name.getText();
        Executable executableElement = findExecutableElement(fnName).executable;
        if (executableElement instanceof Method m) {
            Type genericReturnType = m.getGenericReturnType();
            if (type instanceof ParameterizedType p) {
                return (Class) p.getActualTypeArguments()[0];
            }
        }
        return null;
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
            String fnName = rval.function_call().function_name.getText();
            Executable executableElement = findExecutableElement(fnName).executable;
            if (executableElement instanceof Method m) {
                if (m.getReturnType() == void.class) {
                    return null;
                }
                return MethodVariableAccess.of(new TypeDescription.ForLoadedType(m.getReturnType()));
            }
            return MethodVariableAccess.REFERENCE;
        } else if (rval.type_bool() != null) {
            return MethodVariableAccess.INTEGER;
        } else if (rval.type_comparison() != null) {
            return MethodVariableAccess.INTEGER;
        } else if (rval.variable_reference() != null) {
            return MethodVariableAccess.of(new TypeDescription.ForLoadedType(currentScope().variables.get(rval.getText()).getRuntimeType()));
        } else if (rval.getField_statement() != null) {
            String fieldOwnerVar = rval.getField_statement().fieldOwner.getText();
            Variable variable = currentScope().variables.get(fieldOwnerVar);

            String fName = rval.getField_statement().field.getText();

            Field[] fields = variable.getRuntimeType().getDeclaredFields();

            for (Field f : fields) {
                if (Modifier.isPublic(f.getModifiers())) {
                    if (f.getName().equalsIgnoreCase(fName)) {
                        return MethodVariableAccess.of(new TypeDescription.ForLoadedType(f.getType()));
                    }
                }
            }

            Optional<Variable> o = getVariable(fieldOwnerVar);
            if (o.isEmpty()) {
                throw new RuntimeException("Unknown variabble " + fieldOwnerVar);
            }
            String fieldName = rval.getField_statement().field.getText();
            for (Method declaredMethod : o.get().getRuntimeType().getDeclaredMethods()) {
                if (Modifier.isPublic(declaredMethod.getModifiers())) {
                    if (declaredMethod.getParameters().length == 0) {
                        String mName = declaredMethod.getName();
                        if (mName.equalsIgnoreCase(fieldName) || mName.equalsIgnoreCase("get"+fieldName)) {
                            return MethodVariableAccess.of(new TypeDescription.ForLoadedType(declaredMethod.getReturnType()));
                        }
                    }
                }
            }

        } else if (rval.op != null || containsArithmeticalSign(rval.getText())){
            return MethodVariableAccess.DOUBLE;
        }
        throw new RuntimeException("Unknown type " + rval.getText());
    }

    public static boolean containsArithmeticalSign(String input) {
        return containsAny(input, "+", "-", "*", "/");
    }

    public static boolean containsAny(String inputStr, String... items) {
        return Arrays.stream(items).anyMatch(inputStr::contains);
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
            String fnName = rval.function_call().function_name.getText();
            Executable executableElement = findExecutableElement(fnName).executable;

            if (executableElement instanceof Method m) {
                if (m.getReturnType() == void.class) {
                    return null;
                }

                if (rval.function_call().type_cast != null) {
                    String text = rval.function_call().type_cast.getText();
                    Optional<Descriptor> first = mechanics.stream().filter(a -> a.getClass().getSimpleName().equalsIgnoreCase(text)).findFirst();
                    if (first.isPresent()) {
                        Descriptor descriptor = first.get();
                        return descriptor.executable.getClass();
                    } else {
                        Class typeBySimpleName = findTypeBySimpleName(text);
                        if (typeBySimpleName != null) {
                            return typeBySimpleName;
                        }
                        try {
                            return Class.forName(text);
                        } catch (ClassNotFoundException e) {
                            log("Unknown type " + text);
                        }
                    }
                }

                return m.getReturnType();
            }
            return null;
        } else if (rval.type_bool() != null) {
            return boolean.class;
        } else if (rval.variable_reference() != null) {
            return currentScope().findVariable(rval.getText()).getRuntimeType();
        } else if (rval.type_comparison() != null) {
            return double.class;
        } else if (rval.getField_statement() != null) {
            String fieldOwnerVar = rval.getField_statement().fieldOwner.getText();
            Variable variable = currentScope().variables.get(fieldOwnerVar);

            String fName = rval.getField_statement().field.getText();

            Field[] fields = variable.getRuntimeType().getDeclaredFields();

            if (rval.getField_statement().type_cast != null) {
                String text = rval.getField_statement().type_cast.getText();
                Optional<Descriptor> first = mechanics.stream().filter(a -> a.getClass().getSimpleName().equalsIgnoreCase(text)).findFirst();
                if (first.isPresent()) {
                    Descriptor descriptor = first.get();
                    return descriptor.executable.getClass();
                } else {
                    try {
                        return Class.forName(text);
                    } catch (ClassNotFoundException e) {
                        log("Unknown type " + text);
                    }
                }
            }

            for (Field f : fields) {
                if (Modifier.isPublic(f.getModifiers())) {
                    if (f.getName().equalsIgnoreCase(fName)) {
                        return f.getType();
                    }
                }
            }

            Optional<Variable> o = getVariable(fieldOwnerVar);
            if (o.isEmpty()) {
                throw new RuntimeException("Unknown variabble " + fieldOwnerVar);
            }
            String fieldName = rval.getField_statement().field.getText();
            for (Method declaredMethod : o.get().getRuntimeType().getDeclaredMethods()) {
                if (Modifier.isPublic(declaredMethod.getModifiers())) {
                    if (declaredMethod.getParameters().length == 0) {
                        String mName = declaredMethod.getName();
                        if (mName.equalsIgnoreCase(fieldName) || mName.equalsIgnoreCase("get"+fieldName)) {
                            return declaredMethod.getReturnType();
                        }
                    }
                }
            }


        } else if (rval.op != null ||ScriptContext.containsArithmeticalSign(rval.getText())) {
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

    public void log(String s) {
        if (loggerDataConsumer != null) {
            loggerDataConsumer.accept(s);
        }
    }

    public Class findTypeBySimpleName(String text) {
        for (Class<?> aClass : typesSimpleName) {
            if (aClass.getSimpleName().equalsIgnoreCase(text)) {
                return aClass;
            }
            ScriptMeta.SimpleName annotation = aClass.getAnnotation(ScriptMeta.SimpleName.class);
            if (annotation != null && annotation.value().equalsIgnoreCase(text)) {
                return aClass;
            }
        }
        try {
            return Class.forName(text);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Unknown type " + text);
        }
    }
}
