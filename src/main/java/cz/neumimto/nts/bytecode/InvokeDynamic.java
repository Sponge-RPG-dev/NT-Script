package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.Scope;
import cz.neumimto.nts.ScriptContext;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;

import java.lang.invoke.*;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvokeDynamic implements StackManipulation {

    private final Map<String, Variable> fnVars;
    private ScriptContext scriptContext;

    private static Method metaFactory;
    static {
        try {
            metaFactory = LambdaMetafactory.class.getDeclaredMethod("metafactory", MethodHandles.Lookup.class, String.class, MethodType.class, MethodType.class, MethodHandle.class, MethodType.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public InvokeDynamic(ScriptContext scriptContext, Map<String, Variable> fnVars) {
        this.scriptContext = scriptContext;
        this.fnVars = fnVars;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
         String descriptor = "(%s)Ljava/lang/Runnable;";
         String k = fnVars.values().stream()
                 .map(a-> new TypeDescription.ForLoadedType(a.getRuntimeType()).getDescriptor())
                 .collect(Collectors.joining());
         descriptor = descriptor.replaceAll("%s",scriptContext.getInsnType().getDescriptor() + k);



       // methodVisitor.visitInvokeDynamicInsn("run",
       //         "(Lcz/neumimto/nts/DecompileTest;IZ)Ljava/lang/Runnable;",
       //         new Handle(Opcodes.H_INVOKESTATIC, "java/lang/invoke/LambdaMetafactory", "metafactory", "(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodType;Ljava/lang/invoke/MethodHandle;Ljava/lang/invoke/MethodType;)Ljava/lang/invoke/CallSite;", false),
       //         Type.getType("()V"),
       //         new Handle(Opcodes.H_INVOKEVIRTUAL, "cz/neumimto/nts/DecompileTest", "lambda$a$0", "(IZ)V", false),
       //         Type.getType("()V"));
       //



        methodVisitor.visitInvokeDynamicInsn("run",
                 descriptor,
                 new Handle(Opcodes.H_INVOKESTATIC, new TypeDescription.ForLoadedType(LambdaMetafactory.class).getInternalName(),
                         "metafactory",
                         Type.getMethodDescriptor(metaFactory),
                         false),
 Type.getType("()V"),
                 new Handle(Opcodes.H_INVOKEVIRTUAL,
                         scriptContext.getInsnType().getInternalName(),
                         Scope.LAMBDA_METHOD_NAME.apply(scriptContext.getScopes().size() - 2),
                         "("+k+")V",
                         false),
                 Type.getType("()V"));
        return new StackManipulation.Size(1, 1);
    }
}
