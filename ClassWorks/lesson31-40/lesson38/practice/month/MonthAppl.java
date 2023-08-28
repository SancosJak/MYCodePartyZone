package practice.month;

public class MonthAppl {
    public static void main(String[] args) {
        Month month = Month.DEC;
        System.out.println(month);
        System.out.println(month.plusMonth(3));
        System.out.println(month.plusMonth(13));

        System.out.println();

        System.out.println(Month.monthName(7));
        System.out.println(Month.monthName(14));

        System.out.println();

        Month month1 = Month.AUG;
        System.out.println(month1.getDays());
        System.out.println(Month.AUG.getDays());

    }
}
