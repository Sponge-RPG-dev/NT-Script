package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;

public interface TypeCasts {

    Cast DOUBLE_TO_INT = new Cast(Opcodes.D2I);
    Cast DOUBLE_TO_FLOAT = new Cast(Opcodes.D2F);
    Cast DOUBLE_TO_LONG = new Cast(Opcodes.D2L);

    static Cast castDoubleTo(Class<?> type) {
        if (type == int.class) {
            return DOUBLE_TO_INT;
        } else if (type == float.class) {
            return DOUBLE_TO_FLOAT;
        } else if (type == long.class) {
            return DOUBLE_TO_LONG;
        }
        throw new RuntimeException("Cannot typecast primitive double to " + type.getName());
    }

    static StackManipulation checkCast(Class c) {
        return new StackManipulation() {
            @Override
            public boolean isValid() {
                return true;
            }

            @Override
            public Size apply(MethodVisitor methodVisitor, Implementation.Context implementationContext) {
                methodVisitor.visitTypeInsn(Opcodes.CHECKCAST, Type.getInternalName(c));
                return StackSize.SINGLE.toIncreasingSize();
            }
        };
    }

    static class Cast implements StackManipulation {

        private final int opcode;

        public Cast(int opcode) {
            this.opcode = opcode;
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public Size apply(MethodVisitor mv, Implementation.Context implementationContext) {
            mv.visitInsn(opcode);
            return StackSize.SINGLE.toDecreasingSize();
        }
    }
}
