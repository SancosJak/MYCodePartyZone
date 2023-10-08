package code;
/*
Задание 3: Работа с пользовательским вводом
Напишите программу, которая будет запрашивать у пользователя его имя.
Запишите имя пользователя в текстовый файл.
Затем прочитайте файл и выведите приветствие пользователю в консоль.

Пример работы:
Входные данные: Имя пользователя Alice.
Выходные данные: В консоль выводится "Hello, Alice!".
 */
import java.io.*;
import java.util.Scanner;

public class l57_hw3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String userName = scanner.nextLine();

        String filePath = "HomeWorks/lesson57/l57hw/code/hw3.txt";

        writeToFile(filePath, userName);

        String nameFormFile = readFromFile(filePath);
        System.out.println("Hello, " + nameFormFile + "!");

        scanner.close();
    }

    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
