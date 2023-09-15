package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

public class SetDiffTest {
    private Set<Character> set1;
    private Set<Character> set2;

    @BeforeEach
    public void setUp() {
        set1 = new HashSet<>();
        set1.add('A');
        set1.add('B');
        set1.add('C');
        set1.add('D');

        set2 = new HashSet<>();
        set2.add('C');
        set2.add('D');
        set2.add('E');
        set2.add('F');
    }

    @Test
    public void testFindSetDiff() {
        Set<Character> resultSet = SetDiff.findSetDiff(set1, set2);

        Set<Character> expectedSet = new HashSet<>();
        expectedSet.add('A');
        expectedSet.add('B');

        assertEquals(expectedSet, resultSet);
    }
    // Тест на пустых множествах
    @Test
    public void testFindSetDiffEmptySets() {
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        Set<Character> resultSet = SetDiff.findSetDiff(set1, set2);

        assertTrue(resultSet.isEmpty());
    }

    // Тест при set1 = set2
    @Test
    public void testFindSetDiffIdenticalSets() {
        Set<Character> resultSet = SetDiff.findSetDiff(set1, set1);

        assertTrue(resultSet.isEmpty());
    }

    // Тест set2 являющемся подмножеством set1
    @Test
    public void testFindSetDiffSubset() {
        Set<Character> set2 = new HashSet<>();
        set2.add('C');
        set2.add('D');

        Set<Character> resultSet = SetDiff.findSetDiff(set1, set2);

        Set<Character> expectedSet = new HashSet<>();
        expectedSet.add('A');
        expectedSet.add('B');

        assertEquals(expectedSet, resultSet);
    }

    // Тест set1, являющемся подмножеством set2
    @Test
    public void testFindSetDiffSubset1() {
        Set<Character> set1 = new HashSet<>();
        set1.add('C');
        set1.add('D');

        Set<Character> resultSet = SetDiff.findSetDiff(set1, set2);

        assertTrue(resultSet.isEmpty());
    }
}
