package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

public interface ImplTargets {

    interface Subclass extends ImplTargets {
        @ScriptMeta.ScriptTarget
        Tests.Result run(@ScriptMeta.NamedParam("input") Input input,
                            @ScriptMeta.NamedParam("context") Context context);
    }


    @ScriptMeta.Handler
    @ScriptMeta.Function("damage")
    public boolean damage(
            @ScriptMeta.NamedParam("t|target") IEntity target,
            @ScriptMeta.NamedParam("e|damager") IEntity damager,
            @ScriptMeta.NamedParam("d|damage") double damage,
            @ScriptMeta.NamedParam("k|knockback") double knockback,
            @ScriptMeta.NamedParam("c|cause") EntityDamageEvent.DamageCause cause,
            @ScriptMeta.NamedParam("s|skill") ISkill e);

    public static class IEntity {}

    public static class ISkill{} ;

    public static class EntityDamageEvent {
        public static enum DamageCause {
            OK
        }
    }
}
