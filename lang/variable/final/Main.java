class C {
    static final StringBuilder sb = new StringBuilder("abc");
}
interface I {
    StringBuilder sb = new StringBuilder("abc");
}

class Main{
    static void f(final int i, final StringBuilder sb){
        // i = 1; // error: finalパラメータvに値を代入することはできません

        // sb = new StringBuilder("123"); // error: finalパラメータvに値を代入することはできません
        sb.append("xyz");       // OK
    }

    static public void main(String... args){
        // C.sb = new StringBuilder("123"); // error: final変数sbに値を代入することはできません
        C.sb.append("xyz");       // OK

        // I.sb = new StringBuilder("123"); // error: final変数sbに値を代入することはできません
        I.sb.append("xyz");       // OK

        f(10, new StringBuilder("123"));

        System.out.println("Done");
    }
}
