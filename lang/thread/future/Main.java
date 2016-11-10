import java.util.concurrent.*;

class Main {
    static public void main(String... args) throws InterruptedException, ExecutionException {
        ExecutorService ex = Executors.newFixedThreadPool(8);
        int i;

        Future<Integer> f1 = ex.submit(() -> {
                Thread.sleep(1000);
                return 5;
            });
        System.out.println("now getting result.");
        i = f1.get();
        System.out.println("done: " + i);

        Future<Integer> f2 = ex.submit(new Callable<Integer>(){
                public Integer call() {
                    return 10;
                }});
        System.out.println("now getting result.");
        i = f2.get();
        System.out.println("done: " + i);

        ex.shutdown();
    }
}
