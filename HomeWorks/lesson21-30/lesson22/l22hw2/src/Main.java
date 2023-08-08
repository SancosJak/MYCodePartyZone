/*
(цикл) Одноклеточная амёба каждые 3 часа делится на 2 такие же амёбы.
Необходимо определить, сколько будет амёб через n часов, если первоначально была только одна амёба.
 */
import java.util.Scanner;

public class Main {
    public static long calculateAmoebas(int hours) {
        long ameba = 1; // Исходная амеба

        if (hours <= 0) {
            return ameba;
        } else {
            int cycles = hours / 3;
            for (int i = 0; i < cycles; i++) {
                ameba += ameba*2;
            }
            return ameba;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of hours (n): ");
        int hours = scanner.nextInt();

        System.out.println("Cycles by 3 hours: " + hours/3);

        long result = calculateAmoebas(hours);
        System.out.println("After " + hours + " hours, there will be " + result + " amoeba(s).");
    }
}