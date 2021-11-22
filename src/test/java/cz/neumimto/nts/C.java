package cz.neumimto.nts;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

public class C {

    @Handler
    @Function("test")
    public boolean c(@NamedParam("int") double q, @NamedParam("pojo") TestPojo d, @NamedParam("float") float w,@NamedParam("string") String s) {
        return q < 100;
    }

    @Handler
    @Function("iface")
    public I iface() {
        return new A();
    }

    public interface I {}

    public static class A implements I {
        public double k =20;
    }
}
