import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
/*
На столе лежат n монеток. Некоторые из них лежат вверх решкой, а некоторые – гербом.
Определите минимальное число монеток, которые нужно перевернуть, чтобы все монетки
были повернуты вверх одной и той же стороной.
 */
public class Main {
    public static int minFlips(int[] coins) {
        int countGerb = 0;
        int countReska = 0;

        for (int coin : coins) {
            if (coin == 0) {
                countGerb++;
            } else {
                countReska++;
            }
        }

        return Math.min(countGerb, countReska);
    }
    public static int[] generateCoins(int n) {
        int[] coins = new int[n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            coins[i] = random.nextInt(2);
        }

        return coins;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of coins (n): ");
        int n = scanner.nextInt();

        int[] coins = generateCoins(n);
        System.out.println("An array of coins: " + Arrays.toString(coins));

        int minFlips = minFlips(coins);
        System.out.println("Minimum number of flips: " + minFlips);
    }

}
