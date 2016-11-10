interface I {
    default void f(){
        System.out.println("I::f called.");
    }

    class C1 implements I {
    }

    class C2 implements I {
        @Override
        public void f(){
            System.out.println("C2::f called.");
        }
    }
}

class Main{
    public static void main(String... args){
        I.C1 o1 = new I.C1();
        o1.f();

        I.C2 o2 = new I.C2();
        o2.f();
    }
}
