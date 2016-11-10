// ポイント:
// - Outer と Innerインスタンス が 1対多の関係になる

class Outer {
    static int static_f;
    int f;

    static class Inner {
        void m() {
            // 特定のインスタンスと関連付けられないので、
            // どのインスタンスを操作するのかが明確にならない
            // f = 10; // staticでない変数 fieldをstaticコンテキストから参照することはできません

            static_f = 10;  // OK

            System.out.println("Outer.Inner.method() is called.");
        }
    }

    void m() {
        // 外部クラスからはInnerで利用可
        Inner ic = new Inner();
    }
}

class Main {
    public static void main(String[] args) {
        Outer o = new Outer();
        // x.new Inner(); // compile error
        // Outerのインスタンスと、Innerのインスタンスには何も関係がないので
        // これは出来ない

        Outer.Inner i = new Outer.Inner();
        i.m();

        // Outer とは 1対多であって、1対1ではないので
        // いくつでも作る事ができる
        new Outer.Inner();
        new Outer.Inner();
        new Outer.Inner();
        new Outer.Inner();

        // Outer.Inner.m();

        System.out.println("Done");
    }
}
