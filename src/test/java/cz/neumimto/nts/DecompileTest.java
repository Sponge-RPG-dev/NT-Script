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

        C.c(100, null);
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
