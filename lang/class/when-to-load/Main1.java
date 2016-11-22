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
}
