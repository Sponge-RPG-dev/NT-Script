package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.regex.Pattern;

public class Tests {

    public enum Result {
        OK, NOK
    }

    public static abstract class Test {
        @ScriptMeta.ScriptTarget
        public Result test() {
            return null;
        }

        ;
    }

    @org.junit.jupiter.api.Test
    public void test() throws Exception {
        String k = """
         
         #C O M M E N T
         
         @text = "test"
         @bool_t = t
         @bool_f = false
         @int = 10000
         
         @param = call{string=@text, func=method{int=50}}
         
         IF test{int= @int, string=call{string=@text}}
             @int2 = 5000
         END
         
         @text="re-assigment"
         print{val=@text}
         
         IF @bool_f
             @int3=700000
         END
               
         @x = list{size=3}
         FOREACH @entity IN @x
            print{val=@entity}
         END
          
         print{val="POP NEXT"}
         list{size=50}
         
         FOREACH @entity IN list{size=5}
             print{val=@entity}
         END
               
         print{val="XXXX"}
               
         FOREACH @entity IN @x
            IF True
             print{val="CCC"}
            END
         END
         
         IF @int <= 70000
           print{val="@int <= 70000"}
         END
         
       #  todo bad operand stack int inlined bool
       #  @lesser = @int <= 70000 
         
         @test = test_ctr{int=@int}
         
         @obj = test_ctr{int=@int}
         
         IF @int <= 70000 
             print{val="10000 <= 70000"}
         END
         
         method{missing=@obj}
         @function1 = fn @int
            print{val="FN NO ARGS", int=@int}       
         END
         RETURN Result.OK
                """;

        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(Test.class)
                .withEnum(Result.class)
                .add(List.of(new A(), new B(), new C(), new L(), new MP(), new P()))
                .add(DecompileTest.class)
                .setClassNamePattern("aaa")
                .build();

        Class aClass = script.compile(k);
        Object o = aClass.newInstance();
        initAndRun(o);
    }

    @org.junit.jupiter.api.Test
    public void macro() throws Throwable {
        String test = """
            $say hello
            RETURN Result.OK
        """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(Test.class)
                .withEnum(Result.class)
                .add(List.of(new A(), new B(), new C(), new L(), new MP(), new P()))
                .add(DecompileTest.class)
                .macro(Pattern.compile("\\$say ([a-zA-Z0-1]*)"),"print{val=\"$1\"}")
                .setClassNamePattern("aaa")
                .build();

        Class aClass = script.compile(test);
        Object o = aClass.newInstance();
        initAndRun(o);
    }

    private void initAndRun(Object o) {
        try {
            o.getClass().getDeclaredField("A").set(o, new A());
        } catch (Throwable t) {
        }

        try {
            o.getClass().getDeclaredField("B").set(o, new B());
        } catch (Throwable t) {
        }
        try {
            o.getClass().getDeclaredField("C").set(o, new C());
        } catch (Throwable t) {
        }
        try {
            o.getClass().getDeclaredField("L").set(o, new L());
        } catch (Throwable t) {
        }
        try {
            o.getClass().getDeclaredField("P").set(o, new P());
        } catch (Throwable t) {
        }
        try {
            o.getClass().getDeclaredMethod("test").invoke(o);
        } catch (Throwable t) {
            t.printStackTrace();
        }
    }

}
