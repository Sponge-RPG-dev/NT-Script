package cz.neumimto.nts;

import net.bytebuddy.jar.asm.Opcodes;

import java.util.Random;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

@Function("test_ctr")
public class DecompileTest {

    //A A;
 //   B B;
 //   C C;
 //   L L;
    P P;

    Opcodes po;

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
        double u = 0;
        double w = new Random().nextDouble();
        if (k > 10) {
            double q =50;
            if (k <= 70000) {
                return Tests.Result.NOK;
            }
            System.out.println(q);
        }
        return Tests.Result.OK;
    }

    public void d(double w) {

    }

}
