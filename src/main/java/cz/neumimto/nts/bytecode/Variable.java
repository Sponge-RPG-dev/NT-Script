package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;

public class Variable {
    int offset;
    MethodVariableAccess methodVariableAccess;

    public Variable(int offset, MethodVariableAccess methodVariableAccess) {
        this.offset = offset;
        this.methodVariableAccess = methodVariableAccess;
    }

    public StackManipulation store() {
        return methodVariableAccess.storeAt(offset);
    }

    public StackManipulation load() {
        return methodVariableAccess.loadFrom(offset);
    }

}
