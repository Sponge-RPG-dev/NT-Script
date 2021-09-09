package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.StackSize;
import net.bytebuddy.jar.asm.Label;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.jar.asm.Opcodes;

public enum MathOperators {
    ICMPEQ(Opcodes.IF_ICMPEQ),
    ICMPNE(Opcodes.IF_ICMPNE),
    ICMPLT(Opcodes.IF_ICMPLT),
    ICMPGE(Opcodes.IF_ICMPGE),
    ICMPGT(Opcodes.IF_ICMPGT),
    ICMPLE(Opcodes.IF_ICMPLE),

    ACMPEQ(Opcodes.IF_ACMPEQ),
    ACMPNE(Opcodes.IF_ACMPNE);


    private int insn;
    MathOperators(int insn) {
        this.insn = insn;
    }


}
