import java.io.IOException;

class Main{
    public static void throw_checked_ex()
        throws IOException      // 無いとコンパイルエラー
    // t2_1 のエラーは、この関数仕様に、引数、戻り値と同じ様に
    // どういう例外を出すか? という情報が含まれるみたいなので、
    // それが分からないというエラー
    {
        throw new IOException();
    }

    // 関数単位だと、例外は捕捉するか
    // throws 例外を出す関数だと分かる様にする必用がある
    public static void t1() {
        try {
            throw_checked_ex();
        } catch (IOException e) {
            System.out.println("t1: IOException");
        } finally {
            System.out.println("t1: finally");
        }
    }
    // throws が必用
    public static void t2()
        throws IOException      // 無いと t2_1, t2 両方でコンパイルエラー
    {
        throw_checked_ex();
        // try-catch しないでも コンパイルエラー
    }


    // この場合は throws 不要
    public static void throw_unchecked_ex() {
        throw new RuntimeException();
    }
    // throws も try-catch も不要
    public static void t3() {
        throw_unchecked_ex();
    }


    public static void main(String... args) {
        t1();
        // t2();
        t3();
        System.out.println("Done");
    }
}
