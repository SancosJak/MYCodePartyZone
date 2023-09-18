package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapExampleHW {
    public static void main(String[] args) {
        // pairs of "hero-power"
        Map<String, Integer> heroPowers = new HashMap<>();

        heroPowers.put("Spider-Man", 88);
        heroPowers.put("Iron Man", 95);
        heroPowers.put("Captain America", 72);

        int spidermanPower = heroPowers.get("Spider-Man");
        System.out.println("Spider-Man's power: " + spidermanPower);

        if (heroPowers.containsKey("Iron Man")) {
            System.out.println("Hero Iron Man is present.");
        }

        if (heroPowers.containsValue(72)) {
            System.out.println("Power 72 is present.");
        }

        Set<String> heroNames = heroPowers.keySet();
        System.out.println("Hero names: " + heroNames);

        heroPowers.remove("Captain America");

        System.out.println("Map entries:");

        for (Map.Entry<String, Integer> entry : heroPowers.entrySet()) {
            String heroName = entry.getKey();
            int power = entry.getValue();
            System.out.println("Hero: " + heroName + ", Power: " + power);
        }
    }
}
