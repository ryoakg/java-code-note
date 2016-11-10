// ポイント:
// - Outerのインスタンスと、Innerのインスタンスが1対多になる
// - 同時に Outerと、Innerのインスタンスも1対多になる
// - Innerのインスタンスが所属する、Outerのインスタンスという考え方ができる
// - Outerのインスタンスから、Innerのインスタンスにアクセスするには
//   Outerのフィールドにコレクションを作って入れるとかしないとダメかも
// - Inner → Outer の方向だと、インスタンスそのものの変数は操作できないみたいだけど
//   フィールドとメソッドを使っては操作できる
// - 名前がなくて見えないけど、Outer に対する this みたいなフィールドがあると考えればいいかも
// - staticの有無に関らず、コンパイル結果は Outer$Inner.class になる

class Outer {
    int f;
    static int static_f;

    void m1(){
        System.out.println(f);
    }
    static void static_m1(){
        System.out.println(static_f);
    }

    class Inner {
        void inner_m() {
            // 外のclassのフィールドにアクセスできる
            // 所属する Outer が分かる様になっている為
            f = 5;
            // メソッドの場合も同様
            m1();
            // this みたいに Outer自身を取る事ができるかは分からないけど
            // フィールドとメソッドの名前がシャドゥしてなければ
            // Outer に対して、アクセス可能な何でも出来そうな気がする

            // Outer の static フィールドにアクセスできても困る事はなさそう
            static_f = 10;
            static_m1();
        }
    }


    // static メソッドの中で Inner のインスタンスは作れない
    // Innerのインスタンスが所属する、Outerのインスタンスがresolveできないので
    void m2() {
        Inner x1 = new Inner();
        Inner x2 = new Inner();
        System.out.println("hello");
    }
    static void static_m2() {
        // Inner ic = new Inner(); // error

        // staticでない変数 thisをstaticコンテキストから参照することはできません
        // とかエラーが出る
        // this は明示でないけど、new された Inner に関連付ける必用があるから
        // こういう表現になっているのかも
    }

    // このクラスは、中からだけ見える
    private class PrivateInner{}
    void private_m() {
        PrivateInner x = new PrivateInner();
    }
}

class Main {
    public static void main(String[] args) {
        Outer o = new Outer();

        // Outer と Inner のインスタンスが1対多なので、
        // Outer のインスタンスに new が関連付けられている
        Outer.Inner i = o.new Inner();
        // o が Outer のインスタンスである事は自明なので
        // o.new Outer.Inner()
        // みたいに書く必用はない
        // ところで new がメソッドみたいになっているという事は、
        // interface に inner class 作れるのか?

        i.inner_m();

        // アクセス制限もできる
        // o.new PrivateInner();   // Outer.PrivateInnerはOuterでprivateアクセスされます

        System.out.println("Done");
    }
}
