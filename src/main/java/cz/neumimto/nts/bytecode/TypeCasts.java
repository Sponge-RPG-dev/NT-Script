package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.jar.asm.Type;

import java.lang.reflect.Field;

public interface TypeCasts {

    static Cast castPrimitive(Class<?> actual, Class<?> target) {
        String from = Type.getDescriptor(actual);
        String to = Type.getDescriptor(target);
        if (target == long.class) { //long is J, but there are only D2L,... opcodes
            to = "L";
        }
        if (actual == long.class) {
            from = "L";
        }
        try {
            int castInsn = (int) Opcodes.class.getField(from + "2" + to).get(null);
            return new Cast(castInsn);
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }

        return null;
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

    class Cast implements StackManipulation {

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
