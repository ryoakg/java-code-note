import java.util.*;

public class Main{
    public static void separator(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    public static void iterator(Collection<Integer> xs){
        separator();
        Collection<Integer> ys = new ArrayList(xs);

        for(Iterator<Integer> i = ys.iterator(); i.hasNext(); ) {
            Integer s = i.next();
            if (s.equals(3)) i.remove();
        }
        System.out.println(ys);
    }

    public static void main(String... args){
        Collection<Integer> xs = new ArrayList(Arrays.asList(0,1,2,3,4,5,6));
        iterator(xs);
    }
}
