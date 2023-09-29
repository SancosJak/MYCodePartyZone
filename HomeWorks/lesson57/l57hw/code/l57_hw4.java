package code;
/*
Задание 4: Комбинированные операции
Создайте коллекцию строк.
Используя Stream API, преобразуйте каждую строку в верхний регистр, и отфильтруйте строки, длина которых больше 3 символов.
Запишите отфильтрованные и преобразованные строки в новый текстовый файл.

Пример работы:
Входные данные: Список строк ["apple", "banana", "cherry", "date"].
Выходные данные: В файл записываются строки:
APPLE
BANANA
CHERRY
 */
import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class l57_hw4 {

    public static void main(String[] args) {

        List<String> str = Arrays.asList("apple", "banana", "cherry", "date", "age");

        List<String> changedStr = str.stream()
                .filter(s -> s.length() > 3)
                .map(String::toUpperCase)
                .collect(Collectors.toList());

        String filePath = "HomeWorks/lesson57/l57hw/code/hw4.txt";

        writeToFile(filePath, changedStr);
    }

    public static void writeToFile(String filePath, List<String> content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String line : content) {
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
