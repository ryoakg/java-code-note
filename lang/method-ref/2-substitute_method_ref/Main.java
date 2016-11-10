import java.util.*;

public class Main{
    @FunctionalInterface
    interface Creator<E> {
        public E createInSAM(int capacity);
    }

    @FunctionalInterface
    interface Appender {
        public StringBuilder appendInSAM(String str);
    }

    @FunctionalInterface
    interface Appender2 {
        public void appendInSAM2(StringBuilder sb, String s);
    }

    public static void main(String... args){
        Creator<StringBuilder> creator = StringBuilder::new;
        StringBuilder sb = creator.createInSAM(8);

        // instance method
        Appender appender = sb::append;
        appender.appendInSAM("abc");

        // static method
        Appender2 appender2 = StringBuilder::append;
        appender2.appendInSAM2(sb, "def");

        System.out.print(sb);
    }
}
