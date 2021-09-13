package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

@ScriptMeta.Function("print")
public class P {
    @ScriptMeta.Handler
    public void print(@ScriptMeta.NamedParam("val") Object o, @ScriptMeta.NamedParam("int") int i) {
        System.out.println(o);
        System.out.println(i);
    }
}
