package l45hw;

import java.util.List;
import java.util.ArrayList;

public class TemperatureList {
    public static void main(String[] args) {
        List<Double> temperatureList = new ArrayList<>();

        temperatureList.add(25.5);
        temperatureList.add(18.3);
        temperatureList.add(30.0);
        temperatureList.add(22.8);

        System.out.println("Temperature in different cities:");
        for (int i = 0; i < temperatureList.size(); i++) {
            System.out.println("City " + (i + 1) + ": " + temperatureList.get(i) + "°C");
        }
    }
}