import java.util.Arrays;
/*
Собрать в массив данные о дневной температуре в вашем городе да прошедшую неделю.
Выведите на печать температуру, которая была во вторник и затем в четверг.
Найти среднюю температуру за прошлую неделю.
 */
public class Main {
    public static void main(String[] args) {
        int[] weekTemp = {24, 26, 27, 29, 31, 30, 28}; // https://www.gismeteo.ru/weather-bottrop-2476/10-days/

        double averageTemp = 0;
        double sum = 0;

        for (int i = 0; i < weekTemp.length; i++) {
            sum += weekTemp[i];
        }
        averageTemp = sum/ weekTemp.length; // weekTemp.length = 7

        System.out.println("Last week's average temperature from Monday to Sunday");
        System.out.println(Arrays.toString(weekTemp));
        System.out.println("The temperature that was on Tuesday = " + weekTemp[1]);
        System.out.println("The temperature that was on Thursday = " + weekTemp[3]);
        System.out.println("Last week's average temperature = " + averageTemp);
    }
}