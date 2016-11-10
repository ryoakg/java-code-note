@FunctionalInterface
interface F{
    void f();
}

interface BaseI{
    // the unique instance method
    default void method(){
        System.out.println("method in BaseI: " + this.getValue());
    }
    String getValue();

    // the unique static method
    static void smethod(){
        System.out.println("static method in BaseI");
    }
}

class Impl implements BaseI {
    @Override
    public String getValue(){
        return "value in Impl";
    }
}

public class Main {
    public static void main(String... args){
        F mref;

        BaseI bi = new Impl();
        // substitute the unique instance method
        mref = bi::method;
        mref.f();

        // substitute the unique static method
        mref = BaseI::smethod;
        mref.f();
    }
}
