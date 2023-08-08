import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Добрый день!"); // это для вывода на консоль (на печать) приветствия

//        Reader inputStreamReader = new InputStreamReader(System.in); // готовим ввод с клавиатуры
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader); // готовим ввод с клавиатуры

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); // вводимые значения попадвют в br

        System.out.println("Введите первое число: "); // Это приглашение к вводу
        String num1 = br.readLine(); //читаем строку с клавиатуры в переменную num1
        System.out.println("Вы ввели " + num1 + " - это первое число"); // Это сообщение пользователю
        int n1 = Integer.parseInt(num1); //преобразовываем строку в число.

        System.out.println("Введите второе число: "); // Это приглашение к вводу
        String num2 = br.readLine(); //читаем строку с клавиатуры
        System.out.println("Вы ввели " + num2 + " - это второе число"); // Это сообщение пользователю
        int n2 = Integer.parseInt(num2); //преобразовываем строку в число.

        System.out.println(" 1-е число  " + n1 + " умножить на второе число " + n2 + " получилось " + (n1 * n2) );
        System.out.println("Спасибо!");
    }
}
// Более компактная запись:
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        String name1 = br.readLine(); // читаем строку
//        String sAge1 = br.readLine(); // читаем строку
//        int nAge1 = Integer.parseInt(sAge); // преобразовываем строку в целое число