import java.util.*;

public class Main {
    public static void main(String[]arg) {
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите значение угла треугольника 1: ");
        double angle1 = scan.nextDouble();

        System.out.println("Введите значение угла треугольника 2: ");
        double angle2 = scan.nextDouble();

        System.out.println("Введите значение угла треугольника 3: ");
        double angle3 = scan.nextDouble();

        double summa = angle1 + angle2 + angle3;

        if ((summa > 180) || (summa <= 0) || (angle1 <= 0) || (angle2 <= 0) || (angle3 <= 0))
            System.out.println("Треугольника не существует. Рекомендация: вводимые углы не больше 90 градусов");
        else {
            if ((angle1 == 90) || (angle2 == 90) || (angle3 == 90))
                System.out.println("Треугольник прямоугольный");
            else {
                if ((angle1 < 90) && (angle2 < 90) && (angle3 < 90))
                    System.out.println("Треугольник остроугольный");
                else{
                    if ((summa < 180) && ((angle1 > 90) & (angle1 < 180)) || ((angle2 > 90) & (angle2 < 180)) || ((angle3 > 90) & (angle3 < 180)))
                        System.out.println("Треугольник тупооугольный.");
                }
            }

        }
    }
}