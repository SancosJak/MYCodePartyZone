package code;
/*
Задание 2: Работа с файлами
Создайте текстовый файл с несколькими строками текста.
Напишите метод, который будет читать этот файл и выводить содержимое в консоль.
Напишите метод, который будет записывать в этот же файл строку “Hello, World!” в конец файла.

Пример работы:
Входные данные: Файл с текстом "Java is fun\nI love programming\n"
Выходные данные: В консоль выводится:
Java is fun
I love programming
Hello, World!
 */
import java.io.*;

public class l57_hw2 {

    public static void main(String[] args) {

        String filePath = "HomeWorks/lesson57/l57hw/code/hw2.txt";

        readFileAndPrint(filePath);
        writeToFile(filePath, "Hello, World!");
    }

    public static void readFileAndPrint(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeToFile(String filePath, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(content);
            writer.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
