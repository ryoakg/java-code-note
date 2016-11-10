// 以下3つの interface に対して、ある程度広い範囲で共通の実装が使えるとする
// その関係をなるべくシンプルにするには?
interface I1 {
    void f();
}
interface I2 {
    void g();
}
interface I3 {
    void h();
}


// 共通実装を提供する、中間の interface を使う方法
// - mix-in みたいな事が出来ていい
// - メソッドに final はつけられないのがよくない
interface CommonImplementationI1 extends I1,I2 {
    @Override                   //  final はつけられない
    default void f(){
        System.out.println("CommonImplementationI1::f() is called.");
    }

    @Override                   //  final はつけられない
    default void g(){
        System.out.println("CommonImplementationI1::g() is called.");
    }
}
interface CommonImplementationI2 extends I3 {
    @Override                   //  final はつけられない
    default void h(){
        System.out.println("CommonImplementationI2::h() is called.");
    }
}


// 共通実装を提供する、中間の class を使う方法
// - abstract を使えば interface と同様に、中間のclassのインスタンス化も防げる
// - メソッドに final が使える
//   この点は abstract の意味が無いけど
// - これで mix-in みたいな事をやろうとすると、段階的に何度も extend する必用がある
abstract class CommonImplementationC implements I1,I2 {
    @Override
    final public void f(){
        System.out.println("CommonImplementationC::f() is called.");
    }

    @Override
    final public void g(){
        System.out.println("CommonImplementationC::g() is called.");
    }
}
// ↓ I1,I2,I3 に上下関係はないのに、この構造だと上下関係がある様に見えてしまうのがキモい
// メンテがやり難くなる可能性もある
abstract class CommonImplementationC2 extends CommonImplementationC implements I3 {
    @Override
    final public void h(){
        System.out.println("CommonImplementationC2::h() is called.");
    }
}


// 以下3つは、一番具体的なクラス
class C1 implements CommonImplementationI1 {
    // 上に書いてきたインターフェースにはない、C1 独自の機能
    void x(){
        System.out.println("C1::x() is called.");
    }
}

// CommonImplementationI1, CommonImplementationI2 を mix-in みたいな事をやっている
class C2 implements CommonImplementationI1, CommonImplementationI2 {
    // 上に書いてきたインターフェースにはない、C2 独自の機能
    void y(){
        System.out.println("C2::y() is called.");
    }
}

// こっちの場合は、CommonImplementationC で mix-in が完結する形になる
// mix-in したもの通しを、更に mix-in とか出来ない
class C3 extends CommonImplementationC2 {
    // 上に書いてきたインターフェースにはない、C3 独自の機能
    void z(){
        System.out.println("C3::z() is called.");
    }
}


class Main{
    public static void main(String... args){
        I1 a1[] = {new C1(), new C2(), new C3()};
        for(I1 x : a1)
            x.f();
        System.out.println("");

        I2 a2[] = {new C1(), new C2(), new C3()};
        for(I2 x : a2)
            x.g();
        System.out.println("");

        I3 a3[] = {new C2(), new C3()};
        for(I3 x : a3)
            x.h();
    }
}
