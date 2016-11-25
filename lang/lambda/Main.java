public class Main{
    public static void separator(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    @FunctionalInterface
    interface Appender2 {
        public void appendInSAM2(StringBuilder sb, String s);
    }
    public static void define_lambda_type(){
        separator();

        Appender2 appender2 = (sb,s) -> sb.append(s);
        StringBuilder result = new StringBuilder();
        appender2.appendInSAM2(result, "abc");
        appender2.appendInSAM2(result, "def");

        System.out.println(result);
    }

    public static void scope1(){
        separator();

        String str = "a string outside the lambda.";
        Runnable r = () -> { System.out.println(str); };
        r.run();
    }

    public static void scope2(){
        separator();

        String str = "a string outside the lambda.";
        Runnable[] rs = new Runnable[1];
        Runnable r = () -> {
            rs[0] = () -> { System.out.println(str); };
        };
        r.run();
        rs[0].run();
    }

    public static void substitution(){
        separator();

        /*
        String s = null;
        Runnable r = () -> {
            // s が final でないと lambda 内では使えない
            // でも final にすると代入できない
            s = "a";
        };
        */

        // 配列を使えば、中に代入しても配列自体は (実質)final なので問題ない
        String[] ss = new String[1];
        Runnable r2 = () -> {
            ss[0] = "a";
        };

        // 何で final じゃないとダメなのか?
        //
        // 多分 Java の ラムダ は(外側のスコープにある)オブジェクト(値)を
        // キャプチャするからだと思う。
        // 変数(名前)をキャプチャするのでなく。
        //
        // JS とかで同じ様な事をやろうとしたら、変数をキャプチャする。
        // なのでこれはクロージャと言える。
        // クロージャ(closure)は、変数を閉じる(close)
        // っていうのが名前の由来だったと思う。
        //
        // 例えば、以下はコンパイルエラーだけど JS だとしたら…
        /*
          String s = "a";
          Runnable g1 = () -> { System.out.println(s); };
          Runnable g2 = () -> { s = "b"; };
          g1.run(); // prints "a\n"
          g2.run();
          g1.run(); // prints "b\n"
        */
        // "a\nb\n" が表示される。
        //
        // これを続けて JS的な解釈をするとポイントは以下2点
        //   (1) s っていう入れ物の中身が "a" -> "b" になる
        //   (2) g1,g2 は両方とも s っていう入れ物を参照している
        //
        // で、何で Java がコンパイルできないかというと、
        // (2) を満さないから
        // 一般的にいうと、
        // ラムダは変数を参照しないで、オブジェクト("a"とか"b")を参照する
        // (これは最初にいった事。キャプチャっていう単語を使ったけど。)
        //
        // これだけ考えれば、Java より JS の方が良い気もするけどそうでもない。
        // 実は Java の方が無駄な動作(間接参照)が少ない。
        //
        // JS はクロージャの中でオブジェクトを操作しようと思ったら
        //   1. コンパイラが決めた 変数sに対応する固定の場所から
        //      「「オブジェクトのアドレス」が入っているアドレス」を取り出す
        //      (固定の場所は、スタックフレームとかディスプレイの中の相対的な位置とか、レジスタとか)
        //   2. ↑の「「オブジェクトのアドレス」が入っているアドレス」から
        //      「オブジェクトのアドレス」を取り出す
        //   3. ↑の「オブジェクトのアドレス」からオブジェクトを取り出す
        // と3段階の操作が必用になる
        // (※ 参照を関数に渡すだけなら2で終り)
        // (※ 整数とか特定の小さいデータに関しては、もうちょっと最適化できるかも)
        //
        // これが Java の場合だと
        //   1. コンパイラが決めた 変数sに対応する固定の場所から
        //      「オブジェクトのアドレス」を取り出す
        //   2. ↑の「オブジェクトのアドレス」からオブジェクトを取り出す
        // と2段階の操作
        // (※ 参照を関数に渡すだけなら1で終り)
        // (※ Javaは確か出来ないけど、整数とかならそれを「固定の場所」に入れとけば一番速い)
        //
        // さらに、この例では配列を使う事で、オブジェクトの書換えをしているけど
        // これは結局、間接参照を増やしているので、動作としては JS と同じ事をやっている。
        // なので Java は、両方の方法を選ぶ事が出来るので、
        // 選択肢が多いので、それが理解出来る人には有用だと思う。
        // 理解できなければ、混乱の元になるけど。
    }

    public static void share_var(){
        separator();

        String[] var = {"a"};
        Runnable r1 = () -> { System.out.println(var[0]); };
        Runnable r2 = () -> { var[0] = "b"; };
        r1.run();
        r2.run();
        r1.run();
    }

    public static void main(String... args){
        define_lambda_type();
        substitution();
        scope1();
        scope2();
        share_var();
    }
}
