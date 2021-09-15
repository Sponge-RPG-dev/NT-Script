package cz.neumimto.nts;

public class DecompileTest {

    //A A;
 //   B B;
 //   C C;
 //   L L;
    P P;
  //  MP MP;

    public Tests.Result a() {
       // boolean b = false;
       // boolean a = true;
        String a = "A";
        int c = 2;
        Runnable r = () ->{
            P.print(a, c);
        } ;


    //   int i = (int) (1 * Math.random());
    //   int b = 30;
    //   boolean k = i < b;

      // Runnable r = () -> {
      //     int i = 0;
      // };



        return Tests.Result.OK;
    }
}
