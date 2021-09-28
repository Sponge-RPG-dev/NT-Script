package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.ntsParser;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.RuleContext;


public interface Branching extends StackManipulation{

    Label label();

    static class ArithmeticalComp implements StackManipulation {
        private final Label label;
        private final int opcode;

        public ArithmeticalComp(Label label, int opcode) {
            this.label = label;
            this.opcode = opcode;
        }

        //todo
        public static StackManipulation forToken(String text, Label ifLabel) {
            int opCode = switch (text) {
                case "<":
                    yield Opcodes.DCMPG;
                case ">":
                    yield Opcodes.DCMPL;
                case ">=":
                case "=>":
                    yield Opcodes.DCMPG;
                case "<=":
                case "=<":
                    yield Opcodes.IF_ICMPGT;
                case "==":
                    yield Opcodes.IF_ICMPEQ;
                case "!=":
                    yield Opcodes.IF_ICMPNE;
                default:
                    throw new RuntimeException("Unknown comp sign " + text);
            };
            return new ArithmeticalComp(ifLabel, opCode);
        }

        @Override
        public boolean isValid() {
            return true;
        }

        @Override
        public StackManipulation.Size apply(MethodVisitor mv, Implementation.Context ctx) {
            mv.visitJumpInsn(opcode, label);
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
