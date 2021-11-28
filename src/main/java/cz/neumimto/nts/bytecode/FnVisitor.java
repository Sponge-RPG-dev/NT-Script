package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.Descriptor;
import cz.neumimto.nts.ntsBaseVisitor;
import cz.neumimto.nts.ntsParser;

import java.lang.reflect.Executable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;

public class FnVisitor extends ntsBaseVisitor {

    List<String> functions = new ArrayList<>();

    List<String> lambdas = new ArrayList<>();

    private Set<Object> context;

    public FnVisitor(Set<Object> context) {
        this.context = context;
    }

    @Override
    public Object visitFunction_call(ntsParser.Function_callContext ctx) {
        String fnName = ctx.function_name.getText();
        if (!lambdas.contains("@" + fnName)) {
            for (Object o : context) {
                if (o instanceof Descriptor d) {
                    if (d.functionName.equalsIgnoreCase(fnName)) {
                        if (!d.injectedViaField) {
                            return super.visitFunction_call(ctx);
                        }
                    }
                }
            }
            functions.add(fnName);
        }
        return super.visitFunction_call(ctx);
    }

    @Override
    public Object visitAssignment_statement(ntsParser.Assignment_statementContext ctx) {
        if (ctx.assignment_values().lambda() != null) {
            lambdas.add(ctx.VARIABLE_IDENTIFIER().getText());
        }
        return super.visitAssignment_statement(ctx);
    }

    public List<String> getFunctions() {
        return functions;
    }
}
