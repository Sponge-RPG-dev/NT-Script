package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

@ScriptMeta.Function("mp")
public class MP {

    @ScriptMeta.Handler
    public void mp(@ScriptMeta.NamedParam("execute") Runnable r) {
        r.run();
    }
}
