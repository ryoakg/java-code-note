import java.util.*;

public class Main{
    public static void separator(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    public static void insert(Collection<String> xs){
        separator();
        Collection<String> ys = new ArrayList<>(xs);

        System.out.println(ys + " <- \"A\"");
        ys.add("A");
        System.out.println(ys + " <- \"B\"");
        ys.add("B");

        Collection<String> zs = Arrays.asList("1","2","3");
        System.out.println(ys + " <- " + zs);
        ys.addAll(zs);
    }

    public static void clear(Collection<String> xs){
        separator();
        Collection<String> ys = new ArrayList<>(xs);

        System.out.println(ys + ".clear()");
        ys.clear();
        System.out.println(ys);
    }

    public static void mask(Collection<String> xs){
        separator();
        Collection<String> ys = new ArrayList<>(xs);
        Collection<String> zs = Arrays.asList("b","c");
        ys.retainAll(zs);
        System.out.printf("%s - %s -> %s\n", xs, zs, ys);
    }

    public static void remove(Collection<String> xs){
        separator();
        Collection<String> ys = new ArrayList<>(xs);

        System.out.println(ys + " --remove--> a");
        ys.remove("a");

        System.out.println(ys + " --remove--> " + xs);
        ys.removeAll(xs);

        System.out.println(ys);
    }

    public static void remove_if(){
        separator();
        Collection<Integer> xs = new HashSet(Arrays.asList(0,1,2,3,4,5));

        System.out.println("remove odd from " + xs);
        xs.removeIf(x -> x % 2 == 1);
        System.out.println(xs);
    }

    public static void contains(Collection<String> xs){
        separator();

        System.out.printf("%s contains a ? -> %s\n", xs, xs.contains("a"));
        System.out.printf("%s contains x ? -> %s\n", xs, xs.contains("x"));

        Collection<String> ys = new ArrayList<>(xs);
        ys.remove("a");
        System.out.printf("%s contains %s ? -> %s\n", xs, ys, xs.containsAll(ys));

        Collection<String> zs = new ArrayList<>(xs);
        zs.add("x");
        System.out.printf("%s contains %s ? -> %s\n", xs, zs, xs.containsAll(zs));
    }

    public static void equals(Collection<String> xs){
        separator();
        Collection<String> ys;

        System.out.printf("HashSet:%s = HashSet:%s ⇔ %s (the rhs is the same as lhs)\n", xs, xs, xs.equals(xs));

        ys = new HashSet<>(xs);
        System.out.printf("HashSet:%s = HashSet:%s ⇔ %s\n", xs, ys, xs.equals(ys));

        ys = new TreeSet<>(xs);
        System.out.printf("HashSet:%s = TreeSet:%s ⇔ %s\n", xs, ys, xs.equals(ys));

        ys = new ArrayList<>(xs);
        System.out.printf("HashSet:%s = ArrayList:%s ⇔ %s\n", xs, ys, xs.equals(ys));
    }

    public static void to_array(Collection<String> xs){
        separator();
        System.out.println(xs.toArray()); // Array of Object
        System.out.println(xs.toArray(new String[0])); // Array of String
        for (String x : xs.toArray(new String[0]))
            System.out.print(x + " ");
        System.out.println();
    }

    public static void iterator(Collection<String> xs){
        separator();
        for(Iterator<String> i = xs.iterator(); i.hasNext(); )
            System.out.println(i.next());
    }

    public static void main(String... args){
        Collection<String> xs = new HashSet(Arrays.asList("a","b","c"));

        insert(xs);
        clear(xs);
        contains(xs);
        remove(xs);
        remove_if();
        equals(xs);
        mask(xs);
        to_array(xs);

        iterator(xs);

        // spliterator();
        // stream();
    }
}
