package cz.neumimto.nts;

import cz.neumimto.nts.bytecode.VisitorImpl;
import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.scaffold.InstrumentedType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.ByteCodeAppender;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.ClassWriter;
import net.bytebuddy.pool.TypePool;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Set;

public class Tests {

    public enum Result {
        OK
    }

    @Test
    public void test() throws IOException, InstantiationException, IllegalAccessException {
       String k = """
        #  @text = "test"
        #  @bool_t = t
        #  @bool_f = false
        #  @int = 10000
        #  
        #  #C O M M E N T
        #  
        #  @param = call{string=@text, func=method{int=50}}
        #  
        #  IF test{int= @int, string=call{string=@text}}
        #      @int2 = 5000
        #  END
        #  
        #  IF @bool_f
        #      @int3=700000
        #  END
          
          FOREACH @entity IN list{size=50}
              @int4 = 5600
          END
                    
          RETURN Result.OK
        """;
   // k = """
   //     @param = call{string="xxxx"}
   // """;
        CharStream charStream = new ANTLRInputStream(k);
        var lexer = new ntsLexer(charStream);
        var stream = new CommonTokenStream(lexer);
        var parser = new ntsParser(stream);

        var visitor = new VisitorImpl(new ScriptContext(new HashMap<>(),
                Set.of(new A(), new B(), new C(), new L()),
                Set.of(Result.class)));


        var bb = new ByteBuddy()
                .subclass(Object.class)
                .name("cz.neumimto.skills.scripts.aaa" )
                .visit(new EnableFramesComputing())
                .defineField("A", A.class, Modifier.PUBLIC)
                .defineField("B", B.class, Modifier.PUBLIC)
                .defineField("C", C.class, Modifier.PUBLIC)
                .defineField("L", L.class, Modifier.PUBLIC)
                .defineMethod("test", Result.class, Modifier.PUBLIC)
                .intercept(new Implementation() {
                    @Override
                    public ByteCodeAppender appender(Target implementationTarget) {
                        return (methodVisitor, implementationContext, instrumentedMethod) -> {
                            visitor.visit(parser.script());

                            StackManipulation.Size size = new StackManipulation.Compound(
                                    visitor.getImpl()
                            ).apply(methodVisitor, implementationContext);

                            return new ByteCodeAppender.Size(size.getMaximalSize(), instrumentedMethod.getStackSize());
                        };
                    }

                    @Override
                    public InstrumentedType prepare(InstrumentedType instrumentedType) {
                        visitor.getScriptContext().setInsnType(instrumentedType);
                        return instrumentedType;
                    }
                }).make();
        bb.saveIn(new File("/tmp/test/"));
        Class<?> loaded = bb.load(this.getClass().getClassLoader()).getLoaded();
        Object o = loaded.newInstance();
    }

    static class EnableFramesComputing implements AsmVisitorWrapper {
        @Override
        public final int mergeWriter(int flags) {
            return flags | ClassWriter.COMPUTE_FRAMES;
        }

        @Override
        public final int mergeReader(int flags) {
            return flags | ClassWriter.COMPUTE_FRAMES;
        }

        @Override
        public net.bytebuddy.jar.asm.ClassVisitor wrap(TypeDescription instrumentedType, net.bytebuddy.jar.asm.ClassVisitor classVisitor, Implementation.Context implementationContext, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fields, MethodList<?> methods, int writerFlags, int readerFlags) {
            return classVisitor;
        }
    }
}
