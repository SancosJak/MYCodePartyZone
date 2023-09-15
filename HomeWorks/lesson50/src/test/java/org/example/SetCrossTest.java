package org.example;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class SetCrossTest extends TestCase{

    @Test
    public void testSetsCrossWithInteger() {
        Set<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        Set<Integer> result = SetCross.setsCross(set1, set2);

        assertEquals(2, result.size());
        assertTrue(result.contains(2));
        assertTrue(result.contains(3));
    }

    @Test
    public void testSetsCrossWithEmptySets() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        Set<Integer> result = SetCross.setsCross(set1, set2);

        Set<Integer> expectedResult = new HashSet<>();
        assertEquals(expectedResult, result);
    }
    @Test
    public void testSetsCrossWithChars() {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        set1.add('a');
        set1.add('b');
        set1.add('c');

        set2.add('b');
        set2.add('c');
        set2.add('d');

        Set<Character> result = SetCross.setsCross(set1, set2);

        Set<Character> expectedResult = new HashSet<>();
        expectedResult.add('b');
        expectedResult.add('c');
        assertEquals(expectedResult, result);
    }

    @Test
    public void testSetsCrossWithStrings() {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("apple");
        set1.add("banana");
        set1.add("cherry");

        set2.add("banana");
        set2.add("grape");
        set2.add("mango");

        Set<String> result = SetCross.setsCross(set1, set2);

        Set<String> expectedResult = new HashSet<>();
        expectedResult.add("banana");

        assertEquals(expectedResult, result);
    }

    @Test
    public void testSetsCrossWithDouble() {
        Set<Double> set1 = new HashSet<>();
        Set<Double> set2 = new HashSet<>();

        set1.add(1.5);
        set1.add(2.0);
        set1.add(3.75);

        set2.add(2.0);
        set2.add(3.0);
        set2.add(4.25);

        Set<Double> result = SetCross.setsCross(set1, set2);

        Set<Double> expectedResult = new HashSet<>();
        expectedResult.add(2.0);

        assertEquals(expectedResult, result);
    }
    @Test
    public void testSetsCrossWithFloat() {
        Set<Float> set1 = new HashSet<>();
        Set<Float> set2 = new HashSet<>();

        set1.add(1.5f);
        set1.add(2.0f);
        set1.add(3.75f);

        set2.add(2.0f);
        set2.add(3.0f);
        set2.add(4.25f);

        Set<Float> result = SetCross.setsCross(set1, set2);

        Set<Float> expectedResult = new HashSet<>();
        expectedResult.add(2.0f);

        assertEquals(expectedResult, result);
    }

}