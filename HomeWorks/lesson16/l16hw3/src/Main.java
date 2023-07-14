import java.util.Arrays;
/*
Сформируйте массив, который хранит названия дней недели при условии,
что первый рабочий день недели - это Понедельник, а последний - Воскресенье.
Переопределите этот массив так, чтобы первым рабочим днем недели стало Воскресенье,
а последним - Суббота.
 */

public class Main {
    public static void main(String[] args) {
        String[] weekDays = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday"};

        System.out.println("Original order of weekdays:");
        System.out.println(Arrays.toString(weekDays));
        System.out.println();
        String[] mwd= new String[weekDays.length]; //mwd - Modified Week Days
        System.arraycopy(weekDays, 6, mwd, 0, 1);
        System.arraycopy(weekDays, 0, mwd, 1, weekDays.length - 2);
        System.arraycopy(weekDays, 5, mwd, mwd.length - 1, 1);

        System.out.println("New order of weekdays:");
        System.out.println(Arrays.toString(mwd));
    }
}
