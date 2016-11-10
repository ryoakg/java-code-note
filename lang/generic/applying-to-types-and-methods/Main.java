// see also: https://docs.oracle.com/javase/tutorial/java/generics/methods.html

// これは、型(class)に対して型パラメタを使っているのではない
// 下3つの各メソッドそれぞれに型パラメタを使っている
class C1 {
    // 戻り値の型を固定
    static <T> boolean f1(T a, T b){
        return a.equals(b);
    }

    // 戻り値の型もパラメタ化
    static <T> T f2(T a, T b){
        return a;
    }

    // パラメタ化した型のジェネリック型を戻り値にする
    static <T> java.util.List<T> f3(T a, T b){
        return java.util.Arrays.asList(a,b);
    }
}

// これは generic型
// T がなければ、上と同じだけど
// こっちのメソッドはコンパイルエラーになる
//
// C1 の方法で同じ事が出来るので、問題はないけど
// コンパイルできない理由はあるのか?
//
// static メソッドは、class が表す型と関係がないから
// こういう書き方が出来た方が不自然という事?
// そもそも、staticメソッドを含め
// 全てを class に入れないとダメっていう
// Java の考えが変だとは思うけど
class C2<T> {
    // // 戻り値の型を固定
    // static boolean f1(T a, T b){
    //     return a.equals(b);
    // }

    // // 戻り値の型もパラメタ化
    // static T f2(T a, T b){
    //     return a;
    // }

    // // パラメタ化した型のジェネリック型を戻り値にする
    // static java.util.List<T> f3(T a, T b){
    //     return java.util.Arrays.asList(a,b);
    // }
}


// C2の各メソッドの static を除いたもの
// これはコンパイルできる
class C3<T> {
    // 戻り値の型を固定
    boolean f1(T a, T b){
        return a.equals(b);
    }

    // 戻り値の型もパラメタ化
    T f2(T a, T b){
        return a;
    }

    // パラメタ化した型のジェネリック型を戻り値にする
    java.util.List<T> f3(T a, T b){
        return java.util.Arrays.asList(a,b);
    }
}

// C1 の 各メソッドを static じゃなくしたもの
class C4 {
    // 戻り値の型を固定
    public <T> boolean f1(T a, T b){
        return a.equals(b);
    }

    // 戻り値の型もパラメタ化
    public <T> T f2(T a, T b){
        return a;
    }

    // パラメタ化した型のジェネリック型を戻り値にする
    public <T> java.util.List<T> f3(T a, T b){
        return java.util.Arrays.asList(a,b);
    }
}

class Main{
    static public void main(String... args){
        // 冗長な書き方
        C1.<Integer>f1(1,2);
        C1.<Character>f1('1','2');
        C1.<String>f1("1","2");

        // 以下普通の書き方
        System.out.println(C1.f1(1,2));
        System.out.println(C1.f1('1','2'));
        System.out.println(C1.f1("1","2"));

        int a = C1.f2(1,2);
        System.out.println(C1.f2(1,2));
        System.out.println(C1.f2('1','2'));
        System.out.println(C1.f2("1","2"));

        java.util.List<Integer> xs = C1.f3(1,2);
        System.out.println(C1.f3(1,2));
        System.out.println(C1.f3('1','2'));
        System.out.println(C1.f3("1","2"));

        System.out.println("");

        C3 x = new C3();
        System.out.println(x.f1(1,2));
        System.out.println(x.f1('1','2'));
        System.out.println(x.f1("1","2"));

        System.out.println(x.f2(1,2));
        System.out.println(x.f2('1','2'));
        System.out.println(x.f2("1","2"));

        System.out.println(x.f3(1,2));
        System.out.println(x.f3('1','2'));
        System.out.println(x.f3("1","2"));

        System.out.println("");

        C4 y = new C4();
        System.out.println(y.f1(1,2));
        System.out.println(y.f1('1','2'));
        System.out.println(y.f1("1","2"));

        System.out.println(y.f2(1,2));
        System.out.println(y.f2('1','2'));
        System.out.println(y.f2("1","2"));

        System.out.println(y.f3(1,2));
        System.out.println(y.f3('1','2'));
        System.out.println(y.f3("1","2"));
    }
}
