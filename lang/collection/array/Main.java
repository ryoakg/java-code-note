// in progress
public class Main {
    public static void title(){
        StackTraceElement[] ss = Thread.currentThread().getStackTrace();
        System.out.printf("///////// %s ////////\n", ss[2].getMethodName());
    }

    public static void f1(){
        title();
        int a1[] = {1,2};

        System.out.printf("a1[0]:%d, a1[1]:%d\n", a1[0], a1[1]);

        a1[0] = a1[1];
        System.out.printf("a1[0]:%d, a1[1]:%d\n", a1[0], a1[1]);

        a1[1]++;
        System.out.printf("a1[0]:%d, a1[1]:%d\n", a1[0], a1[1]);
    }

    public static void Integer(){
        title();
        Integer a1[] = {1,2};

        System.out.printf("a1[0]:%d, a1[1]:%d\n", a1[0], a1[1]);

        a1[0] = a1[1];
        System.out.printf("a1[0]:%d, a1[1]:%d\n", a1[0], a1[1]);

        a1[1]++;
        System.out.printf("a1[0]:%d, a1[1]:%d\n", a1[0], a1[1]);
    }

    public static void f3(){
        title();
        String a1[] = {"a","b"};

        System.out.printf("a1[0]:%s, a1[1]:%s\n", a1[0], a1[1]);

        a1[0] = a1[1];
        System.out.printf("a1[0]:%s, a1[1]:%s\n", a1[0], a1[1]);

        a1[1].toUpperCase();
        System.out.printf("a1[0]:%s, a1[1]:%s\n", a1[0], a1[1]);
    }

    public static void dimension(){
        title();
        String a1[] = {"a","b","c"};
        String a2[][] = {{"a","b","c"},{"A","B","C"}};
        String a3[][] = {{"a","b","c","d","e"},{"A","B","C"},{"1"}};

        // compile error
        // a1 = {"a","b","c"};
        // a2 = {{"a","b","c"},{"a","b","c"}};

        System.out.println("a2:"+a2);
        System.out.println("a3:"+a3);
        a2 = a3;
        System.out.println("a2:"+a2);
        System.out.println("a3:"+a3);

        System.out.println(a2[2][0]);      // 1

        a3[1] = a3[0];
    }
    public static void main(String... args){
        // f1();
        // Integer();
        // f3();
        // dimension();
        Integer a = new Integer(0);
        Integer b = a;
        a++;
        System.out.println(a + " " + b);
    }
}
