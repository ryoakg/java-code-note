// https://docs.oracle.com/javase/8/docs/api/java/util/Formatter.html
class Main{
    static public void main(String... args){
        System.out.format("Local time: %tT\n", java.util.Calendar.getInstance());
        System.out.format("Local time: %1$tT\n", java.util.Calendar.getInstance());
        System.out.format("Unable to open file '%1$s': %2$s\n", "a", "b");
        System.out.format("Unable to open file '%1$s': %2$s\n", "b", "a");
    }
}
