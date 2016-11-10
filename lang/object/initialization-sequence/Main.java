import java.util.*;

public class Main{
    static class C1{
        {
            System.out.println("init block 1");
        }
        C1(){
            System.out.println("constructor");
        }
        {
            System.out.println("init block 2");
        }
    }

    public static void main(String... args){
        new C1();
    }
}
