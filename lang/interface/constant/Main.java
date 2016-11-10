interface I {
    int i = 10;                 // final
    String s = "abc";           // final
}

class Main{
    static public void main(String... args){
        // I.i++;        // compile error
        // I.s = "zyz";  // compile error
        System.out.println(I.i);
        System.out.println(I.s);
    }
}
