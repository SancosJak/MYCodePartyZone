/*
Заполнить двухмерный массив 8 х 8 элементами 0 и 1, как на шахматной достке.
1 - черное поле, 0 - белое поле Вывести массив на печать.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Сhess board 8*8: 1 - black field, 0 - white field");
        int[][] board = new int[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((i + j) % 2 == 0) {
                    board[i][j] = 1;
                } else {
                    board[i][j] = 0;
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}