package cz.neumimto.nts;

public class DecompileTest {

    A A;
    B B;
    C C;
    L L;
    public Tests.Result a() {
       // boolean b = false;
       // boolean a = true;
       // int ldc = 70000;

        //String c = A.a("www", B.a(50, null));

      // Runnable r = () -> {
      //     int i = 0;
      // };

        for (Object o : L.c(10)) {
            int i = 0;
        }
        return Tests.Result.OK;
    }

    public boolean someFunc()  {
        return false;
    }
}
