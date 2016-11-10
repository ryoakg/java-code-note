public class Main{
    @Deprecated
    public static void foo(){
        return ;
    }

    public static void main(String... args){
        // 以下2つは警告は出ない
        foo();
        Main.foo();

        Sub.foo();
    }
}
