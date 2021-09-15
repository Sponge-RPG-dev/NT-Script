package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.ntsBaseVisitor;
import cz.neumimto.nts.ntsParser;

import java.util.ArrayList;
import java.util.List;

public class FnVisitor extends ntsBaseVisitor {

    List<String> functions = new ArrayList<>();

    List<String> lambdas = new ArrayList<>();

    @Override
    public Object visitFunction_call(ntsParser.Function_callContext ctx) {
        if (!lambdas.contains("@" + ctx.function_name.getText())) {
            functions.add(ctx.function_name.getText());
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
