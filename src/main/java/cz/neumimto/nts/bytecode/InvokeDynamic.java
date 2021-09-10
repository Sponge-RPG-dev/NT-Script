package cz.neumimto.nts.bytecode;

import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.Handle;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.stream.Collectors;

public class InvokeDynamic implements StackManipulation {


    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
       // String descriptor = "(%s)Ljava/lang/Runnable;";
       // String k = ctx.localVariables().values().stream().map(a-> new TypeDescription.ForLoadedType(a.aClass).getDescriptor()).collect(Collectors.joining());
       // descriptor = descriptor.replaceAll("%s",ctx.thisType().getDescriptor() + k);
//
       // methodVisitor.visitInvokeDynamicInsn("run",
       //         descriptor,
       //         new Handle(Opcodes.H_INVOKESTATIC,
       //                 new TypeDescription.ForLoadedType(LambdaMetafactory.class).getInternalName(),
       //                 "metafactory",
       //                 MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class, String.class, Object[].class).toMethodDescriptorString(),
       //                 false),
       //         Type.VOID_TYPE,
       //         new Handle(Opcodes.H_INVOKESPECIAL,
       //                 this.ctx.thisType().getInternalName(),
       //                 methodName,
       //                 "("+k+")V",
       //                 false),
       //         Type.VOID_TYPE);
        return null;
    }
}
