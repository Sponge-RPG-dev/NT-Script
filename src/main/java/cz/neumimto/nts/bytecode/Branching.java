package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;


public interface Branching extends StackManipulation{

    Label label();

    static class ArithmeticalComp implements StackManipulation {
        private final Label label;
        private final int dcmp;
        private final int jump;

        public ArithmeticalComp(Label label, int dcmp, int jump) {
            this.label = label;
            this.dcmp = dcmp;
            this.jump = jump;
        }


        //todo
        public static StackManipulation forToken(String text, Label ifLabel) {
            int dcmp = 0;
            int jump = 0;

            switch (text) {
                case "<":
                    dcmp = Opcodes.DCMPG;
                    jump = Opcodes.IFGE;
                    break;
                case "<=":
                case "=<":
                    dcmp = Opcodes.DCMPG;
                    jump = Opcodes.IFGT;
                    break;
                case ">":
                    dcmp = Opcodes.DCMPL;
                    jump = Opcodes.IFLE;
                    break;
                case ">=":
                case "=>":
                    dcmp = Opcodes.DCMPL;
                    jump = Opcodes.IFLT;
                    break;
                case "==":
                    dcmp = Opcodes.DCMPL;
                    jump = Opcodes.IFEQ;
                    break;
                case "!=":
                    dcmp = Opcodes.DCMPL;
                    jump = Opcodes.IFNE;
                default:
                    throw new RuntimeException("Unknown comp sign " + text);
            }
            return new ArithmeticalComp(ifLabel, dcmp, jump);
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public StackManipulation.Size apply(MethodVisitor mv, Implementation.Context ctx) {
            mv.visitInsn(dcmp);
            mv.visitJumpInsn(jump, label);
            return StackSize.SINGLE.toDecreasingSize();
        }
    }

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
