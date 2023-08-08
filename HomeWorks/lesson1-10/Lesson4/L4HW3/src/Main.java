import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите температуру воздуха в понедельник:");
        String mondayTemp = br.readLine();
        double mt = Double.parseDouble(mondayTemp);

        System.out.println("Введите температуру воздуха вo вторник:");
        String tuesdayTemp = br.readLine();
        double tt = Double.parseDouble(tuesdayTemp);

        System.out.println("Введите температуру воздуха в среду:");
        String wednesdayTemp = br.readLine();
        double wt = Double.parseDouble(wednesdayTemp);

        System.out.println("Введите температуру воздуха в четверг:");
        String thursdayTemp = br.readLine();
        double tht = Double.parseDouble(thursdayTemp);

        System.out.println("Введите температуру воздуха в пятницу:");
        String fridayTemp = br.readLine();
        double ft = Double.parseDouble(fridayTemp);

        System.out.println("Введите температуру воздуха в субботу:");
        String saturdayTemp = br.readLine();
        double st = Double.parseDouble(saturdayTemp);

        System.out.println("Введите температуру воздуха в воскресенье:");
        String sundayTemp = br.readLine();
        double sut = Double.parseDouble(sundayTemp);

        double averageTemp = (mt + tt + wt + tht + ft + st + sut) / 7;
        System.out.println("Средняя температура за неделю в вашем городе " + averageTemp + " градусов");

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}