import java.util.*;

public class Main{
    public static void separator(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    public static void putGet(Map<String,Integer> m){
        separator();

        System.out.println(m + " <- (\"a\",1)");
        m.put("a",1);

        System.out.println(m+"[\"a\"] -> "+m.get("a"));
        System.out.println(m+"[\"b\"] -> "+m.get("b"));
        System.out.println(m+"[\"a\"] | 0 -> "+m.getOrDefault("a",0));
        System.out.println(m+"[\"b\"] | 0 -> "+m.getOrDefault("b",0));

        System.out.println(m + " <- (\"a\",10) if not exists");
        m.putIfAbsent("a",10);

        System.out.println(m + " <- (\"b\",20) if not exists");
        m.putIfAbsent("b",20);

        System.out.println(m);
    }

    public static void replace(Map<String,Integer> m){
        separator();
        Map<String,Integer> n = new HashMap(m);

        System.out.print(n + " -> ");
        n.replace("a", 10);
        System.out.println(n);

        System.out.print(n + " -> ");
        n.replace("x", 5000);
        System.out.println(n);
    }

    public static void merge(Map<String,Integer> m){
        separator();
        Map<String,Integer> n = new HashMap(m);

        System.out.print(n + " -> ");
        n.merge("a", 10, (cur,v) -> cur + v);
        System.out.println(n);

        System.out.print(n + " -> ");
        n.merge("a", 100, (cur,v) -> cur + v);
        System.out.println(n);

        System.out.print(n + " -> ");
        n.merge("x", 4, (cur,v) -> cur + v);
        System.out.println(n);
    }

    public static void compute(Map<String,Integer> m){
        separator();
        Map<String,Integer> n;

        n = new HashMap<>(m);
        n.compute("a", (k,v) -> v+100);
        n.compute("c", (k,v) -> null);
        System.out.println(m + " -> " + n);

        n = new HashMap<>(m);
        n.computeIfPresent("a", (k,v) -> null);
        System.out.println(m + " -> " + n);

        n = new HashMap<>(m);
        n.computeIfAbsent("x", (k) -> 2000);
        System.out.println(m + " -> " + n);
    }

    public static void extendedForK(Map<String,Integer> m){
        separator();
        for(String k : m.keySet())
            System.out.println(k + " -> " + m.get(k));
    }

    public static void extendedForV(Map<String,Integer> m){
        separator();
        for(Integer i : m.values())
            System.out.println(i);
    }

    public static void extendedForKV(Map<String,Integer> m){
        separator();
        for(Map.Entry<String,Integer> e : m.entrySet())
            System.out.println(e.getKey() + " -> " + e.getValue());
    }

    public static void Kiter(Map<String,Integer> m){
        separator();
        for(Iterator<String> i = m.keySet().iterator(); i.hasNext(); )
            System.out.println(i.next());
    }

    public static void Viter(Map<String,Integer> m){
        separator();
        for(Iterator<Integer> i = m.values().iterator(); i.hasNext(); )
            System.out.println(i.next());
    }

    public static void KViter(Map<String,Integer> m){
        separator();
        for(Iterator<Map.Entry<String,Integer>> i = m.entrySet().iterator(); i.hasNext(); )
            System.out.println(i.next());
    }

    public static void main(String... args){
        Map<String, Integer> m =
            new HashMap<String,Integer>() {{
                put("a", 0); put("b", 1); put("c", 2);
            }};

        // putGet(Collections.EMPTY_MAP); // UnsupportedOperationException
        putGet(new HashMap<>());
        // putGet(new LinkedHashMap<>());
        // putGet(new TreeMap<>());

        replace(m);
        compute(m);
        merge(m);

        extendedForK(m);
        extendedForV(m);
        extendedForKV(m);

        Kiter(m);
        Viter(m);
        KViter(m);
    }
}
