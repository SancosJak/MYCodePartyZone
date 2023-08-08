import java.util.Scanner;
/*
(циклы и печать) Распечатать в консоли таблицу умножения.
 */
public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter the size of the multiplication table: ");
        int tableSize = in.nextInt();

        for (int i = 1; i <= tableSize; i++) {
            System.out.print("\t" + i);
        }
        System.out.println();


        for (int i = 1; i <= tableSize; i++) {
            System.out.print(i + "\t");

            for (int j = 1; j <= tableSize; j++) {
                System.out.print(i * j + "\t");
            }
            System.out.println();
        }
    }
}