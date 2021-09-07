package cz.neumimto.nts.bytecode;

import net.bytebuddy.implementation.bytecode.StackManipulation;

import java.util.ArrayList;
import java.util.List;

public class StackData {
    protected List<StackManipulation> bbImpl = new ArrayList<>();

    public List<StackManipulation> getBbImpl() {
        return bbImpl;
    }

    public void add(StackManipulation s) {
        bbImpl.add(s);
    }
}
