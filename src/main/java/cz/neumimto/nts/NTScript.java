package cz.neumimto.nts;


import cz.neumimto.nts.annotations.ScriptMeta;
import cz.neumimto.nts.bytecode.FnVisitor;
import cz.neumimto.nts.bytecode.Variable;
import cz.neumimto.nts.bytecode.VisitorImpl;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.AsmVisitorWrapper;
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
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings("unchecked")
public class NTScript {


    private final Set<Object> fns;
    private final Class<?> implementingType;
    private final String packagee;
    private String classNamePattern;
    private Set<Class<?>> enums;
    private Annotation[] fieldAnnotations;
    private Annotation[] classAnnotations;
    private String debugOutput;
    private int generated = 0;

    private NTScript(Set<Object> fns,
                     Class<?> implementingType,
                     String packagee,
                     String classNamePattern,
                     Set<Class<?>> enums,
                     Annotation[] fieldAnnotations,
                     Annotation[] classAnnotations,
                     String debugOutput) {
        this.fns = fns;
        this.implementingType = implementingType;
        this.packagee = packagee;
        this.classNamePattern = classNamePattern;
        this.enums = enums;
        this.fieldAnnotations = fieldAnnotations;
        this.classAnnotations = classAnnotations;
        this.debugOutput = debugOutput;
    }


    public Class parseScript(String input) {
        CharStream charStream = new ANTLRInputStream(input);
        var lexer = new ntsLexer(charStream);
        var stream = new CommonTokenStream(lexer);
        var parser = new ntsParser(stream);

        var fnVisitor = new FnVisitor();
        ntsParser.ScriptContext script = parser.script();
        fnVisitor.visit(script);

        List<String> functions = fnVisitor.getFunctions();

        Set<Object> requiredFns = findRequiredFns(functions);


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
            for (Annotation classAnnotation : classAnnotations) {
                bb = bb.annotateType(classAnnotation);
            }
        }


        generated++;

        for (Object requiredFn : requiredFns) {
            DynamicType.Builder.FieldDefinition.Optional.Valuable<?> dbfv = bb.defineField(requiredFn.getClass().getSimpleName(), requiredFn.getClass(), Opcodes.ACC_PUBLIC);

            DynamicType.Builder.FieldDefinition.Optional<?> dbf = null;
            if (fieldAnnotations != null) {
                for (Annotation fieldAnnotation : fieldAnnotations) {
                    dbf = dbfv.annotateField(fieldAnnotation);
                }
            }
            bb = dbf == null ? dbfv : dbf;
        }

        var visitor = new VisitorImpl(new ScriptContext(
                getImplementingMethodParams(),
                requiredFns,
                this.enums));


        visitor.getScriptContext().setInsnType(bb.toTypeDescription());
        visitor.visit(script);

        List<Scope> scopes = visitor.getImpl().getScopes();

        for (int i = scopes.size()-1; i > 1; i--) {
            Scope scope = scopes.get(i);

            bb = bb.defineMethod("lambda$"+i+"$a", void.class, Opcodes.ACC_PRIVATE | Opcodes.ACC_SYNTHETIC)
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

                    List<StackManipulation> impl = visitor.getImpl().getScopes().iterator().next().impl;
                    List<StackManipulation> list = new ArrayList<>();
                    list.addAll(impl);

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

    private Set<Object> findRequiredFns(List<String> functions) {
        return functions.stream().map(f->ScriptContext.findMechanic(f, fns)).collect(Collectors.toSet());
    }

    public Class parseScript(FileInputStream fis) throws IOException {
        return parseScript(new String(fis.readAllBytes()));
    }

    public Class parseScript(File file) throws IOException {
        return parseScript(file.toPath());
    }

    public Class parseScript(Path path) throws IOException {
        return parseScript(new String(Files.readAllBytes(path)));
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
        private Annotation[] fieldAnnotations;
        private Annotation[] classAnnotations;
        private String debugOutput;

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

        public Builder fieldAnnotation(Annotation... annotations) {
            this.fieldAnnotations = annotations;
            return this;
        }

        public Builder classAnnotations(Annotation... annotations) {
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
                    debugOutput
            );
        }
    }
}
