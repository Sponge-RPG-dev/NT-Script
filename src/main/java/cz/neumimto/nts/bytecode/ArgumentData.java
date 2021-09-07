package cz.neumimto.nts.bytecode;

import cz.neumimto.nts.VisitorImpl;
import cz.neumimto.nts.ntsParser;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.constant.IntegerConstant;
import net.bytebuddy.implementation.bytecode.constant.TextConstant;

import java.util.ArrayList;
import java.util.List;

public class ArgumentData extends StackData {
    protected String name;

    private ArgumentData(String name, List<StackManipulation> stackManipulations) {
        this.name = name;
        super.bbImpl = stackManipulations;
    }

    public static ArgumentData create(ntsParser.ArgumentContext ctx, VisitorImpl visitor) {
        ntsParser.RvalContext value = ctx.value;

        ntsParser.Type_integerContext type_integerContext = value.type_integer();
        List<StackManipulation> stack = new ArrayList<>();
        if (type_integerContext != null) {
            stack.add(IntegerConstant.forValue(Integer.getInteger(value.getText())));
        }
        if (value.type_literal() != null) {
            stack.add(new TextConstant(value.type_literal().getText()));
        }
        if (value.function_call() != null) {

        }
        return new ArgumentData(ctx.name.getText(), stack);
    }


    public String getName() {
        return name;
    }
}
