package cz.neumimto.nts;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

@Function("method")
public class B {

    @Handler
    public String a(@NamedParam("int") int q, @NamedParam("missing") Object o) {
        System.out.println(q);
        return "";
    }
}
