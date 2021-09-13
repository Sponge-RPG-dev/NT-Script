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

import java.lang.invoke.CallSite;
import java.lang.invoke.LambdaMetafactory;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InvokeDynamic implements StackManipulation {

    private final Map<String, Variable> fnVars;
    private ScriptContext scriptContext;

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

         methodVisitor.visitInvokeDynamicInsn("run",
                 descriptor,
                 new Handle(Opcodes.H_INVOKESTATIC,
                         new TypeDescription.ForLoadedType(LambdaMetafactory.class).getInternalName(),
                         "metafactory",
                         MethodType.methodType(CallSite.class, MethodHandles.Lookup.class, String.class, MethodType.class, String.class, Object[].class).toMethodDescriptorString(),
                         false),
                 Type.VOID_TYPE,
                 new Handle(Opcodes.H_INVOKESPECIAL,
                         scriptContext.getInsnType().getInternalName(),
                         Scope.LAMBDA_METHOD_NAME.apply(scriptContext.getScopes().size() - 1),
                         "("+k+")V",
                         false),
                 Type.VOID_TYPE);
        return null;
    }
}
