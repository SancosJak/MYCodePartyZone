public class Main {
    //Найти произведение двузначных нечетных чисел кратных 13.
    public static void main(String[] args){
        int m = 1; //multiplication
        for (int i = 1; i * 13 < 100; i++)
            if (i % 2 == 1) {
                m *= i * 13;
            }
        System.out.println("Произведение двузначных нечетных чисел, кратных 13 = " + m);

    }
}