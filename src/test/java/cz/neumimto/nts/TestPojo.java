package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

@ScriptMeta.Function("TestPojo")
public class TestPojo {

    public double doubleField;
    public int intField;

    private double privateField;

    private float floatField;

    private long longTypeField;

    @ScriptMeta.Handler
    public TestPojo() {

    }

    public long getLongTypeField() {
        return longTypeField;
    }

    public void setLongTypeField(long longTypeField) {
        this.longTypeField = longTypeField;
    }

    public TestPojo(int w) {
        System.out.println(w);
    }

    public void setPrivateField(double privateField) {
        this.privateField = privateField;
    }

    public double getPrivateField() {
        return privateField;
    }

    public float getFloatField() {
        return floatField;
    }
}
