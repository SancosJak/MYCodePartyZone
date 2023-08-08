package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

interface MathOperation {
    int operate(int a, int b);
}

public class LambdaExamples {
    public static void main(String[] args) {
        // Пример 1: Сортировка списка строк
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");
        names.add("David");

        Collections.sort(names, (name1, name2) -> name1.compareTo(name2));
        System.out.println("Sorted names: " + names);

        // Пример 2: Вычисление суммы чисел
        MathOperation addition = (a, b) -> a + b;
        int result = addition.operate(10, 20);
        System.out.println("Result: " + result);

        // Пример 3: Потоковая обработка и суммирование чисел
        int sum = IntStream.rangeClosed(1, 10)
                .filter(num -> num % 2 == 0)
                .sum();
        System.out.println("Sum of even numbers: " + sum);
    }
}
