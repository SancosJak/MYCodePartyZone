package code;
/*
Задание 5: Обработка исключений
Напишите метод, который будет пытаться читать несуществующий файл и обрабатывать возможное исключение FileNotFoundException, выводя сообщение об ошибке в консоль.
Пример работы:
Входные данные: Попытка чтения несуществующего файла nonexistent.txt.
Выходные данные: В консоль выводится сообщение "File not found: nonexistent.txt".
 */
import java.io.*;

public class l57_hw5 {
    public static void main(String[] args) {

        String filePath = "nonexistent.txt";

        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
