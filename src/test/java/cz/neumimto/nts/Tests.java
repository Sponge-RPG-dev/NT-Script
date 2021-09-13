package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;

import java.util.List;

public class Tests {

    public enum Result {
        OK
    }

    public static abstract class Test {
        @ScriptMeta.ScriptTarget
        public Result test(){
            return null;
        };
    }

    @org.junit.jupiter.api.Test
    public void test() throws Exception {
       String k = """
     #     @text = "test"
      #    @bool_t = t
       #   @bool_f = false
          @int = 10000
          
     #    #C O M M E N T
     #    
     #    @param = call{string=@text, func=method{int=50}}
     #    
     #    IF test{int= @int, string=call{string=@text}}
     #        @int2 = 5000
     #    END
     #    
     #    @text="re-assigment"
     #    print{val=@text}
     #    
     #    IF @bool_f
     #        @int3=700000
     #    END
     #  
     #    @x = list{size=3}
     #    FOREACH @entity IN @x
     #       print{val=@entity}
     #    END
     #     
     #    print{val="POP NEXT"}
     #    list{size=50}
     #    
     #    FOREACH @entity IN list{size=5}
     #        print{val=@entity}
     #    END
     #  
     #    print{val="XXXX"}
     #  
     #    FOREACH @entity IN @x
     #       IF True
     #        print{val="CCC"}
     #       END
     #    END
     #    
     #    IF @int <= 70000
     #      print{val="@int <= 70000"}
     #    END
          
          @lesser = @int <= 70000
          
          @function = fn @int @lesser
            @k = @int
          END
                  
          
          RETURN Result.OK
        """;
   // k = """
   //     @param = call{string="xxxx"}
   // """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(Test.class)
                .withEnum(Result.class)
                .add(List.of(new A(), new B(), new C(), new L(), new MP(), new P()))
                .setClassNamePattern("aaa")
                .build();

        Class aClass = script.parseScript(k);
        Object o = aClass.newInstance();
        try {
         //  o.getClass().getDeclaredField("A").set(o, new A());
         //  o.getClass().getDeclaredField("B").set(o, new B());
         //  o.getClass().getDeclaredField("C").set(o, new C());
         //  o.getClass().getDeclaredField("L").set(o, new L());
            o.getClass().getDeclaredField("P").set(o, new P());
          //  o.getClass().getDeclaredMethod("test").invoke(o);
        } catch (Throwable t) {
            t.printStackTrace();
        }

    }

}
