import java.util.Deque;

public class Main{
    public static void ex(Deque<String> q){
        System.out.println("a -> " + q);
        q.push("a");

        System.out.println("b -> " + q);
        q.push("b");

        System.out.println("c -> " + q);
        q.push("c");

        System.out.println(q.peek() + " <- " + q);
        q.poll();

        System.out.println(q.peek() + " <- " + q);
        q.poll();

        System.out.println("d -> " + q);
        q.push("d");

        System.out.println(q.peek() + " <- " + q);
        q.poll();

        System.out.println(q.peek() + " <- " + q);
        q.poll();

        System.out.println(q.peek() + " <- " + q);
        q.poll();
    }

    public static void main(String... args){
        // ex(new java.util.ArrayDeque<>());
        ex(new java.util.LinkedList<>());
    }
}
