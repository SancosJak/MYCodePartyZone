import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите длину прямоугольника:");
        String lengthRec = br.readLine();
        int lengthR = Integer.parseInt(lengthRec);

        System.out.println("Введите ширину прямоугольника:");
        String wigthRec = br.readLine();
        int wigthR = Integer.parseInt(wigthRec);

        int perimetr = 2*(lengthR + wigthR);
        int area = lengthR * wigthR;

        System.out.println("Периметр прямоугольника = " + perimetr);
        System.out.println("Площадь прямоугольника = " + area);
        System.out.println("HomeWork by Sandor Ivanyo");
    }
}