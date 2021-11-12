package cz.neumimto.nts;

import net.bytebuddy.jar.asm.Opcodes;

import java.util.List;
import java.util.Random;

import static cz.neumimto.nts.annotations.ScriptMeta.*;

@Function("test_ctr")
public class DecompileTest {

    @Handler
    public DecompileTest(@NamedParam("int") int i) {
        System.out.println("DecompileTest init");
    }



    public Tests.Result a(List<Double> k) {
        for (Double aDouble : k) {
            d(aDouble);
        }
        return Tests.Result.OK;
    }

    public void d(double w) {

    }

}
