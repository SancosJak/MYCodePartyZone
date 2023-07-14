import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите длину радиуса окружности:");
        String radius= br.readLine();
        double r = Double.parseDouble(radius);

        double area = Math.PI * Math.pow(r,2);
        System.out.println("Площадь круга для введенного радиуса = " + area);

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}