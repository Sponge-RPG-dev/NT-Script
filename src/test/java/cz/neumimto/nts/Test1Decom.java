package cz.neumimto.nts;

import java.util.Collection;
import java.util.Random;
import java.util.Vector;
import java.util.function.Consumer;

public class Test1Decom implements ImplTargets.Subclass {

    private P P;

    @Override
    public Tests.Result run(Input input, Context context) {
        P.print(Math.random() * 0.4 - 0.2, null);
        return Tests.Result.OK;
    }

    @Override
    public boolean damage(IEntity target, IEntity damager, double damage, double knockback, EntityDamageEvent.DamageCause cause, ISkill e) {
        W w = new W(10, 20, target);
        System.out.println(w);
        return true;
    }

    public record W(int i, int b, IEntity target){}
}
