import java.util.EnumSet;
import static java.lang.System.out;

enum DayOfWeek{
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    // このコードも 外にもっていいくか、enum の中い置くかは検討の余地がある
    // ライブラリの中のコードとか、あるけど使わないかもしれないなら
    // 外にもっていった方がいいかもしれない
    //
    // ここで使っている 曜日の例だと
    // 何曜日が休日かはロケールとかで違うかもしれない
    // そうなると final とかしない方がいいかもしれない
    //
    // あと、どういう場合にしても static メソッドの方がいいかと思う
    // コードを移動することになった場合、コピペで済むし
    // 使っている側も import の書換えで済むと思う
    // 型チェックがあるので、危険な書換えは起らない気もするけど
    private static final EnumSet<DayOfWeek> dayoff = EnumSet.of(SUNDAY, SATURDAY);
    public static boolean isDayOff(DayOfWeek d){
        return dayoff.contains(d);
    }
    public static boolean isWeekday(DayOfWeek d){
        return ! dayoff.contains(d);
    }

    // 面倒なので main を中に入れている
    public static void main(String... args){
        for (DayOfWeek d : DayOfWeek.values())
            out.println(d + " is" + (isWeekday(d) ? "" : " NOT") + " a weekday.");

        out.println("\n///////////////////\n");

        for (DayOfWeek d : DayOfWeek.values())
            out.println(d + " is" + (isDayOff(d) ? "" : " NOT") + " day off.");
    }
}
