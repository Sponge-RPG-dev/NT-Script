package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

@ScriptMeta.Function("TestPojo")
public class TestPojo {

    public double doubleField;
    public int intField;

    private double privateField;

    private float floatField;

    @ScriptMeta.Handler
    public TestPojo() {

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
