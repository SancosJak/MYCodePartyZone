import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите значение в радианах:");
        String r = br.readLine();
        double rad = Double.parseDouble(r);
        //int radian = Integer.parseInt(r);

        //double rad = radian;

        System.out.format("%.1f радиан = %.3f градусов %n", rad, Math.toDegrees(rad));
        System.out.println("HomeWork by Sandor Ivanyo");
    }
}