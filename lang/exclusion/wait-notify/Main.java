// notify-wait の方が synchronized より細かい制御ができると思う
// あと謎なのは、何で Object に notify-wait が含まれるのか?という事
// 全てがこの機能を持つ必用はないと思う。歴史的な事情?

class Main {
    public static void title(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    public static void without_synchronized() {
        title();

        Object o = new Object();
        try{
            o.wait();
        } catch (IllegalMonitorStateException e) {
            System.out.println("IllegalMonitorStateException!");
        } catch (InterruptedException e) {
            System.out.println("InterruptedException!");
        }
    }

    public static void sequence() {
        title();

        Object lock = new Object();
        Thread producer = new Thread(() -> {
                try {
                    Thread.sleep(1000); // 後からスタートしたい

                    System.out.println("producer: entering monitor lock now");System.out.flush();
                    synchronized(lock) {
                        // 相手が wait() に入ると、この synchronized に入れる
                        System.out.println("producer: just enter monitor lock and sleep 1sec");System.out.flush();
                        Thread.sleep(1000);
                        System.out.println("producer: just execute notifyAll()");System.out.flush();
                        lock.notifyAll();
                        System.out.println("producer: sleep 1sec");System.out.flush();
                        Thread.sleep(1000);
                        System.out.println("producer: just leaving monitor lock");System.out.flush();
                    }
                    // 挙動を見ると notify 後 synchronized を抜けたら、wait も抜ける様子
                    // notify のタイミングではない
                    System.out.println("producer: just left monitor lock");System.out.flush();
                } catch (InterruptedException e){
                    System.out.println("producer: an InterruptedException is occured.");
                }});
        Thread consumer = new Thread(() -> {
                try{
                    System.out.println("consumer: entering monitor lock now");System.out.flush();
                    synchronized(lock) {
                        System.out.println("consumer: just enter monitor lock and sleep 1sec");System.out.flush();
                        Thread.sleep(1000);
                        System.out.println("consumer: going to wait()");System.out.flush();
                        lock.wait();
                        System.out.println("consumer: just leaving monitor wait()");System.out.flush();
                    }
                    System.out.println("consumer: just left monitor wait()");System.out.flush();
                } catch (InterruptedException e){
                    System.out.println("producer: an InterruptedException is occured.");
                }});

        try{
            consumer.start();
            producer.start();
            producer.join(); consumer.join();
        } catch (InterruptedException e){
            System.out.println("an InterruptedException is occured.");
        }
    }

    static public void main(String... args) {
        without_synchronized();
        sequence();
        System.out.println("Done!");
    }
}
