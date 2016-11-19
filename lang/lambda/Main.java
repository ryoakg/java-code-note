public class Main{
    public static void separator(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    @FunctionalInterface
    interface Appender2 {
        public void appendInSAM2(StringBuilder sb, String s);
    }
    public static void define_lambda_type(){
        separator();

        Appender2 appender2 = (sb,s) -> sb.append(s);
        StringBuilder result = new StringBuilder();
        appender2.appendInSAM2(result, "abc");
        appender2.appendInSAM2(result, "def");

        System.out.println(result);
    }

    public static void scope1(){
        separator();

        String str = "a string outside the lambda.";
        Runnable r = () -> { System.out.println(str); };
        r.run();
    }

    public static void scope2(){
        separator();

        String str = "a string outside the lambda.";
        Runnable[] rs = new Runnable[1];
        Runnable r = () -> {
            rs[0] = () -> { System.out.println(str); };
        };
        r.run();
        rs[0].run();
    }

    public static void substitution(){
        separator();

        /*
        String s = null;
        Runnable r = () -> {
            // s が final でないと lambda 内では使えない
            // でも final にすると代入できない
            s = "a";
        };
        */

        // 配列を使えば、中に代入しても配列自体は final なので問題ない
        String[] ss = new String[1];
        Runnable r2 = () -> {
            ss[0] = "a";
        };

    }

    public static void main(String... args){
        define_lambda_type();
        substitution();
        scope1();
        scope2();
    }
}
