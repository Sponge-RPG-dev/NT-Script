package cz.neumimto.nts;

import cz.neumimto.nts.bytecode.Variable;

import java.util.HashMap;

public class Scope {
    public final HashMap<String, Variable> variables;

    public Scope(HashMap<String, Variable> variables) {
        this.variables = variables;
    }

    public int getNextVariableOffset() {
        return variables.size() +1;
    }

}
