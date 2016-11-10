// in progress!!

import java.util.*;
import static java.lang.System.out;

public class Main{
    public static void separator(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    public static void constants(String... args){
        separator();
        out.println(Collections.EMPTY_LIST);
        out.println(Collections.EMPTY_MAP);
        out.println(Collections.EMPTY_SET);
    }

    public static void disjoint(){
        separator();
        List<Integer> as = Arrays.asList(1,2,3);
        Set<Integer> bs = new HashSet<>(Arrays.asList(10,11,12));
        Deque<Integer> cs = new ArrayDeque<>(Arrays.asList(1,110,120));

        System.out.println("disjoint("+as+","+bs+") -> " + Collections.disjoint(as,bs));
        System.out.println("disjoint("+bs+","+cs+") -> " + Collections.disjoint(bs,cs));
        System.out.println("disjoint("+cs+","+as+") -> " + Collections.disjoint(cs,as));
    }

    public static void mimMax(){
        separator();
        Collection<Integer> as = Arrays.asList(1,2,3);

        System.out.println(as+".max -> " + Collections.max(as));
        System.out.println(as+".min -> " + Collections.min(as));

        System.out.println(as+".max -> " + Collections.max(as, ((a,b) -> b.compareTo(a))));
        System.out.println(as+".min -> " + Collections.min(as, ((a,b) -> b.compareTo(a))));
    }

    public static void main(String... args){
        constants();
        disjoint();
        mimMax();

        // Collections.synchronizedCollection();

        // Collections.checkedCollection();
        // list, map, set とかに対して checked... というのがある
        // 同様に empty... というのもある

        // emptyIterator();
        // emptyListIterator();

        // インスタンスメソッドで十分
        // Collections.addAll();

        // deprecated
        // Collections.enumeration();

    }
}
