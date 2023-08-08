import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите сторону треугольника А:");
        String storonaA = br.readLine();
        double a = Double.parseDouble(storonaA);

        System.out.println("Введите сторону треугольника B:");
        String storonaB = br.readLine();
        double b = Double.parseDouble(storonaB);

        System.out.println("Введите сторону треугольника C:");
        String storonaC = br.readLine();
        double c = Double.parseDouble(storonaC);

        if ((a < b + c) && (b < a + c) && (c < a + b))
            System.out.println("Треугольник cуществует");
        else
            System.out.println("Треугольник не существует");

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}