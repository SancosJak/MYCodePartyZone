package practice.array_list;

import java.util.Iterator;

public class ListAppl {
    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();

        System.out.println(list.size);
        System.out.println(list.isEmpty());

        list.add(20);
        list.add(70);
        list.add(30);
        list.add(50);
        System.out.println(list.size);
        System.out.println(list.isEmpty());

        list.add(null);
        list.add(70);
        System.out.println(list.size);

        System.out.println(list.get(4));

        System.out.println(list.indexOf(30));
        System.out.println(list.indexOf(80));

        System.out.println(list.contains(50));
        System.out.println(list.contains(55));

        System.out.println("Original list:");
        for (Integer element : list) {
            System.out.println(element);
        }

        System.out.println("Removing element at index 2: " + list.remove(2));
        System.out.println("Updated list:");
        for (Integer element : list) {
            System.out.println(element);
        }

        System.out.println("Replacing element at index 1: " + list.set(1, 100));
        System.out.println("Updated list:");
        for (Integer element : list) {
            System.out.println(element);
        }

        System.out.println("Last index of 70: " + list.lastIndexOf(70));

        //with iterator compare for-each and custom iterator
        System.out.println("Original list:");
        for (Integer element : list) {
            System.out.println(element);
        }

        System.out.println("Using iterator:");
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer element = iterator.next();
            System.out.println(element);
        }

        IList <String> myCityList = new MyArrayList<>();

        myCityList.add("Taskent");
        myCityList.add("Budapest");
        myCityList.add("Tokyo");
        myCityList.add("Kiev");

        System.out.println("Size: " + myCityList.size());
        System.out.println("Is empty: " + myCityList.isEmpty());

        System.out.println("City at index 2: " + myCityList.get(2));

        System.out.println("Index of 'Budapest': " + myCityList.indexOf("Budapest"));
        System.out.println("Index of 'London': " + myCityList.indexOf("London"));

        System.out.println("Contains 'Tokyo': " + myCityList.contains("Tokyo"));
        System.out.println("Contains 'Paris': " + myCityList.contains("Paris"));

        System.out.println("Original city list:");
        for (String city : myCityList) {
            System.out.println(city);
        }

        Iterator<String> iterator1 = myCityList.iterator();
        while (iterator1.hasNext()) {
            String city = iterator1.next();
            System.out.println(city);
        }

        System.out.println("Removing city at index 1: " + myCityList.remove(1));
        System.out.println("Updated city list:");
        for (String city : myCityList) {
            System.out.println(city);
        }

        System.out.println("Replacing city at index 2: " + myCityList.set(2, "London"));
        System.out.println("Updated city list:");
        for (String city : myCityList) {
            System.out.println(city);
        }

        IList<Boolean> booleanList = new MyArrayList<>();

        booleanList.add(true);
        booleanList.add(false);
        booleanList.add(true);
        booleanList.add(false);

        System.out.println("Size: " + booleanList.size());
        System.out.println("Is empty: " + booleanList.isEmpty());

        System.out.println("Element at index 2: " + booleanList.get(2));

        System.out.println("Index of 'true': " + booleanList.indexOf(true));
        System.out.println("Index of 'false': " + booleanList.indexOf(false));

        System.out.println("Contains 'true': " + booleanList.contains(true));
        System.out.println("Contains 'null': " + booleanList.contains(null));

        System.out.println("Original boolean list:");
        for (Boolean value : booleanList) {
            System.out.println(value);
        }

        Iterator<Boolean> iterator2 = booleanList.iterator();
        while (iterator2.hasNext()) {
            Boolean value = iterator2.next();
            System.out.println(value);
        }

        System.out.println("Removing element at index 1: " + booleanList.remove(1));
        System.out.println("Updated boolean list:");
        for (Boolean value : booleanList) {
            System.out.println(value);
        }

        System.out.println("Replacing element at index 2: " + booleanList.set(2, true));
        System.out.println("Updated boolean list:");
        for (Boolean value : booleanList) {
            System.out.println(value);
        }

        MyArrayList<Double> doubleList = new MyArrayList<>();

        System.out.println(doubleList.size());
        System.out.println(doubleList.isEmpty());

        doubleList.add(3.14);
        doubleList.add(2.71);
        doubleList.add(1.618);
        doubleList.add(0.577);

        System.out.println(doubleList.size());
        System.out.println(doubleList.isEmpty());

        doubleList.add(null);
        doubleList.add(42.0);
        System.out.println(doubleList.size());

        System.out.println(doubleList.get(4));

        System.out.println(doubleList.indexOf(1.618));
        System.out.println(doubleList.indexOf(3.0));

        System.out.println(doubleList.contains(2.71));
        System.out.println(doubleList.contains(1.1));

        System.out.println("Original list:");
        for (Double value : doubleList) {
            System.out.println(value);
        }

        System.out.println("Removing element at index 2: " + doubleList.remove(2));
        System.out.println("Updated list:");
        for (Double value : doubleList) {
            System.out.println(value);
        }

        System.out.println("Replacing element at index 1: " + doubleList.set(1, 3.33));
        System.out.println("Updated list:");
        for (Double value : doubleList) {
            System.out.println(value);
        }

        System.out.println("Original list:");
        for (Double value : doubleList) {
            System.out.println(value);
        }

        System.out.println("Using iterator:");
        Iterator<Double> iterator3 = doubleList.iterator();
        while (iterator3.hasNext()) {
            Double value = iterator3.next();
            System.out.println(value);
        }

        MyArrayList<Long> longList = new MyArrayList<>();

        System.out.println(longList.size);
        System.out.println(longList.isEmpty());

        longList.add(200L);
        longList.add(700L);
        longList.add(300L);
        longList.add(500L);
        System.out.println(longList.size);
        System.out.println(longList.isEmpty());

        longList.add(null);
        longList.add(700L);
        System.out.println(longList.size);

        System.out.println(longList.get(4));

        System.out.println(longList.indexOf(300L));
        System.out.println(longList.indexOf(800L));

        System.out.println(longList.contains(500L));
        System.out.println(longList.contains(550L));

        System.out.println("Original list:");
        for (Long element : longList) {
            System.out.println(element);
        }

        System.out.println("Removing element at index 2: " + longList.remove(2));
        System.out.println("Updated list:");
        for (Long element : longList) {
            System.out.println(element);
        }

        System.out.println("Replacing element at index 1: " + longList.set(1, 100L));
        System.out.println("Updated list:");
        for (Long element : longList) {
            System.out.println(element);
        }

        System.out.println("Last index of 700L: " + longList.lastIndexOf(700L));

        System.out.println("Original list:");
        for (Long element : longList) {
            System.out.println(element);
        }

        System.out.println("Using iterator:");
        Iterator<Long> iterator4 = longList.iterator();
        while (iterator4.hasNext()) {
            Long element = iterator4.next();
            System.out.println(element);
        }
    }
}
