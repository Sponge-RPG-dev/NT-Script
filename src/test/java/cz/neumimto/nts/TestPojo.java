package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

@ScriptMeta.Function("TestPojo")
public class TestPojo {

    public double doubleField;
    public int intField;

    @ScriptMeta.Handler
    public TestPojo() {

    }
}
