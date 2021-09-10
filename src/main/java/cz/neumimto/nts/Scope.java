package cz.neumimto.nts;

import cz.neumimto.nts.bytecode.Variable;
import net.bytebuddy.implementation.bytecode.StackManipulation;

import java.util.*;

public class Scope {
    public final Map<String, Variable> variables;

    private final List<Scope> parentsForVarLookup;

    public final List<StackManipulation> impl = new ArrayList<>();

    private final Set<Variable> parentVarsLookup;

    public Scope(Map<String, Variable> variables, List<Scope> parentsForVarLookup) {
        this.variables = variables;
        this.parentsForVarLookup = parentsForVarLookup;
        this.parentVarsLookup = new TreeSet<>();
    }

    public int getNextVariableOffset() {
        return variables.size() +1;
    }

    public Scope add(StackManipulation sm) {
        impl.add(sm);
        return this;
    }

    public Variable findVariable(String variable) {
        for (Scope scope : parentsForVarLookup) {
            Variable variable1 = scope.findVariable(variable);
            if (variable1 != null) {
                parentVarsLookup.add(variable1);
                return variable1;
            }
        }
        return variables.get(variable);
    }

    public Set<Variable> getParentVarsLookup() {
        return parentVarsLookup;
    }
}
