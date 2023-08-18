package timeAppl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

public class TimeAppl {
    public static void main(String[] args) {

//Работа с датами:
//
//узнать текущую дату и время
//есть дата, какой это был день недели? день месяца? день года?
//есть дата, как узнать, это было раньше? или позже?
//Путешествие во времени
//
//в будущее currentDay.plus
//в прошлое currentDay.minus
//использование ChronoUnit
//Получение интервала времени
//
//Сортировка массива по времени
//
//Date Formatter
//
//Парсинг даты из строки
        LocalDate currentDate = LocalDate.now();
        System.out.println(currentDate);

        LocalTime currentTime = LocalTime.now();
        System.out.println(currentTime);

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);

        LocalDate gagarin = LocalDate.of(1961,4,12);
        System.out.println(gagarin.getYear());
        System.out.println(gagarin.getDayOfYear());
        System.out.println(gagarin.getDayOfMonth());
        System.out.println(gagarin.getDayOfWeek());
        System.out.println(gagarin.getChronology());
        System.out.println(gagarin.isBefore(currentDate));
        System.out.println(gagarin.isAfter(currentDate));

        System.out.println("-----traveling in Time-----");
        //add days to current date
        LocalDate newDate = currentDate.plusDays(40);
        System.out.println(newDate);

        newDate = currentDate.plusWeeks(12);
        System.out.println(newDate);

        newDate = currentDate.minusMonths(12);
        System.out.println(newDate);

        System.out.println(localDateTime.plus(9, ChronoUnit.HALF_DAYS));
        System.out.println(localDateTime.plus(10, ChronoUnit.CENTURIES));

        // получения интервала времени
        LocalDate lenin = LocalDate.of(1870,4,22);
        long res = ChronoUnit.YEARS.between(gagarin, lenin);
        System.out.println(res);

        System.out.println(lenin.compareTo(gagarin));

        //Local dates sort
        LocalDate[] dates= {gagarin,currentDate,lenin};
        Arrays.sort(dates);
        System.out.println(Arrays.toString(dates));

        //date formatter
        DateTimeFormatter df = DateTimeFormatter.ISO_DATE;
        System.out.println(gagarin.format(df));

        df = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        System.out.println(gagarin.format(df));

        String date1 = "06/07/2023";
        String date2 = "2023-02-02";

        LocalDate localDate1 = dateParse(date1);
        System.out.println(localDate1);
        LocalDate localDate2 = dateParse(date2);
        System.out.println(localDate2);


    }
    private static LocalDate dateParse(String date) {
        DateTimeFormatter df = DateTimeFormatter.ofPattern("[dd/MM/yyyy][yyyy-MM-dd]");
        return LocalDate.parse(date, df);
//        if (date.contains("-")) {
//            return LocalDate.parse(date);
//        } else {
//            return LocalDate.parse(date, df);
//        }


    }
}
