// javap の結果を貼っている
class Main{
    static public int s_method(int a, int b){
        return 5;
    }
    //   public static int s_method(int, int);
    //     Code:
    //        0: iconst_5
    //        1: ireturn
    public int method(int a, int b){
        return 5;
    }
    //   public int method(int, int);
    //     Code:
    //        0: iconst_5
    //        1: ireturn


    // 以下2つ比較すると、aload_0 が this を渡している部分だと思うけど
    // 普通に考えると、これがない staticメソッド の方が速いかと思う
    // JITとかされてどうなるか分からないけど
    static public int invoke_s_method(){
        return s_method(3,8);
    }
    //   public static int invoke_s_method();
    //     Code:
    //        0: iconst_3
    //        1: bipush        8
    //        3: invokestatic  #2                  // Method s_method:(II)I
    //        6: ireturn
    static public int invoke_method(Main m){
        return m.method(3,8);
    }
    // public static int invoke_method(Main);
    //   Code:
    //      0: aload_0
    //      1: iconst_3
    //      2: bipush        8
    //      4: invokevirtual #3                  // Method method:(II)I
    //      7: ireturn


    static public void main(String... args){
        invoke_s_method();
        // new の部分を invoke_method に入れると不公平かもしれないので外でやっておく
        invoke_method(new Main());
    }
    //   public static void main(java.lang.String...);
    //     Code:
    //        0: invokestatic  #6                  // Method invoke_s_method:()I
    //        3: pop
    //        4: invokestatic  #7                  // Method invoke_method:()I
    //        7: pop
    //        8: return


    // 書いてないけどコンストラクタも自動で出来る
    // Main();
    //        0: aload_0
    //        1: invokespecial #1                  // Method java/lang/Object."<init>":()V
    //        4: return
}
