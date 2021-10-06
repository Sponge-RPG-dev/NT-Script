package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

@ScriptMeta.Function("print")
public class P {
    @ScriptMeta.Handler
    public void print(@ScriptMeta.NamedParam("int") double i, @ScriptMeta.NamedParam("v|val") Object o) {
        System.out.println(o);
        System.out.println(i);
    }
}
