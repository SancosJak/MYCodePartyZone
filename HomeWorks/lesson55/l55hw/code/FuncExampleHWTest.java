package code;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;


public class FuncExampleHWTest {

    @Test
    public void testAction() {
        Action<Integer> printAction = num -> System.out.println("Number: " + num);
        assertDoesNotThrow(() -> printAction.execute(100));

        Action<List<String>> addItemsToList = list -> {
            list.add("1st element");
            list.add("2nd element");
        };

        List<String> myList = new ArrayList<>();
        addItemsToList.execute(myList);

        assertEquals(2, myList.size());
        assertTrue(myList.contains("1st element"));
        assertTrue(myList.contains("2nd element"));
    }

    @Test
    public void testIsEven() {
        Condition<Integer> isEven = number -> number % 2 == 0;
        assertTrue(isEven.test(2));
        assertFalse(isEven.test(3));
    }

    @Test
    public void testIsNotEmpty() {
        Condition<String> isNotEmpty = str -> !str.isEmpty();
        assertTrue(isNotEmpty.test("Hello"));
        assertFalse(isNotEmpty.test(""));
    }

    @Test
    public void testRandomProvider() {
        Provider<Integer> randomProvider = () -> {
            int randomNumber = (int) (Math.random() * 100);
            return randomNumber;
        };
        int randomNumber = randomProvider.provide();
        assertTrue(randomNumber >= 0 && randomNumber < 100);
    }

    @Test
    public void testStringProvider() {
        Provider<String> stringProvider = () -> "Hi";
        String providedString = stringProvider.provide();
        assertEquals("Hi", providedString);

        int length = providedString.length();
        assertEquals(2, length);
    }

    @Test
    public void testDoubleProvider() {
        Provider<Double> doubleProvider = () -> Math.PI;
        double piValue = doubleProvider.provide();
        assertEquals(Math.PI, piValue, 0.001);
    }


}
