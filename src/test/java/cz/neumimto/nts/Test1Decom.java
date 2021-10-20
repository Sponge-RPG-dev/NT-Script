package cz.neumimto.nts;

import java.util.Collection;
import java.util.Random;
import java.util.function.Consumer;

public class Test1Decom implements ImplTargets.Subclass {


    @Override
    public Tests.Result run(Input input, Context context) {

        double a = new Random().nextDouble();
        double b = new Random().nextDouble();
        double c = new Random().nextDouble();
        double d = new Random().nextDouble();

        double k = -a * (b/c) - d;
        System.out.println(k);
        return Tests.Result.OK;
    }

}
