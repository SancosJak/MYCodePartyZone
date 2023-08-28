package practice.arrayMethods;

import java.util.Comparator;
import java.util.function.Predicate;

public class ArrayTools {
    //печать массива
    public static void printArray(Object[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println("---------");
    }
    //поиск обьекта в массиве обьекта
    public static int searchIndex (Object[] arr, Object value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)){
                return i;
            }
        }
        return -1;
    }
    //поиск обьекта в массиве обьекта возвращает boolean
    public static boolean searchBoolean (Object[] arr, Object value){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals(value)){
                return true;
            }
        }
        return false;
    }
    //поиск обьектов по условию
    public static <T> T findByPredicate(T[] arr, Predicate <T> predicate) {
        //метод возвращает тип Т из массива типа T[] и отбор по предикату
        for (int i = 0; i < arr.length; i++) {
            if (predicate.test(arr[i])) {
                return arr[i];
            }
        }
        return null;
    }
//bubble sort
    public static < T extends Comparable <T> > void bubbleSortWithComparable(T[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j].compareTo(arr[j+1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    // bubble sort by Comparator
    public static <T> void bubbleSortWithComparator(T[] arr, Comparator<T> comparator) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (comparator.compare(arr[j], arr[j+1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

}
