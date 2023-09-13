package org.example;

import java.util.HashSet;
import java.util.Set;

public class SetCross {
    public static <T> Set<T> setsCross (Set<T> set1, Set<T> set2) {
        // 1-й вариант нахождения пересечения множеств

//        Set<T> result = new HashSet<>();
//        for (T element : set1) {
//            if (set2.contains(element)) {
//                result.add(element);
//            }
//        }

        // 2-й вариант нахождения пересечения множеств
        Set<T> result = new HashSet<>(set1);
        result.retainAll(set2);

        return result;
    }
}
