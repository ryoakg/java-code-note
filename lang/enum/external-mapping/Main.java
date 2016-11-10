import java.util.EnumMap;

enum DayOfWeek{
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
}

public class Main{
    // enumの中に入れないで、外付けで写像を作る
    //
    // 作りたい写像が、設計上必須ならコンストラクタに
    // 対応する値の情報を渡す様にした方がシンプル
    // 設計が変わるかもしれないなら、別の Class とかに情報を持たせた方が
    // オプショナルな感じになっていいと思う
    private static final EnumMap<DayOfWeek, String> jpTranslate;

    static{
        jpTranslate = new EnumMap<DayOfWeek, String>(DayOfWeek.class);
        jpTranslate.put(DayOfWeek.SUNDAY,   "日");
        jpTranslate.put(DayOfWeek.MONDAY,   "月");
        jpTranslate.put(DayOfWeek.TUESDAY,  "火");
        jpTranslate.put(DayOfWeek.WEDNESDAY,"水");
        jpTranslate.put(DayOfWeek.THURSDAY, "木");
        jpTranslate.put(DayOfWeek.FRIDAY,   "金");
        jpTranslate.put(DayOfWeek.SATURDAY, "土");
    }

    public static void main(String... args){
        for (DayOfWeek d : DayOfWeek.values())
            System.out.println(d + " → " + jpTranslate.get(d));
    }
}
