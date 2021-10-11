package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;
import org.junit.jupiter.api.DisplayName;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class TestFunctions {

    @ScriptMeta.Function("config_value")
    @ScriptMeta.Handler
    public double configValue(@ScriptMeta.NamedParam("context") Context context, @ScriptMeta.NamedParam("key") String key) {
        return 2;
    }

    @ScriptMeta.Function("find")
    @ScriptMeta.Handler
    public Collection<Number> find(@ScriptMeta.NamedParam("context") Context context, @ScriptMeta.NamedParam("c|count") int c) {
        List<Number> l = new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            l.add(new Double(ThreadLocalRandom.current().nextDouble(10)));
        }
        return l;
    }

    @ScriptMeta.Function("compare")
    @ScriptMeta.Handler
    public boolean compare(@ScriptMeta.NamedParam("e") Number n, @ScriptMeta.NamedParam("v|value") double k) {
        return n.doubleValue() < k;
    }

    @ScriptMeta.Function("print")
    @ScriptMeta.Handler
    public void print(@ScriptMeta.NamedParam("e") Number n) {
        System.out.println(n);
    }
}
