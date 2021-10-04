package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

@Function("test_ctr")
public class DecompileTest {

    //A A;
 //   B B;
 //   C C;
 //   L L;
    P P;

    @Handler
    public DecompileTest(@NamedParam("int") int i) {
        System.out.println("DecompileTest init");
    }
    //  MP MP;

    public Tests.Result a(double k) {
     //   String test = "test";
     //   double d = 10000D;
     //   Runnable runnable = () -> P.print(d, test);
//
     //   runnable.run();
//
     //   Runnable runnable2 = () -> {
     //       P.print(0d, "FN NO ARGS");
     //   };
        DecompileTest test = new DecompileTest((int) k);
        return Tests.Result.OK;
    }

    public void d(double w) {

    }

}
