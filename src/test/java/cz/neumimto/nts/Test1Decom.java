package cz.neumimto.nts;

import java.util.Collection;

public class Test1Decom implements ImplTargets.Subclass {

    protected TestFunctions testFunctions;

    @Override
    public Tests.Result run(Input input, Context context) {
        double d = testFunctions.configValue(context, "d");
        double r = testFunctions.configValue(context, "r");
        Collection<Number> objects = testFunctions.find(context, (int) r);
        for (Number object : objects) {
            if (testFunctions.compare( object, 5D)) {
                testFunctions.print( object);
            }
        }
        return Tests.Result.OK;
    }
}
