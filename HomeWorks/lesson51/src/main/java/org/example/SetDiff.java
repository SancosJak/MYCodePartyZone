package org.example;

import java.util.HashSet;
import java.util.Set;

public class SetDiff {
    public static Set<Character> findSetDiff(Set<Character> set1, Set<Character> set2) {

        Set<Character> result = new HashSet<>(set1);

        result.removeAll(set2);

        // Вариант 2: contains
//         for (Character element : set1) {
//             if (set2.contains(element)) {
//                 result.remove(element);
//             }
//         }

        // Вариант 3: addAll
//         result.addAll(set1);
//         result.removeAll(set2);

        return result;
    }

    public static void main(String[] args) {

        Set<Character> set1 = new HashSet<>();
        set1.add('A');
        set1.add('B');
        set1.add('C');
        set1.add('D');

        Set<Character> set2 = new HashSet<>();
        set2.add('C');
        set2.add('D');
        set2.add('E');
        set2.add('F');

        Set<Character> resultSet = findSetDiff(set1, set2);
        System.out.println("Result: " + resultSet);
    }
}
