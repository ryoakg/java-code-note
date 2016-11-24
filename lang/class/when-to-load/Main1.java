// 以下で Classのロードのタイミングが分かる
//  java -verbose:class Main
public class Main1{
    static public void main(String... args){
        System.out.println("Start Main#main");

        // java.lang.Class を参照しただけでは、ロードされないみたい
        // static initializer が実行されないので
        System.out.println(Client.class);

        // このタイミングで、ロードされたみたい
        Client.s_method();

        // 当然、これ以降はロードされない
        Client.s_method();
        Client c = new Client();
        c.method();

        System.out.println("End Main#main");
    }

    // System.out.println(Foo.class);
    // とか適当なクラス名を参照しようとすると、
    // コンパイラが
    //   エラー: シンボルを見つけられません
    // と出す
    // どういうクラスがあるかは、ファイルシステムにしかないハズで
    // 実行時に見付からないなら分かる気がするけど
    //
    // 多分実行時にもエラーが出るハズ
    // と思って Client.class を消して実行すると
    // 思ったのと違った!!
    //
    // なんと Client.java だけで実行可能だった.
    // 実行後に Client.class が出来ていたので
    // 実行時に javac でコンパイルしているらしい.
    // この辺りは、ClassLoader 次第なのかな?
    // とにかく以外な結果だった
}
