package code;

import java.util.ArrayList;
import java.util.List;

public class FuncExampleHW {
    public static void main(String[] args) {

        System.out.println("\u001B[36mResult of Action\u001B[0m"); //ANSI codes for text colors

        Action<Integer> printAction = num -> System.out.println("Number: " + num);
        printAction.execute(55);

        Action <List <String>> addItemsToList = list -> {
            list.add("1st element");
            list.add("2nd element");
        };

        List<String> myList = new ArrayList<>();

        addItemsToList.execute(myList);

        System.out.println("List Contents:");
        for (String item : myList) {
            System.out.println(item.toUpperCase());
        }

        System.out.println("\u001B[36mResult of Condition\u001B[0m");

        Condition<Integer> isEven = number -> number % 2 == 0;
        int num = 10;
        if (isEven.test(num)) {
            System.out.println(num + " - even.");
        } else {
            System.out.println(num + " - odd.");
        }

        Condition<String> isNotEmpty = str -> !str.isEmpty();
        System.out.println(isNotEmpty.test("Hello"));
        System.out.println(isNotEmpty.test(""));

        System.out.println("\u001B[36mResult of Provider\u001B[0m");

        Provider<Integer> randomProvider = () -> (int) (Math.random() * 100);
        int randomNumber = randomProvider.provide();
        System.out.println("Random number: " + randomNumber);

        Provider<String> stringProvider = () -> ("Hi");
        String providedString = stringProvider.provide();
        System.out.println(providedString);
    }
}
