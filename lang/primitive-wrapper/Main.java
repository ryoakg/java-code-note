import java.text.NumberFormat;

public class Main {
    public static void title(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    // http://stackoverflow.com/questions/74674/how-to-do-i-check-cpu-and-memory-usage-in-java
    public static void memory_usage(){
        Runtime runtime = Runtime.getRuntime();
        NumberFormat format = NumberFormat.getInstance();

        StringBuilder sb = new StringBuilder();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        System.out.println("free memory: " + format.format(freeMemory / 1024));
        System.out.println("allocated memory: " + format.format(allocatedMemory / 1024));
        System.out.println("max memory: " + format.format(maxMemory / 1024));
        System.out.println("total free memory: " + format.format((freeMemory + (maxMemory - allocatedMemory)) / 1024));
    }

    public static void substitute(){
        title();
        Integer a = new Integer(0);
        Integer b = a;
        a++;
        System.out.printf("a!=b => a:%d, b:%d\n", a, b);
    }

    public static void cost(){
        title();

        System.out.println("initial");
        memory_usage();
        for(long i = 0L; i<10000000; i++);

        System.out.println("\nafter loop with long");
        memory_usage();

        for(Long i = 0L; i<10000000; i++);
        System.out.println("\nafter loop with java.lang.Long(primitive wrapper)");
        memory_usage();
    }

    public static void main(String... args){
        substitute();
        cost();
    }
}
