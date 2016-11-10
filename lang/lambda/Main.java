public class Main{
    @FunctionalInterface
    interface Appender2 {
        public void appendInSAM2(StringBuilder sb, String s);
    }

    public static void main(String... args){
        Appender2 appender2 = (sb,s) -> sb.append(s);
        StringBuilder result = new StringBuilder();
        appender2.appendInSAM2(result, "abc");
        appender2.appendInSAM2(result, "def");

        System.out.println(result);
    }
}
