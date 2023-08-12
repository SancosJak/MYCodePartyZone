import java.time.LocalDate;
import java.time.Month;
import java.time.Year;

enum Season {
    WINTER,
    SPRING,
    SUMMER,
    AUTUMN
}

public class MainEnum {
    public static void main(String[] args) {
        String inputMonth = "июль"; // Замените на нужный вам месяц, например, "январь", "февраль" и т.д.

        // Преобразование русского названия месяца в объект Month
        Month month = getMonthByRussianName(inputMonth);

        int currentYear = LocalDate.now().getYear();
        int daysInMonth = month.length(Year.isLeap(currentYear));

        Season season = getSeason(month);

        System.out.println("В " + inputMonth + " " + currentYear + " года " + daysInMonth + " дней.");
        System.out.println("Этот месяц относится к времени года: " + season);
    }

    public static Month getMonthByRussianName(String russianMonth) {
        String russianMonthUpper = russianMonth.toUpperCase();
        switch (russianMonthUpper) {
            case "ЯНВАРЬ":
                return Month.JANUARY;
            case "ФЕВРАЛЬ":
                return Month.FEBRUARY;
            case "МАРТ":
                return Month.MARCH;
            case "АПРЕЛЬ":
                return Month.APRIL;
            case "МАЙ":
                return Month.MAY;
            case "ИЮНЬ":
                return Month.JUNE;
            case "ИЮЛЬ":
                return Month.JULY;
            case "АВГУСТ":
                return Month.AUGUST;
            case "СЕНТЯБРЬ":
                return Month.SEPTEMBER;
            case "ОКТЯБРЬ":
                return Month.OCTOBER;
            case "НОЯБРЬ":
                return Month.NOVEMBER;
            case "ДЕКАБРЬ":
                return Month.DECEMBER;
            default:
                throw new IllegalArgumentException("Неверное русское название месяца: " + russianMonth);
        }
    }

    public static Season getSeason(Month month) {
        switch (month) {
            case DECEMBER:
            case JANUARY:
            case FEBRUARY:
                return Season.WINTER;
            case MARCH:
            case APRIL:
            case MAY:
                return Season.SPRING;
            case JUNE:
            case JULY:
            case AUGUST:
                return Season.SUMMER;
            case SEPTEMBER:
            case OCTOBER:
            case NOVEMBER:
                return Season.AUTUMN;
            default:
                throw new IllegalArgumentException("Неверный месяц: " + month);
        }
    }
}
