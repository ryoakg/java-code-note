import java.io.IOException;

class Main{
    public static void t1() {
        try {
            try {
                throw new IOException();
            } catch (IOException e) {
                System.out.println("t1 inner: IOException");
                throw e;        // 無いとコンパイルエラー
                // 外側の catch (IOException e) が無意味になるので
            } finally {
                System.out.println("t1 inner: finally");
            }
        } catch (IOException e) {
            System.out.println("t1 outer: IOException");
        } finally {
            System.out.println("t1 outer: finally");
        }
    }

    public static void t2() {
        System.out.println("1");
        throw new IOException();

        // ここは通らないので、コンパイルエラー
        // System.out.println("2");
    }

    public static void main(String... args) {
        t1();
        System.out.println("Done");
    }
}
