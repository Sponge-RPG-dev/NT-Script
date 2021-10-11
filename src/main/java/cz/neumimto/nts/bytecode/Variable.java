package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.member.MethodVariableAccess;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

public class Variable implements Comparable<Variable> {
    int offset;
    MethodVariableAccess methodVariableAccess;
    private Class runtimeType;
    private Class genericType;

    public Variable(int offset, MethodVariableAccess methodVariableAccess, Class runtimeType) {
        this.offset = offset;
        this.methodVariableAccess = methodVariableAccess;
        this.runtimeType = runtimeType;
    }

    public int getOffset() {
        return offset;
    }

    public int getOffsetSize() {
        return (runtimeType == double.class || runtimeType == long.class) ? 2 : 1;
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

    public Class getGenericType() {
        return genericType;
    }

    public void setGenericType(Class genericType) {
        this.genericType = genericType;
    }

    public void setRuntimeType(Class runtimeType) {
        this.runtimeType = runtimeType;
    }

    @Override
    public int compareTo(Variable o) {
        return o.offset = offset;
    }
}
