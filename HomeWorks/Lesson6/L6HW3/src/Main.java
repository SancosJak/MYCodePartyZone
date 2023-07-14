import java.util.Scanner;
public class Main{
    public static double getArea( double r) {
        return Math.PI * r * r;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Введите длину радиуса окружности:");
        double r = in.nextDouble();
        //double area = Math.PI * Math.pow(r,2);
        System.out.println("Площадь круга " + getArea(r));
        System.out.println("HomeWork by Sandor Ivanyo");
    }

}