import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите длину 1-го катета:");
        String katet1 = br.readLine();
        double katetA = Double.parseDouble(katet1);

        System.out.println("Введите длину 2-го катета:");
        String katet2 = br.readLine();
        double katetB = Double.parseDouble(katet2);

        double hypotenuza = Math.sqrt(katetA * katetA + katetB * katetB) ;
        System.out.println("Длина гипотенузы = " + hypotenuza);

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}