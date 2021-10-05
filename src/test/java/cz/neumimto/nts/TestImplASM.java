package cz.neumimto.nts;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.asm.AsmVisitorWrapper;
import net.bytebuddy.description.field.FieldDescription;
import net.bytebuddy.description.field.FieldList;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.method.MethodList;
import net.bytebuddy.description.method.ParameterDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.implementation.bytecode.constant.DoubleConstant;
import net.bytebuddy.implementation.bytecode.member.FieldAccess;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;
import net.bytebuddy.jar.asm.*;
import net.bytebuddy.pool.TypePool;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;


public class TestImplASM implements Opcodes  {

    @Test
    public void test_ASM() throws Exception {

        StringWriter sw = new StringWriter();


        ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS);

        FieldVisitor fieldVisitor;
        RecordComponentVisitor recordComponentVisitor;
        MethodVisitor methodVisitor;
        AnnotationVisitor annotationVisitor0;

        classWriter.visit(V16, ACC_PUBLIC | ACC_SUPER, "cz/neumimto/nts/TestImpl", null, "java/lang/Object", null);

        classWriter.visitSource("TestImpl.java", null);

        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "<init>", "()V", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(3, label0);
            methodVisitor.visitVarInsn(ALOAD, 0);
            methodVisitor.visitMethodInsn(INVOKESPECIAL, "java/lang/Object", "<init>", "()V", false);
            methodVisitor.visitInsn(RETURN);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLocalVariable("this", "Lcz/neumimto/nts/TestImpl;", null, label0, label1, 0);
            methodVisitor.visitMaxs(1, 1);
            methodVisitor.visitEnd();
        }
        {
            methodVisitor = classWriter.visitMethod(ACC_PUBLIC, "run", "(D)D", null, null);
            methodVisitor.visitCode();
            Label label0 = new Label();
            methodVisitor.visitLabel(label0);
            methodVisitor.visitLineNumber(6, label0);
            methodVisitor.visitLdcInsn(new Double("7.0"));
            methodVisitor.visitVarInsn(DSTORE, 3);
            Label label1 = new Label();
            methodVisitor.visitLabel(label1);
            methodVisitor.visitLineNumber(7, label1);
            methodVisitor.visitLdcInsn(new Double("4.0"));
            methodVisitor.visitVarInsn(DSTORE, 5);
            Label label2 = new Label();
            methodVisitor.visitLabel(label2);
            methodVisitor.visitLineNumber(8, label2);
            methodVisitor.visitVarInsn(DLOAD, 1);
            methodVisitor.visitVarInsn(DLOAD, 5);
            methodVisitor.visitInsn(DCMPG);
            Label label3 = new Label();
            methodVisitor.visitJumpInsn(IFGE, label3);
            Label label4 = new Label();
            methodVisitor.visitLabel(label4);
            methodVisitor.visitLineNumber(9, label4);
            methodVisitor.visitFieldInsn(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");
            methodVisitor.visitVarInsn(DLOAD, 3);
            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/io/PrintStream", "println", "(D)V", false);
            methodVisitor.visitLabel(label3);
            methodVisitor.visitLineNumber(11, label3);
           // methodVisitor.visitFrame(Opcodes.F_APPEND,2, new Object[] {Opcodes.DOUBLE, Opcodes.DOUBLE}, 0, null);
            methodVisitor.visitInsn(DCONST_0);
            methodVisitor.visitInsn(DRETURN);
            Label label5 = new Label();
            methodVisitor.visitLabel(label5);
            methodVisitor.visitLocalVariable("this", "Lcz/neumimto/nts/TestImpl;", null, label0, label5, 0);
            methodVisitor.visitLocalVariable("param", "D", null, label0, label5, 1);
            methodVisitor.visitLocalVariable("d", "D", null, label1, label5, 3);
            methodVisitor.visitLocalVariable("k", "D", null, label2, label5, 5);
            methodVisitor.visitMaxs(4, 7);
            methodVisitor.visitEnd();
        }
        classWriter.visitEnd();

        byte[] b = classWriter.toByteArray();

        Files.write(Path.of("/tmp/", System.currentTimeMillis() + ".class"),b, StandardOpenOption.CREATE_NEW);
        Class<?> aClass = MethodHandles.lookup().defineClass(b);
        Object o = aClass.newInstance();
        o.getClass().getDeclaredMethod("run", double.class).invoke(o, 0);
    }

    @Test
    public void test_BB() throws Throwable {
        Label label3 = new Label();
        Label label4 = new Label();

        var bbTypeDef = new ByteBuddy().subclass(Object.class)
                .name("pkg.TestImpl")
                .visit(new AsmVisitorWrapper() {
                    @Override
                    public int mergeWriter(int flags) {
                        return flags | ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS;
                    }

                    @Override
                    public int mergeReader(int flags) {
                        return flags | ClassWriter.COMPUTE_FRAMES | ClassWriter.COMPUTE_MAXS;
                    }

                    @Override
                    public ClassVisitor wrap(TypeDescription instrumentedType, ClassVisitor classVisitor, Implementation.Context implementationContext, TypePool typePool, FieldList<FieldDescription.InDefinedShape> fields, MethodList<?> methods, int writerFlags, int readerFlags) {
                        return classVisitor;
                    }
                })
                .defineMethod("run", double.class, Modifier.PUBLIC)
                .withParameters(double.class)
                .intercept(new Implementation.Simple(
                        DoubleConstant.forValue(7),
                        MethodVariableAccess.DOUBLE.storeAt(3),
                        DoubleConstant.forValue(6),
                        MethodVariableAccess.DOUBLE.storeAt(5),
                        MethodVariableAccess.DOUBLE.loadFrom(5),
                        (ValidStackManipulation) (m, implementationContext) -> {
                            m.visitVarInsn(DLOAD, 1);
                            m.visitInsn(DCMPG);
                            m.visitJumpInsn(IFGE, label3);
                            m.visitLabel(label4);
                            return StackSize.SINGLE.toDecreasingSize();
                        },
                        FieldAccess.forField(new FieldDescription.ForLoadedField(System.class.getDeclaredField("out"))).read(),
                        MethodVariableAccess.DOUBLE.loadFrom(3),
                        MethodInvocation.invoke(new MethodDescription.ForLoadedMethod(PrintStream.class.getDeclaredMethod("println", double.class))),
                        (ValidStackManipulation) (m, implementationContext) -> {
                            m.visitLabel(label3);
                            return StackSize.ZERO.toIncreasingSize();
                        },
                        DoubleConstant.forValue(0),
                        (ValidStackManipulation) (m, implementationContext) -> {
                            m.visitInsn(DRETURN);
                            return StackSize.ZERO.toIncreasingSize();
                        })).make();

        bbTypeDef.saveIn(new File("/tmp/"));
        Class<?> loaded = bbTypeDef.load(this.getClass().getClassLoader()).getLoaded();

        Object o = loaded.newInstance();
        o.getClass().getDeclaredMethod("run", double.class).invoke(o, 0);

    }

    private interface ValidStackManipulation extends StackManipulation {
        @Override
        default boolean isValid() {
            return true;
        }
    }
}

