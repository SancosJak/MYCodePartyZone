import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double priceA = 1000;
        double priceB = 500;
        double procent = 10;

        double absoluteDiscount = ((priceA + priceB) * procent) / 100;
        double discountPrice = (priceA + priceB) - absoluteDiscount;

        System.out.println("Cтоимость Ваших товоров со скидкой " + procent + " %  = " + discountPrice);
        System.out.println("Абсолютная величина скидки для этой покупки составляет "  + absoluteDiscount);
        System.out.println("HomeWork by Sandor Ivanyo");
    }
}