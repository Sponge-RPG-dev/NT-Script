package cz.neumimto.nts;

public class DecompileTest {

    //A A;
 //   B B;
 //   C C;
 //   L L;
    P P;

    public DecompileTest(int i) {

    }
    //  MP MP;

    public Tests.Result a(double k) {
        String test = "test";
        double d = 10000D;
        Runnable runnable = () -> P.print(d, test);

        runnable.run();

        Runnable runnable2 = () -> {
            P.print(0d, "FN NO ARGS");
        };

        return Tests.Result.OK;
    }

    public void d(double w) {

    }

}
