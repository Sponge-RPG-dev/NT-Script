package cz.neumimto.nts;

public class DecompileTest {

    A A;
    B B;
    C C;
    L L;
    P P;
    MP MP;

    public Tests.Result a() {
       // boolean b = false;
       // boolean a = true;
        int ldc = 70000;
        int b = 55000;
        String o = ";";

        boolean c = ldc < 70000;

        Runnable r = () -> {
            int w = ldc;
            boolean a =c;
            A.a(null,null);
            String k = "inside";
        };
        String w = "after";
        int k = 0;
        MP.mp(r);

    //   int i = (int) (1 * Math.random());
    //   int b = 30;
    //   boolean k = i < b;

      // Runnable r = () -> {
      //     int i = 0;
      // };



        return Tests.Result.OK;
    }

    public boolean someFunc()  {
        return false;
    }
}
