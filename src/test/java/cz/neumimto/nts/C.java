package cz.neumimto.nts;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

public class C {

    @Handler
    @Function("test")
    public boolean c(@NamedParam("int") double q, @NamedParam("pojo") TestPojo d, @NamedParam("float") float w,@NamedParam("string") String s) {
        return q < 100;
    }
}
