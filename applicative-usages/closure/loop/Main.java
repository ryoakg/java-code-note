public class Main{
    @FunctionalInterface
    interface F<T>{ F<T> eval(); }

    public static F<Integer> g(Integer a){
        F<Integer> x = () -> {
            System.out.println(a);
            return a > 0 ? g(a-1) : null;
        };
        return x;
    }

    public static void main(String... args){
        F<Integer> a = g(4);
        while ((a = a.eval()) != null);
    }
}
