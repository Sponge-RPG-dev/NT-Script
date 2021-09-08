package cz.neumimto.nts;

public class DecompileTest {

    A A;
    B B;
    C C;
    L L;
    P P;

    public Tests.Result a() {
       // boolean b = false;
       // boolean a = true;
       // int ldc = 70000;

        //String c = A.a("www", B.a(50, null));

        if (C.c(50, A.a("w", null))) {
            int i = 999;
        }

      // Runnable r = () -> {
      //     int i = 0;
      // };

        Iterable c = L.c(50);
        for (Object o : c) {
            int i = 56000;
        }

        String qqqqq = "QQQQQ";

        for (Object o : L.c(10)) {
            P.print(o, 1);
            int i = 70000;
        }

        return Tests.Result.OK;
    }

    public boolean someFunc()  {
        return false;
    }
}
