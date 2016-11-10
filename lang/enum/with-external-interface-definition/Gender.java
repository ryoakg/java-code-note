// DBとか外部向けのIFが必用な場合
// この場合外部向けなので、
// 不用意に値を変えてはいけない
//
// これみたいに enum と対応する文字列とか数値が欲しい場合
// enum の外で java.util.EnumMap に対応を持たせる事もできる
//
// でも多分、コンストラクタに対応する値を渡した方が速いと思う
// コンパイルとかリンク時にアドレス判明すると思うから
// EnumMap 使うと、データ構造が追加される事を前提にすると思うので
// データのアドレスを固定できないと思う
//
// あと、コンストラクタを普通に作っていれば
// 対応する値を入れ忘れる事がないのがいい
// EnumMap の put だと、コンパイラは人間がわざと入れてないのと区別がつかない
enum Gender{
    MAN("Man",0),
    WOMAN("Woman",1),
    OTHER("Other",2);

    private final String nameForDisp;
    private final int valueForDb;

    Gender(String nameForDisp, int valueForDb){
        this.nameForDisp = nameForDisp;
        this.valueForDb = valueForDb;
    }

    public String toString(){
        return this.nameForDisp;
    }
    public int toDatabaseValue(){
        return this.valueForDb;
    }

    // 面倒なので main を中に入れている
    public static void main(String... args){
        System.out.println(MAN);
        System.out.println(MAN.toDatabaseValue());
    }
}
