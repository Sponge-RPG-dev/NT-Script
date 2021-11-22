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

    public boolean a(IEntity t, IEntity d, double k) {
        TestPojo testPojo = new TestPojo();
        testPojo.setLongTypeField((long) k);

        return true;
    }


    @Override
    public boolean damage(IEntity target, IEntity damager, double damage, double knockback, EntityDamageEvent.DamageCause cause, ISkill e) {
        return false;
    }
}
