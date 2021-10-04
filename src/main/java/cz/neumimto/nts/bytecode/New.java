package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;

public class New implements StackManipulation, Opcodes {

    private final Class type;

    public New(Class type) {
        this.type = type;
    }

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
        methodVisitor.visitTypeInsn(NEW, Type.getInternalName(type));
        return new StackManipulation.Size(1, 1);
    }

}
