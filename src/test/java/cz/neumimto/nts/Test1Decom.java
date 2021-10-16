package cz.neumimto.nts;

import java.util.Collection;
import java.util.function.Consumer;

public class Test1Decom implements ImplTargets.Subclass {


    @Override
    public Tests.Result run(Input input, Context context) {
        double k = 20;
        TestPojo p = new TestPojo();
        p.intField = (int) k;
        p.doubleField = k;
        return Tests.Result.OK;
    }

}
