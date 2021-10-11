package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

public interface ImplTargets {

    interface Subclass extends ImplTargets {
        @ScriptMeta.ScriptTarget
        Tests.Result run(@ScriptMeta.NamedParam("input") Input input,
                            @ScriptMeta.NamedParam("context") Context context);
    }
}
