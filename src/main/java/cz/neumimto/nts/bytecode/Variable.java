package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;

public class Variable implements Comparable<Variable> {
    int offset;
    MethodVariableAccess methodVariableAccess;
    private Class runtimeType;

    public Variable(int offset, MethodVariableAccess methodVariableAccess, Class runtimeType) {
        this.offset = offset;
        this.methodVariableAccess = methodVariableAccess;
        this.runtimeType = runtimeType;
    }

    public Variable copyWithNewOffset(int offset) {
        return new Variable(offset, this.methodVariableAccess, this.runtimeType);
    }

    public StackManipulation store() {
        return methodVariableAccess.storeAt(offset);
    }

    public StackManipulation load() {
        return methodVariableAccess.loadFrom(offset);
    }

    public Class getRuntimeType() {
        return runtimeType;
    }

    public void setRuntimeType(Class runtimeType) {
        this.runtimeType = runtimeType;
    }

    @Override
    public int compareTo(Variable o) {
        return o.offset = offset;
    }
}
