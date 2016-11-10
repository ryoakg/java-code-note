class Main {
    static public void main(String... args) throws InterruptedException {
        Thread th1 = new Thread(() -> {
                System.out.println("hello1");
            });
        th1.start();
        th1.join();

        Thread th2 = new Thread() {
                public void run(){
                    System.out.println("hello2");
                }};
        th2.start();
        th2.join();

        System.out.println("Done!");
    }
}
