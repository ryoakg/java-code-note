import java.io.IOException;

interface InoEx {
    public void f();
}
interface Iex {
    public void g() throws IOException;
}

class C1 implements Iex, InoEx {
    // 定義通り
    public void f() {}

    // throws を省略する事はできた
    public void g() {}
}

class C2 implements
             Iex
             // , InoEx
{
     // throws を追加する事は出来なかった
     // public void f() throws IOException {
     //     throw new IOException();
     // }

    // 定義通り
     public void g() throws IOException {}
}

class Main{
    public static void main(String... args) {
        C1 c1 = new C1();
        c1.f();
        c1.g();                 // try-catch 不要

        Iex iex1 = new C1();
        // iex1.g();         // 実体はC1で↑と同じだけど try-catch が必用

        C2 c2 = new C2();
        // c2.g(); // try-catch必用
        Iex iex2 = new C2();
        // iex2.g(); // try-catch必用

        System.out.println("Done");
    }
}
