import java.util.*;

class Main{
    static public void main(String... args){
        // こういうのは、もちろん問題ない
        CharSequence x = "a";
        CharSequence y = new StringBuilder();

        // でも以下はダメ
        // List<CharSequence> c = new ArrayList<String>(); // コンパイルエラー

        // ? を使う必用がある
        List<? extends CharSequence> d = new ArrayList<String>();
        List<? extends CharSequence> e = new ArrayList<StringBuilder>();

        // これはコンパイルエラーになる
        // d.add(0, "abc");
        // e.add(0, "abc");

        // もちろんこれは問題ないけど
        List<String> f = new ArrayList<String>();
        f.add(0, "abc");


        System.out.println("Done");
    }
}
