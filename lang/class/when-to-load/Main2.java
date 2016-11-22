// 以下で Classのロードのタイミングが分かる
//  java -verbose:class Main

// Main1と中身は大体同じ
public class Main2{
    static public void main(String... args){
        System.out.println("Start Main#main");

        // java.lang.Class を参照しただけでは、ロードされないみたい
        // static initializer が実行されないので
        System.out.println(Client.class);

        // このタイミングで、ロードされたみたい
        Client c = new Client();
        c.method();

        // 当然、これ以降はロードされない
        c = new Client();
        c.method();
        Client.s_method();

        System.out.println("End Main#main");
    }
}
