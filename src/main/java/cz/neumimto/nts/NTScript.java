package cz.neumimto.nts;


import cz.neumimto.nts.annotations.ScriptMeta;
import cz.neumimto.nts.bytecode.FnVisitor;
import cz.neumimto.nts.bytecode.Variable;
import cz.neumimto.nts.bytecode.VisitorImpl;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.description.annotation.AnnotationDescription;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.ClassVisitor;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.matcher.ElementMatchers;
import net.bytebuddy.pool.TypePool;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Executable;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static net.bytebuddy.jar.asm.Opcodes.ACC_PRIVATE;
import static net.bytebuddy.jar.asm.Opcodes.ACC_SYNTHETIC;

@SuppressWarnings("unchecked")
public class NTScript {


    private final Set<Object> fns;
    private final Class<?> implementingType;
    private final String packagee;
    private String classNamePattern;
    private Set<Class<?>> enums;
    private Class<? extends Annotation>[] fieldAnnotations;
    private Class<? extends Annotation>[] classAnnotations;
    private String debugOutput;
    private int generated = 0;
    private Map<String, String> macros;

    private NTScript(Set<Object> fns,
                     Class<?> implementingType,
                     String packagee,
                     String classNamePattern,
                     Set<Class<?>> enums,
                     Class<? extends Annotation>[] fieldAnnotations,
                     Class<? extends Annotation>[] classAnnotations,
                     String debugOutput,
                     Map<String, String> macros) {
        this.macros = macros;
        this.fns = fns;
        this.implementingType = implementingType;
        this.packagee = packagee;
        this.classNamePattern = classNamePattern;
        this.enums = enums;
        this.fieldAnnotations = fieldAnnotations;
        this.classAnnotations = classAnnotations;
        this.debugOutput = debugOutput;
    }


    public Class compile(String input) {
        for (Map.Entry<String, String> en : macros.entrySet()) {
            Pattern compile = Pattern.compile(en.getKey());
            Matcher matcher = compile.matcher(input);
            if (matcher.matches()) {
                if (matcher.groupCount() == 0) {
                    input = input.replaceAll(en.getKey(), en.getValue());
                } else {
                    int i = 1;
                    String b = en.getValue();
                    while (matcher.groupCount() <= i) {
                        b = b.replaceAll("\\$"+i, matcher.group(i));
                        i++;
                    }
                    input = input.replaceAll(en.getKey(), b);
                }
            }
        }
        CharStream charStream = new ANTLRInputStream(input);
        var lexer = new ntsLexer(charStream);
        var stream = new CommonTokenStream(lexer);
        var parser = new ntsParser(stream);

        var fnVisitor = new FnVisitor();
        ntsParser.ScriptContext script = parser.script();
        fnVisitor.visit(script);

        List<String> functions = fnVisitor.getFunctions();

        ScriptContext temp = new ScriptContext(new HashMap<>(), fns, enums);

        Set<Class<?>> requiredFns = findRequiredFns(temp, functions);


        ByteBuddy byteBuddy = new ByteBuddy();

        DynamicType.Builder<?> bb = null;
        if (implementingType.isInterface()) {
            bb = byteBuddy.subclass(Object.class).implement(implementingType);
        } else {
            bb = byteBuddy.subclass(implementingType);
        }

        bb = bb.name(packagee + "" + classNamePattern + generated)
                .visit(new AsmVisitorWrapper() {
                    @Override
                    public int mergeWriter(int flags) {
                        return flags | ClassWriter.COMPUTE_FRAMES;
                    }

                    @Override
                    public int mergeReader(int flags) {
                        return flags | ClassWriter.COMPUTE_FRAMES;
                    }

                    @Override
                    public ClassVisitor wrap(TypeDescription instrumentedType, ClassVisitor classVisitor, Implementation.Context implementationContext, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fields, MethodList<?> methods, int writerFlags, int readerFlags) {
                        return classVisitor;
                    }
                });

        if (classAnnotations != null) {
            for (Class<? extends Annotation> classAnnotation : classAnnotations) {
                AnnotationDescription build = AnnotationDescription.Builder.ofType(classAnnotation).build();
                bb = bb.annotateType(build);
            }
        }


        generated++;

        for (Class<?> requiredFn : requiredFns) {
            DynamicType.Builder.FieldDefinition.Optional.Valuable<?> dbfv = bb.defineField(requiredFn.getSimpleName(), requiredFn, Opcodes.ACC_PUBLIC);

            DynamicType.Builder.FieldDefinition.Optional<?> dbf = null;
            if (fieldAnnotations != null) {
                for (Class<? extends Annotation> fieldAnnotation : fieldAnnotations) {
                    AnnotationDescription build = AnnotationDescription.Builder.ofType(fieldAnnotation).build();
                    dbf = dbfv.annotateField(build);
                }
            }
            bb = dbf == null ? dbfv : dbf;
        }

        var visitor = new VisitorImpl(new ScriptContext(
                getImplementingMethodParams(),
                fns,
                this.enums));


        visitor.getScriptContext().setInsnType(bb.toTypeDescription());
        visitor.visit(script);

        List<Scope> scopes = visitor.getImpl().getScopes();

        for (int i = scopes.size()-1; i > 0; i--) {
            Scope scope = scopes.get(i);

            List<TypeDescription> params = new ArrayList<>();

            //params.add(typeDefinitions);
            for (Variable value : scope.fnVars.values()) {
                params.add(new TypeDescription.ForLoadedType(value.getRuntimeType()));
            }

            bb = bb.defineMethod(Scope.LAMBDA_METHOD_NAME.apply(i - 1), void.class,
                    ACC_PRIVATE | ACC_SYNTHETIC )
                    .withParameters(params)
                    .intercept(new Implementation() {
                        @Override
                        public ByteCodeAppender appender(Target implementationTarget) {
                            return (methodVisitor, implementationContext, instrumentedMethod) -> {

                                StackManipulation.Size size = new StackManipulation.Compound(
                                        scope.impl
                                ).apply(methodVisitor, implementationContext);

                                return new ByteCodeAppender.Size(size.getMaximalSize(), instrumentedMethod.getStackSize());
                            };
                        }

                        @Override
                        public InstrumentedType prepare(InstrumentedType instrumentedType) {
                            return instrumentedType;
                        }
                    });
            visitor.getScriptContext().setInsnType(bb.toTypeDescription());
        }

        bb = bb.method(ElementMatchers.isAnnotatedWith(ScriptMeta.ScriptTarget.class))
                .intercept(getImplementation(visitor));

        var make =  bb.make();
        if (debugOutput != null) {
            try {
                make.saveIn(new File(debugOutput));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return make.load(this.getClass().getClassLoader()).getLoaded();
    }

    private Implementation getImplementation(VisitorImpl visitor) {
        return new Implementation() {
            @Override
            public ByteCodeAppender appender(Target implementationTarget) {
                return (methodVisitor, implementationContext, instrumentedMethod) -> {

                    List<StackManipulation> impl = visitor.getImpl().getScopes().get(0).impl;

                    StackManipulation.Size size = new StackManipulation.Compound(
                            impl
                    ).apply(methodVisitor, implementationContext);

                    return new ByteCodeAppender.Size(size.getMaximalSize(), instrumentedMethod.getStackSize());
                };
            }

            @Override
            public InstrumentedType prepare(InstrumentedType instrumentedType) {
                return instrumentedType;
            }
        };
    }

    private HashMap<String, Variable> getImplementingMethodParams() {

        var map = new HashMap<String, Variable>();

        Optional<Method> first = Stream.of(implementingType.getDeclaredMethods())
                .filter(m -> m.isAnnotationPresent(ScriptMeta.ScriptTarget.class)).findFirst();

        if (first.isEmpty()) {
            throw new RuntimeException("No method annotated with @ScriptTarget");
        }
        Parameter[] parameters = first.get().getParameters();

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            ScriptMeta.NamedParam annotation = parameter.getAnnotation(ScriptMeta.NamedParam.class);
            if (annotation != null) {
                String value = annotation.value();
                Class<?> type = parameter.getType();
                MethodVariableAccess opcode = MethodVariableAccess.of(new TypeDescription.ForLoadedType(type));
                map.put("@" + value, new Variable(i + 1, opcode, type));
            }
        }
        return map;
    }

    private Set<Class<?>> findRequiredFns(ScriptContext scriptContext, List<String> functions) {
        return functions.stream().map(scriptContext::findExecutableElement).filter(a->a instanceof Method).map(Executable::getDeclaringClass).collect(Collectors.toSet());
    }

    public Class compile(FileInputStream fis) throws IOException {
        return compile(new String(fis.readAllBytes()));
    }

    public Class compile(File file) throws IOException {
        return compile(file.toPath());
    }

    public Class compile(Path path) throws IOException {
        return compile(new String(Files.readAllBytes(path)));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Set<Object> fns = new HashSet<>();
        private Set<Class<?>> enums = new HashSet<>();

        private Class implementingType;

        private String packagee;
        private String cnp;
        private Class<? extends Annotation>[] fieldAnnotations;
        private Class<? extends Annotation>[] classAnnotations;
        private String debugOutput;
        private Map<String, String> macros = new LinkedHashMap<>();

        public Builder add(Object o) {
            fns.add(o);
            return this;
        }

        public Builder add(Collection o) {
            fns.addAll(o);
            return this;
        }

        public Builder withEnum(Class o) {
            enums.add(o);
            return this;
        }

        public Builder macro(String k, String v) {
            macros.put(k,v);
            return this;
        }

        public Builder package_(String packagee) {
            if (!packagee.endsWith(".")) {
                packagee += ".";
            }
            this.packagee = packagee;
            return this;
        }

        public Builder implementingType(Class implementingType) {
            this.implementingType = implementingType;
            return this;
        }


        public Builder setClassNamePattern(String cnp) {
            this.cnp = cnp;
            return this;
        }

        public Builder debugOutput(String path) {
            this.debugOutput = path;
            return this;
        }

        public Builder fieldAnnotation(Class<? extends Annotation>[] annotations) {
            this.fieldAnnotations = annotations;
            return this;
        }

        public Builder classAnnotations(Class<? extends Annotation>[] annotations) {
            this.classAnnotations = annotations;
            return this;
        }

        public NTScript build() {
            return new NTScript(fns, implementingType,
                    packagee == null ? "no.pkg." : packagee,
                    cnp == null ? System.currentTimeMillis() + "" : cnp,
                    enums,
                    fieldAnnotations,
                    classAnnotations,
                    debugOutput,
                    macros
            );
        }
    }
}
