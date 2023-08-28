import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Comparator;
/*
Задача 1. В классе DateOperation (см. package for_hw) реализовать метод getAge,
принимающий дату рождения в виде String, и возвращающий возраст в годах.

Задача 2. В классе DateOperation (см. package for_hw), реализовать метод sortStringDates,
принимающий массив дат в виде массива данных типа String, и возвращающий отсортированный массив дат.
Для проверки используйте класс DateOperationTest с Unit-тестами.
 */
public class DateOperation {

    public static int getAge(String birthDate) {
        LocalDate birthLocalDate;
        DateTimeFormatter formatter;

        if (birthDate.contains("/")) {
            formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            birthLocalDate = LocalDate.parse(birthDate, formatter);
        } else {
            formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            birthLocalDate = LocalDate.parse(birthDate, formatter);
        }

        LocalDate currentDate = LocalDate.now();
        Period period = Period.between(birthLocalDate, currentDate);
        return period.getYears();
    }
    public static String[] sortStringDates(String[] dates) {
        DateTimeFormatter formatterWithSlashes = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatterWithDashes = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        for (int i = 0; i < dates.length; i++) {
            dates[i] = dates[i].trim();
        }

        Arrays.sort(dates, Comparator.comparing(date -> {
            LocalDate localDate;
            if (date.contains("/")) {
                localDate = LocalDate.parse(date.trim(), formatterWithSlashes);
            } else {
                localDate = LocalDate.parse(date.trim(), formatterWithDashes);
            }
            return localDate;
        }));

        return dates;
    }



}
