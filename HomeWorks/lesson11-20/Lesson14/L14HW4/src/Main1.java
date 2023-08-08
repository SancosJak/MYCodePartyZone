public class Main1 {
    public static void main(String[] args) {
        int tableSize = 10;

        for (int i = 1; i <= tableSize; i++) {
            for (int j = 1; j <= tableSize; j++) {
                int result = i * j;
                System.out.print(i + " * " + j + " = " + result + "   \t");
            }
            System.out.println();
        }
    }
}
