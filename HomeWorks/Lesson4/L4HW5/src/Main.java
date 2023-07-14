import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Введите стоимость 1-го товара:");
        String tovarA = br.readLine();
        double priceA = Double.parseDouble(tovarA);

        System.out.println("Введите приобретенное количество 1-го товара:");
        String qtyA = br.readLine();
        int n1 = Integer.parseInt(qtyA);

        System.out.println("Введите скидку для 1-го товара:");
        String discA = br.readLine();
        double discountA = Double.parseDouble(discA);

        System.out.println("Введите стоимость 2-го товара:");
        String tovarB = br.readLine();
        double priceB = Double.parseDouble(tovarB);

        System.out.println("Введите приобретенное количество 2-го товара:");
        String qtyB = br.readLine();
        int n2 = Integer.parseInt(qtyB);

        System.out.println("Введите скидку для 2-го товара:");
        String discB = br.readLine();
        double discountB = Double.parseDouble(discB);

        double priceDiscountA = (priceA * n1) - (priceA * n1 * discountA / 100);
        double priceDiscountB = (priceB * n2) - (priceB * n2 * discountB / 100);
        double totalSumma = priceDiscountA + priceDiscountB;


        System.out.println("Cтоимость Ваших товаров A со скидкой " + discountA + " %  = " + priceDiscountA);
        System.out.println("Cтоимость Ваших товаров B со скидкой " + discountB + " %  = " + priceDiscountB);
        System.out.println("Итоговая стоимость покупки " + totalSumma);

        System.out.println("HomeWork by Sandor Ivanyo");
    }
}