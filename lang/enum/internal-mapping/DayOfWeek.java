import java.util.EnumMap;

enum DayOfWeek{
    SUNDAY   ("日"),
    MONDAY   ("月"),
    TUESDAY  ("火"),
    WEDNESDAY("水"),
    THURSDAY ("木"),
    FRIDAY   ("金"),
    SATURDAY ("土");

    final String jp;
    DayOfWeek(String jp){
        this.jp = jp;
    }

    public static void main(String... args){
        for (DayOfWeek d : DayOfWeek.values())
            System.out.println(d + " → " + d.jp);
    }
}
