package cz.neumimto.nts;

import cz.neumimto.nts.bytecode.Variable;
import net.bytebuddy.implementation.bytecode.StackManipulation;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Function;

public class Scope {
    public static Function<Integer, String> LAMBDA_METHOD_NAME = i -> "lambda$a$" + i;

    public final LinkedHashMap<String, Variable> variables;

    private final List<Scope> parentsForVarLookup;
    public final Scope parent;

    public final List<StackManipulation> impl = new ArrayList<>();

    private final Set<Variable> parentVarsLookup;

    public Map<String, Variable> fnVars;
    public int id;
    public Variable lastVariableOnStack;

    public Scope(LinkedHashMap<String, Variable> variables, List<Scope> parentsForVarLookup, Scope currentScope) {
        this.variables = variables;
        this.parentsForVarLookup = parentsForVarLookup;
        this.parent = currentScope;
        this.parentVarsLookup = new TreeSet<>();
    }

    public int getNextVariableOffset() {
        Optional<Variable> max = variables.values().stream()
                .max(Comparator.comparingInt(Variable::getOffset));
        if (max.isPresent()) {
            return max.get().getOffset() + max.get().getOffsetSize();
        } else {
            return 1;
        }
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
