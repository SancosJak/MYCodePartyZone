package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamHW {
    public static void main(String[] args) {

        filterElements();
        transformingElements();
        countElements();

    }

    public static void filterElements() {
        // Фильтрация элементов
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> output = new ArrayList<>();
        for (Integer i : input) {
            if (i % 2 == 0) {
                output.add(i);
            }
        }
        System.out.println("Original:");
        System.out.println(output);

        // Stream
        List<Integer> output1 = input.stream()
                .filter(i -> i % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("Stream:");
        System.out.println(output1);
    }

    public static void transformingElements() {
        // Преобразование элементов
        List<String> input = Arrays.asList("apple", "banana", "cherry");

        List<Integer> output = new ArrayList<>();
        for (String s : input) {
            output.add(s.length());
        }

        System.out.println("Original:");
        System.out.println(output);

        // Stream
        List<Integer> output1 = input.stream()
                .map(String::length)
                .collect(Collectors.toList());

        System.out.println("Stream:");
        System.out.println(output1);
    }

    public static void countElements() {
        // Подсчет элементов, удовлетворяющих условию
        List<Integer> input = Arrays.asList(1, 2, 3, 4, 5);

        int count = 0;
        for (Integer i : input) {
            if (i % 2 == 0) {
                count++;
            }
        }
        System.out.println("Original:");
        System.out.println(count);

        // Stream
        long count1 = input.stream()
                .filter(i -> i % 2 == 0)
                .count();

        System.out.println("Stream:");
        System.out.println(count1);
    }
}
