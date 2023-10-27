package code;

/**
 * Задача о рюкзаке — это задача комбинаторной оптимизации. Суть её заключается в следующем: дан рюкзак определённой
 * грузоподъёмности W и набор предметов. Каждый предмет имеет свою массу w  и стоимость v. Необходимо
 * выбрать такое подмножество этих предметов, чтобы их суммарная масса не превышала W, а суммарная стоимость была
 * максимально возможной.
 */
public class Knapsack {
    public static void main(String[] args) {
        int W = 50; // Максимальная грузоподъёмность рюкзака
        int n = 3; // Количество предметов
        int[] w = {10, 20, 30}; // Веса предметов
        int[] v = {60, 100, 120}; // Стоимости предметов

        int maxVal = knapSack(W, w, v, n);
        System.out.println("Максимальная стоимость: " + maxVal);
    }

    public static int knapSack(int W, int[] w, int[] v, int n) {
        int[][] dp = new int[n + 1][W + 1];

        // Заполняем массив dp снизу вверх
        for (int i = 0; i <= n; i++) {
            for (int weight = 0; weight <= W; weight++) {
                if (i == 0 || weight == 0) {
                    dp[i][weight] = 0;
                } else if (w[i - 1] <= weight) {
                    dp[i][weight] = Math.max(v[i - 1] + dp[i - 1][weight - w[i - 1]], dp[i - 1][weight]);
                } else {
                    dp[i][weight] = dp[i - 1][weight];
                }
            }
        }

        return dp[n][W];
    }
}