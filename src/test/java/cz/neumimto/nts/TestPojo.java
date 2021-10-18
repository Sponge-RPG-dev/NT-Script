package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

@ScriptMeta.Function("TestPojo")
public class TestPojo {

    public double doubleField;
    public int intField;

    private double doubleFieldViaSetter;
    @ScriptMeta.Handler
    public TestPojo() {

    }

    public void doubleFieldViaSetter(double doubleField) {
        this.doubleField = doubleField;
    }
}
