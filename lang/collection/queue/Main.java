import java.util.Queue;

public class Main{
    public static void ex(Queue<String> q){
        System.out.print(q);
        q.add("a");
        System.out.println(" <- a");

        System.out.print(q);
        q.add("b");
        System.out.println(" <- b");

        System.out.print(q);
        q.add("c");
        System.out.println(" <- c");

        System.out.println(q.peek() + " <- " + q);
        q.poll();

        System.out.println(q.peek() + " <- " + q);
        q.poll();

        System.out.print(q);
        q.add("d");
        System.out.println(" <- d");

        System.out.println(q.peek() + " <- " + q);
        q.poll();

        System.out.println(q.peek() + " <- " + q);
        q.poll();

        System.out.println(q.peek() + " <- " + q);
        q.poll();
    }

    public static void main(String... args){
        ex(new java.util.ArrayDeque<>());
        // ex(new java.util.LinkedList<>());
    }
}
