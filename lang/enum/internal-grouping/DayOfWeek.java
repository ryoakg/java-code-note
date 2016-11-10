import java.util.EnumSet;
import static java.lang.System.out;

enum DayOfWeek{
    SUNDAY(false),
    MONDAY(true),
    TUESDAY(true),
    WEDNESDAY(true),
    THURSDAY(true),
    FRIDAY(true),
    SATURDAY(false);

    final boolean is_day_off;
    DayOfWeek(boolean is_day_off){
        this.is_day_off = is_day_off;
    }

    // 面倒なので main を中に入れている
    public static void main(String... args){
        for (DayOfWeek d : DayOfWeek.values())
            out.println(d + " is" + (d.is_day_off ? "" : " NOT") + " a weekday.");

        out.println("\n///////////////////\n");

        for (DayOfWeek d : DayOfWeek.values())
            out.println(d + " is" + (d.is_day_off ? "" : " NOT") + " day off.");
    }
}
