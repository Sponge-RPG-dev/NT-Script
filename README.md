Simple scripting langauge based on ANTLR4 that compiles into Java

## Language Reference ## 

 - Variable assignment
   - `@name = <value>`
       - `@stringVariable = "hello world"`
       - `@daysInWeek = 7`
       - `@boolVal = True`
 - Conditionals
   - ```
     IF @boolVal
        <Do stuff>
     END

 - Loops
   - ```
     FOREACH @item IN @array
       <statements>   
     END
     
 - Function call
   - `fnName{namedArg1=@variable1, namedArg3=@variable3}`


 - Lambda expr
   
   - ```
     @param1 = "text"
     @param2 = 456789
     @fn = FUNCTION @param1, @param2 
       <statements>
     END
     

## API ##

The compiler will generate only method bodies from the script. annotate method that you wish to generate
```
    public abstract class Test {
        @ScriptMeta.ScriptTarget
        public abstract Result test();
    }
```

To call java method from the script first define an annotated proxy

```
    @ScriptMeta.Function("print")
    public class PrintFn {
        @ScriptMeta.Handler
        public void print(@ScriptMeta.NamedParam("val") Object o, @ScriptMeta.NamedParam("int") int i) {
            System.out.println(o);
            System.out.println(i);
        }
    }
```

and provide its instanceto the context via add the builder

```
        NTScript context = new NTScript.Builder()
                .package_("cz.neumimto.test")
                .debugOutput("/tmp/test")
                .implementingType(Test.class)
                .withEnum(Result.class)
                .add(List.of(new PrintFn()))
                .setClassNamePattern("aaa")
                .build();

    Class aClass = script.parseScript("""
        @textVariable = "abcd"
        print{val=@textVariable}  
        RETURN Result.OK
    """);
```

The compiler will generate class as follows:

```
public class aaa0 extends Test {
     
      public PrintFn PrintFn;

      public Result test() {
            String var1 = "abcd";
            PrintFn.print(var1, null) ;
           return Result.OK
      }
}
```

- After calling constructor you should inject the PrintFn field.
- If you are using some sort of DI such as Guice you can use Builder methods `classAnnotations` and `fieldAnnotations` for simpler initialization.