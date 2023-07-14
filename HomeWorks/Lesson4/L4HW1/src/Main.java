import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите значение стороны квадрата:");
        String a = br.readLine();
        int aSquare = Integer.parseInt(a);

        int s = aSquare * aSquare;
        int v = aSquare * aSquare * aSquare;

        System.out.println("Площадь квадрата = " + s);
        System.out.println("Объем куба = " + v);
        System.out.println("HomeWork by Sandor Ivanyo");
    }
}