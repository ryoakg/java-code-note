import java.util.WeakHashMap;

class Main{
    public static void main(String... args){
        String key = new String("foo");
        WeakHashMap<String, Integer> m = new WeakHashMap<String, Integer>();

        m.put(key,1);
        System.out.print(m);

        key = null;
        System.gc();
        System.out.println(" => " + m);
    }
}
