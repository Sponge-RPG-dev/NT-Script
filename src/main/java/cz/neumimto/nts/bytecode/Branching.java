package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;


public interface Branching extends StackManipulation{

    Label label();

    class IfEq implements Branching {
        private final Label label;

        public IfEq(Label label) {
            this.label = label;
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public StackManipulation.Size apply(MethodVisitor mv, Implementation.Context ctx) {
            mv.visitJumpInsn(Opcodes.IFEQ, label);
            return new StackManipulation.Size(0, 0);
        }

        @Override
        public Label label() {
            return label;
        }
    }

    class IfNEq implements StackManipulation {
        private final Label label;

        public IfNEq(Label label) {
            this.label = label;
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public StackManipulation.Size apply(MethodVisitor mv, Implementation.Context ctx) {
            mv.visitJumpInsn(Opcodes.IFNE, label);
            return new StackManipulation.Size(0, 0);
        }
    }

    class GoTo implements StackManipulation {
        private final Label label;

        public GoTo(Label label) {
            this.label = label;
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public StackManipulation.Size apply(MethodVisitor mv, Implementation.Context ctx) {
            mv.visitJumpInsn(Opcodes.GOTO, label);
            return new StackManipulation.Size(0, 0);
        }
    }

    class Mark implements StackManipulation {
        private final Label label;

        public Mark(Label label) {
            this.label = label;
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public StackManipulation.Size apply(MethodVisitor mv, Implementation.Context ctx) {
            mv.visitLabel(label);
            return new StackManipulation.Size(0, 0);
        }
    }
}
