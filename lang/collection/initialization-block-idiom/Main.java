import java.util.*;

public class Main{
    public static void main(String... args){
        List<String> l = new ArrayList<String>() {{add("a"); add("b"); add("c");}};
        System.out.println(l);

        Map<String, Integer> m = new java.util.HashMap<String,Integer>() {{put("a", 0); put("b", 0); put("c", 2);}};
        System.out.println(m);
    }
}
