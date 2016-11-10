interface I1{
    void f();
}
interface I2{
    void g();
}

interface I extends I1, I2 {}

class C implements I{
    @Override
    public void f(){
        System.out.println("f() is called.");
    }
    @Override
    public void g(){
        System.out.println("g() is called.");
    }
}

class Main{
    public static void main(String... args){
        C o = new C();
        o.f();
        o.g();
    }
}
