package cz.neumimto.nts;

import cz.neumimto.nts.annotations.ScriptMeta;
import org.junit.jupiter.api.Test;
import org.opentest4j.TestAbortedException;

import java.lang.reflect.Executable;
import java.util.Arrays;
import java.util.Collections;
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
         
         text = "test"
         bool_t = t
         bool_f = false
         int = 10000
         
         param = call(string:text, func:method(int:50))
         
         IF test(int: int, string: call(string:text))
             int2 = 5000
         END
         
         text="re-assigment"
         print(val: text)
         
         IF bool_f
             int3=700000
         END
               
         x = list(size:3)
         FOREACH entity IN x
            print(val:entity)
         END
          
         print(val:"POP NEXT")
         list(size:50)
         
         FOREACH entity IN list(size:5)
             print(val:entity)
         END
               
         print(val:"XXXX")
               
         FOREACH entity IN x
            IF True
             print(val:"CCC")
            END
         END
         
         IF int <= 70000
           print(val:"int <= 70000")
         END
         
       #  todo bad operand stack int inlined bool
       #  lesser = int <= 70000 
         
         test = test_ctr(int:int)
         
         obj = test_ctr(int:int)
         
         IF int <= 70000 
             print(val:"10000 <= 70000")
         END
         
         method(missing:obj)
         function1 = fn int
            print(val:"FN NOARGS", int:int)       
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
                .setClassNamePattern("test_syntax")
                .build();

        Class aClass = script.compile(k);
        Object o = aClass.newInstance();
        initAndRun(o);
    }

    @org.junit.jupiter.api.Test
    public void macro() throws Throwable {
        String test = """
            $say hello
            $settings.abcd
            RETURN Result.OK
        """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(Test.class)
                .withEnum(Result.class)
                .add(List.of(new A(), new B(), new C(), new L(), new MP(), new P()))
                .add(DecompileTest.class)
                .macro(Pattern.compile("\\$say ([a-zA-Z0-1]*)"),"print(v:\"$1\")")
                .macro(Pattern.compile("\\$settings.([a-zA-Z0-1]*)"), "print(ctx:context, key:\"$1\")")
                .setClassNamePattern("aaa")
                .build();

        Class aClass = script.compile(test);
        Object o = aClass.newInstance();
        initAndRun(o);
    }

    @org.junit.jupiter.api.Test
    public void test1() throws Throwable {
        String test = """
                d = $settings.d
                r = $settings.r
        
                list = find(c: r, context:context)
        
                FOREACH entity in list
                    IF compare(e: entity, v: 5)
                       print(e: entity)
                    END
                END
        
                RETURN Result.OK
                """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(ImplTargets.Subclass.class)
                .withEnum(Result.class)
                .add(List.of(new TestFunctions()))
                .add(DecompileTest.class)
                .macro(Pattern.compile("\\$settings.([a-zA-Z0-1]*)"), "config_value(context:context, key:\"$1\")")
                .setClassNamePattern("test1")
                .build();

        Class aClass = script.compile(test);
        ImplTargets.Subclass o = (ImplTargets.Subclass) aClass.newInstance();
        initAndRun(o);
        o.run(new Input(), new Context());
    }

    @org.junit.jupiter.api.Test
    public void test_if() throws Throwable {
        String test = """
                d = $settings.d
                             
                IF compare(e: d, v: 5)
                   print(e: d)
                END
        
                RETURN Result.OK
                """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(ImplTargets.Subclass.class)
                .withEnum(Result.class)
                .add(List.of(new TestFunctions()))
                .add(DecompileTest.class)
                .macro(Pattern.compile("\\$settings.([a-zA-Z0-1]*)"), "config_value(context:context, key:\"$1\")")
                .setClassNamePattern("test_if")
                .build();

        Class aClass = script.compile(test);
        ImplTargets.Subclass o = (ImplTargets.Subclass) aClass.newInstance();
        initAndRun(o);
        o.run(new Input(), new Context());
    }

    @org.junit.jupiter.api.Test
    public void test2_put_get_field() throws Throwable {
        String test = """
                k = 20
                obj = TestPojo()
                obj.intField = k
                obj.doubleField = k
                obj.privateField = k
                obj.longTypeField = k
                
                get = obj.doubleField
                get_typecasted = obj.intField
                get_getter = obj.privateField
                
                obj.doubleField = k - k 
                
                RETURN Result.OK
                """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(ImplTargets.Subclass.class)
                .withEnum(Result.class)
                .add(new TestPojo())
                .add(TestPojo.class.getConstructor(), "TestPojo", Collections.emptyList())
                .setClassNamePattern("test2_putfield")
                .build();

        Class aClass = script.compile(test);
        ImplTargets.Subclass o = (ImplTargets.Subclass) aClass.newInstance();
        initAndRun(o);
        o.run(new Input(), new Context());
    }

    @org.junit.jupiter.api.Test
    public void test2_expr() throws Throwable {
        String test = """
                k = 20
                k = k * 8
                print(int:k)
                w = 2 * 2
                print(int:w)
                
                j = (3 / 3)
                print(int:j)
                
                j = (3 / 3) + 1
                print(int:j)
          
                j = -1 * (3 / 3) - 1
                print(int:j)
                
                RETURN Result.OK
                """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(ImplTargets.Subclass.class)
                .withEnum(Result.class)
                .add(TestPojo.class).add(new P())
                .setClassNamePattern("test3_expr")
                .build();

        Class aClass = script.compile(test);
        ImplTargets.Subclass o = (ImplTargets.Subclass) aClass.newInstance();
        initAndRun(o);
        o.run(new Input(), new Context());
    }

    @org.junit.jupiter.api.Test
    public void test4_lib() throws Throwable {
        String test = """
               l=random() * 0.4 - 0.2
               print(int:l)
               print(int:random() * 0.4 - 0.2)
               RETURN Result.OK
                """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(ImplTargets.Subclass.class)
                .withEnum(Result.class)
                .add(TestPojo.class).add(new P())
                .add(
                        Math.class.getDeclaredMethod("max", double.class, double.class),
                        List.of("a", "b")
                )
                .add(Math.class.getDeclaredMethod("random"), List.of())
                .add(
                        TestPojo.class.getConstructor(int.class), "Obj", List.of("w")
                )
                .setClassNamePattern("test4_lib")
                .build();

        Class aClass = script.compile(test);
        ImplTargets.Subclass o = (ImplTargets.Subclass) aClass.newInstance();
        initAndRun(o);
        o.run(new Input(), new Context());
    }

    @org.junit.jupiter.api.Test
    public void test5_read_primitive_and_ref() throws Throwable {
        String test = """
               l=20
               obj = TestPojo()
               float = obj.floatField
               test(pojo:obj, float:float)
               RETURN Result.OK
                """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(ImplTargets.Subclass.class)
                .withEnum(Result.class)
                .add(new C())
                .add(TestPojo.class)
                .add(TestPojo.class.getConstructor(int.class), "Obj", List.of("w"))
                .setClassNamePattern("test5_read_primitive_and_ref")
                .build();

        Class aClass = script.compile(test);
        ImplTargets.Subclass o = (ImplTargets.Subclass) aClass.newInstance();
        initAndRun(o);
        o.run(new Input(), new Context());
    }

    @org.junit.jupiter.api.Test
    public void test6_typecasts() throws Exception {
        String test = """
               obj = iface() as A
               obj.k = 50
               RETURN Result.OK
                """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(ImplTargets.Subclass.class)
                .withEnum(Result.class)
                .add(C.I.class)
                .add(C.A.class)
                .add(new C())
                .setClassNamePattern("test6_typecasts")
                .build();

        Class aClass = script.compile(test);
        ImplTargets.Subclass o = (ImplTargets.Subclass) aClass.newInstance();
        initAndRun(o);
        o.run(new Input(), new Context());
    }

    @org.junit.jupiter.api.Test
    public void test8_dont_inject_static_calls() throws Exception {
        String test = """
               a = 1
               b = 2
               c = min(a:a, b:b)
               
               RETURN Result.OK
                """;
        NTScript script = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(ImplTargets.Subclass.class)
                .withEnum(Result.class)
                .add(Math.class.getMethod("min", double.class, double.class), Arrays.asList("a","b"))
                .setClassNamePattern("test8_dont_inject_static_calls")
                .build();

        Class aClass = script.compile(test);
        try {
            aClass.getField("Math");
            throw new RuntimeException("Field present");
        } catch (NoSuchFieldException e) {
        }
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
            o.getClass().getDeclaredField("TestFunctions").set(o, new TestFunctions());
        } catch (Throwable t) {
        }
        try {
            o.getClass().getDeclaredMethod("test").invoke(o);
        } catch (Throwable t) {
        }
    }

}
