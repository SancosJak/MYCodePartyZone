import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите значение градусов по Фаренгейту:");
        String farangeint = br.readLine();
        double f = Double.parseDouble(farangeint);

        double celsij = 5 * (f - 32) / 9;
        System.out.println("Значение градусов по Цельсию = " + celsij);

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}