import java.util.*;

// http://stackoverflow.com/questions/3590677/how-to-union-intersect-difference-and-reverse-data-in-java
public class Main{
    public static void separator(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    public static void union(Set<Integer> a, Set<Integer> b){
        separator();
        Set<Integer> c = new TreeSet<Integer>(a);
        c.addAll(b);
        System.out.printf("%s ∪ %s\n%s\n",a,b,c);
    }
    public static void intersection(Set<Integer> a, Set<Integer> b){
        separator();
        Set<Integer> c = new TreeSet<Integer>(a);
        c.retainAll(b);
        System.out.printf("%s ∩ %s\n%s\n",a,b,c);
    }
    public static void difference(Set<Integer> a, Set<Integer> b){
        separator();
        Set<Integer> c = new TreeSet<Integer>(a);
        c.removeAll(b);
        System.out.printf("%s - %s\n%s\n",a,b,c);
    }

    public static void main(String... args){
        // Set<Integer> a = new TreeSet<Integer>(Arrays.asList(new Integer[]{0,1,2,3}));
        // Set<Integer> b = new TreeSet<Integer>(Arrays.asList(new Integer[]{2,3,4,5}));

        // Set<Integer> a = new HashSet<Integer>(Arrays.asList(new Integer[]{0,1,2,3}));
        // Set<Integer> b = new HashSet<Integer>(Arrays.asList(new Integer[]{2,3,4,5}));

        Set<Integer> a = new LinkedHashSet<Integer>(Arrays.asList(new Integer[]{0,1,2,3}));
        Set<Integer> b = new LinkedHashSet<Integer>(Arrays.asList(new Integer[]{2,3,4,5}));

        union(a,b);
        intersection(a,b);
        difference(a,b);
    }
}
