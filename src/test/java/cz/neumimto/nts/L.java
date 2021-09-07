package cz.neumimto.nts;

import java.util.Collections;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

@Function("list")
public class L {

    @Handler
    public Iterable c(@NamedParam("size") int q) {
        return Collections.emptyList();
    }
}
