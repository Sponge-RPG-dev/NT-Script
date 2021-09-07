package cz.neumimto.nts;


import cz.neumimto.nts.annotations.ScriptMeta;

@ScriptMeta.Function("call")
public class A {

    @ScriptMeta.Handler
    public String a(@ScriptMeta.NamedParam("string") String w, @ScriptMeta.NamedParam("func") String u) {
        System.out.println(w + " " + u);
        return w;
    }
}
