package code;
/*
Задание 1: Работа с потоками данных
Создайте коллекцию типа List<Integer> с числами от 1 до 100.
Используя Stream API, отфильтруйте только четные числа, затем каждое число умножьте на 2 и соберите результат в новый список.
Выведите новый список в консоль.

Пример работы:
Входные данные: Числа от 1 до 100.
Выходные данные: [4, 8, 12, 16, 20, ..., 196, 200]
 */
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class l57_hw1 {
    public static void main(String[] args) {

        List<Integer> numbers = IntStream.rangeClosed(1, 100)
                .boxed()
                .collect(Collectors.toList());

        List<Integer> result = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * 2)
                .collect(Collectors.toList());

        System.out.println(result);
    }
}
