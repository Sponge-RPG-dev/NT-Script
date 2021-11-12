package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.Scope;
import cz.neumimto.nts.ScriptContext;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;
import net.bytebuddy.matcher.ElementMatchers;

import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.Map;

public class InvokeDynamic implements StackManipulation {

    private final Map<String, Variable> fnVars;
    private int id;
    private ScriptContext scriptContext;

    private static Method metaFactory;
    static {
        try {
            metaFactory = LambdaMetafactory.class.getDeclaredMethod("metafactory", MethodHandles.Lookup.class, String.class, MethodType.class, MethodType.class, MethodHandle.class, MethodType.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public InvokeDynamic(ScriptContext scriptContext, Map<String, Variable> fnVars, int id) {
        this.scriptContext = scriptContext;
        this.fnVars = fnVars;
        this.id = id;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {// methodVisitor.visitInvokeDynamicInsn("run",

        var method = implementationContext.getInstrumentedType()
                .getDeclaredMethods()
                .filter(ElementMatchers.named(Scope.LAMBDA_METHOD_NAME.apply(id)))
                .stream().findFirst().get();

        var descriptor = method.asSignatureToken().getDescriptor();
        String thisDescriptor = scriptContext.getInsnType().getDescriptor();

        methodVisitor.visitInvokeDynamicInsn("run",
                descriptor.replace("(", "(" + thisDescriptor).replaceAll("\\)V",")"+Type.getDescriptor(Runnable.class)),
                 new Handle(Opcodes.H_INVOKESTATIC, new TypeDescription.ForLoadedType(LambdaMetafactory.class).getInternalName(),
                         "metafactory",
                         Type.getMethodDescriptor(metaFactory),
                         false),
                Type.getType("()V"),
                new Handle(Opcodes.H_INVOKEVIRTUAL,
                        scriptContext.getInsnType().getInternalName(),
                        Scope.LAMBDA_METHOD_NAME.apply(id),
                        descriptor,
                        false),
                Type.getType("()V"));
        return new StackManipulation.Size(1, 1);
    }
}
