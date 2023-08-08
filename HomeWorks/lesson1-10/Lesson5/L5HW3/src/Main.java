import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите длину стороны треугольника a:");
        String storonaA= br.readLine();
        double a = Double.parseDouble(storonaA);

        System.out.println("Введите длину стороны треугольника b:");
        String storonaB = br.readLine();
        double b = Double.parseDouble(storonaB);

        System.out.println("Введите длину стороны треугольника c:");
        String storonaC = br.readLine();
        double c = Double.parseDouble(storonaC);

        double p = (a + b +c) / 2;
        double s = Math.sqrt(p * (p -a) * (p - b) * (p - c));
        System.out.println("Площадь треугольника по формуле Герона = " + s);

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}