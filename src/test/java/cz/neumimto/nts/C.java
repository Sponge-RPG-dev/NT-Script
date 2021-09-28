package cz.neumimto.nts;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

@Function("test")
public class C {

    @Handler
    public boolean c(@NamedParam("int") double q, @NamedParam("string") String s) {
        return q < 100;
    }
}
