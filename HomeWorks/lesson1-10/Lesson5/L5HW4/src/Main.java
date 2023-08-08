import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите значения коэффициента a:");
        String koefA= br.readLine();
        double a = Double.parseDouble(koefA);

        System.out.println("Введите значения коэффициента b:");
        String koefB= br.readLine();
        double b = Double.parseDouble(koefB);

        System.out.println("Введите значения коэффициента c:");
        String koefC= br.readLine();
        double c = Double.parseDouble(koefC);

        double d = Math.pow(b,2) - 4 * a * c; // дискриминант

        if (d > 0) {
            double x1 = (-b + Math.sqrt(d)) / (2 * a);
            double x2 = (-b - Math.sqrt(d)) / (2 * a);
            System.out.println("Корни уравнения: x1 = " + x1 + " , x2 = " + x2);
        } else if (d == 0) {
            double x;
            x = -b / (2 * a);
            System.out.println("Данное квадратное уравнение имеет единственный корень: x = " + x);
        } else { // d < 0
            System.out.println("Данное квадратное уравнение не имеет корней");
        }

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}