package org.example;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class MarvelHeroBirthdayMap {
    public static void main(String[] args) {
        Map<String, LocalDate> birthdayMap = new HashMap<>();

        birthdayMap.put("Iron Man", LocalDate.of(1963, 3, 1));
        birthdayMap.put("Spider-Man", LocalDate.of(1962, 8, 1));
        birthdayMap.put("Thor", LocalDate.of(1962, 8, 1));
        birthdayMap.put("Black Widow", LocalDate.of(1964, 4, 1));
        birthdayMap.put("Hulk", LocalDate.of(1962, 5, 1));
        birthdayMap.put("Captain America", LocalDate.of(1941, 3, 1));

        int size = birthdayMap.size();
        System.out.println("Size of the birthday map after putting: " + size);


        String nameToFind = "Iron Man";
        LocalDate ironManBirthday = birthdayMap.get(nameToFind);
        if (ironManBirthday != null) {
            System.out.println(nameToFind + "'s birthday is on " + ironManBirthday);
        } else {
            System.out.println("Name not found: " + nameToFind);
        }

        String nameToCheck = "Thor";
        if (birthdayMap.containsKey(nameToCheck)) {
            System.out.println(nameToCheck + " is in the birthday map.");
        } else {
            System.out.println(nameToCheck + " is not in the birthday map.");
        }

        LocalDate birthdayToCheck = LocalDate.of(1964, 4, 1);
        if (birthdayMap.containsValue(birthdayToCheck)) {
            System.out.println("Someone in the birthday map has a birthday on " + birthdayToCheck);
        } else {
            System.out.println("No one in the birthday map has a birthday on " + birthdayToCheck);
        }

        System.out.println("Names of Marvel Heroes in the B-Day map:");
        for (String name : birthdayMap.keySet()) {
            System.out.println(name);
        }

        String nameToRemove = "Black Widow";
        birthdayMap.remove(nameToRemove);
        System.out.println(nameToRemove + " has been removed from the birthday map.");

        size = birthdayMap.size();
        System.out.println("Size of the birthday map after removing: " + size);

        System.out.println("Birthdays of Marvel Heroes in the birthday map:");
        for (LocalDate birthday : birthdayMap.values()) {
            System.out.println(birthday);
        }

    }
}
