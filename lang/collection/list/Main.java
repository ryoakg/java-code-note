import java.util.List;

public class Main{
    public static void separator(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    public static void insertAndClear(List<String> xs){
        separator();
        List<String> l = new java.util.ArrayList<>(xs);

        System.out.println(l + " <- \"1\"");
        l.add("1");
        System.out.println(l + " <- \"2\"");
        l.add("2");

        System.out.println(l + "[1] <- \"A\"");
        l.add(1,"A");
        System.out.println(l + "[1] <- \"B\"");
        l.add(1,"B");
        System.out.println(l + "[2] <- \"C\"");
        l.add(2,"C");

        System.out.println(l + ".clear()");
        l.clear();

        List<String> ys = java.util.Arrays.asList("1","2","3");
        System.out.println(l + " <- " + ys);
        l.addAll(ys);

        List<String> zs = java.util.Arrays.asList("x","y","z");
        System.out.println(l + "[2] <- " + zs);
        l.addAll(2,zs);

        System.out.println(l);
    }

    public static void map(List<String> xs){
        separator();
        List<String> l = new java.util.ArrayList<>(xs);

        System.out.println(l);
        l.replaceAll(x -> x.toUpperCase());
        System.out.println(l);
    }

    public static void sort(){
        separator();
        List<String> xs = java.util.Arrays.asList("a","c","b");

        System.out.print(xs + " -> ");
        xs.sort((a,b) -> a.compareTo(b));
        System.out.println(xs);
    }

    public static void listIterator(List<String> l){
        separator();
        for(java.util.ListIterator<String> i = l.listIterator(); i.hasNext(); )
            System.out.println(i.next());
        System.out.println();
        for(java.util.ListIterator<String> i = l.listIterator(l.size()); i.hasPrevious(); )
            System.out.println(i.previous());
    }

    public static void arraysAsList(){
        List<String> list = java.util.Arrays.asList("a","b","c");

        separator();
        for(String x : list) System.out.print(x+' ');
        System.out.println();
        // list.add("x");      // java.lang.UnsupportedOperationException
        // list.remove(0);     // java.lang.UnsupportedOperationException
        // list.clear();
    }

    public static void main(String... args){
        List<String> xs = java.util.Arrays.asList("a","b","c");

        insertAndClear(xs);
        map(xs);
        listIterator(xs);
        sort();
        arraysAsList();
    }
}
