package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.ntsBaseVisitor;
import cz.neumimto.nts.ntsParser;

import java.util.ArrayList;
import java.util.List;

public class FnVisitor extends ntsBaseVisitor {

    List<String> functions = new ArrayList<>();

    @Override
    public Object visitFunction_call(ntsParser.Function_callContext ctx) {
        functions.add(ctx.function_name.getText());
        return super.visitFunction_call(ctx);
    }

    public List<String> getFunctions() {
        return functions;
    }
}
