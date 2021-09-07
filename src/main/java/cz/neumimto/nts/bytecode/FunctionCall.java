package cz.neumimto.nts.bytecode;

import net.bytebuddy.description.field.FieldDescription;

public class FunctionCall extends StackData {
    protected FieldDescription requiredField;

    public FunctionCall(FieldDescription requiredField) {
        this.requiredField = requiredField;
    }

    public FieldDescription getRequiredField() {
        return requiredField;
    }
}
