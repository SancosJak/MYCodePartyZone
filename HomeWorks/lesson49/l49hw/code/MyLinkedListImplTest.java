package code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListImplTest {
    private MyLinkedList myList;

    @BeforeEach
    public void setUp() {
        myList = new MyLinkedListImpl();
    }

    @Test
    void testAdd() {
        assertTrue(myList.add("Element1"));
        assertEquals("Element1", myList.get(0));
        assertEquals(1, myList.size());
    }

    @Test
     void testAddAtIndex() {
        myList.add("Element1");
        myList.add("Element3");

        assertTrue(myList.add(1, "Element2"));
        assertEquals("Element1", myList.get(0));
        assertEquals("Element2", myList.get(1));
        assertEquals("Element3", myList.get(2));
        assertEquals(3, myList.size());

        assertThrows(IndexOutOfBoundsException.class, () -> myList.add(-100, "Invalid"));
    }

    @Test
     void testSet() {
        myList.add("Element1");
        myList.add("Element2");

        assertTrue(myList.set(1, "NewElement"));
        assertEquals("NewElement", myList.get(1));
        assertEquals(2, myList.size());

        myList.set(0, "InvalidElement");
    }

    @Test
    void testAddFirst() {
        assertTrue(myList.addFirst("Element1"));
        assertEquals("Element1", myList.getFirst());
        assertEquals(1, myList.size());
    }

    @Test
    void testAddLast() {
        assertTrue(myList.addLast("Element1"));
        assertEquals("Element1", myList.getLast());
        assertEquals(1, myList.size());
    }

    @Test
    void testAddAll() {
        List<String> elementsToAdd = Arrays.asList("Element1", "Element2", "Element3");

        assertTrue(myList.addAll(elementsToAdd));
        assertEquals(3, myList.size());
        assertEquals("Element1", myList.get(0));
        assertEquals("Element2", myList.get(1));
        assertEquals("Element3", myList.get(2));
    }

    @Test
    void testContains() {
        myList.add("Element1");
        myList.add("Element2");

        assertTrue(myList.contains("Element1"));
        assertFalse(myList.contains("Element3"));
    }

    @Test
    void testGet() {
        myList.add("Element1");
        myList.add("Element2");

        assertEquals("Element1", myList.get(0));
        assertEquals("Element2", myList.get(1));

        myList.get(0);
    }

    @Test
    void testGetFirst() {
        myList.add("Element1");
        myList.add("Element2");

        assertEquals("Element1", myList.getFirst());
    }

    @Test
    void testGetLast() {
        myList.add("Element1");
        myList.add("Element2");

        assertEquals("Element2", myList.getLast());
    }
    @Test
    void testSize() {
        myList.add("Element1");
        myList.add("Element2");

    }

    @Test
    void testIndexOf() {
        myList.add("Element1");
        myList.add("Element2");
        myList.add("Element1");

        assertEquals(0, myList.indexOf("Element1"));
        assertEquals(1, myList.indexOf("Element2"));
        assertEquals(-1, myList.indexOf("Element3"));
    }

    @Test
    void testFirstIndexOf() {
        myList.add("Element1");
        myList.add("Element2");
        myList.add("Element1");

        assertEquals(0, myList.firstIndexOf("Element1"));
        assertEquals(1, myList.firstIndexOf("Element2"));
        assertEquals(-1, myList.firstIndexOf("Element3"));
    }

    @Test
    void testLastIndexOf() {
        myList.add("Element1");
        myList.add("Element2");
        myList.add("Element1");

        assertEquals(2, myList.lastIndexOf("Element1"));
        assertEquals(1, myList.lastIndexOf("Element2"));
        assertEquals(-1, myList.lastIndexOf("Element3"));
    }

    @Test
    public void testReverseLinkedList() {
        MyLinkedList linkedList = new MyLinkedListImpl();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        MyLinkedList reversedList = linkedList.reverseLinkedList();

        assertEquals("C", reversedList.get(0));
        assertEquals("B", reversedList.get(1));
        assertEquals("A", reversedList.get(2));
    }

    @Test
    public void testReverseLinkedListWithStartIndex() {
        MyLinkedList linkedList = new MyLinkedListImpl();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");

        MyLinkedList reversedList = linkedList.reverseLinkedList(1);

        assertEquals("B", reversedList.get(0));
        assertEquals("A", reversedList.get(1));
    }

    @Test
    public void testReverseLinkedListWithStartAndEndIndex() {

        MyLinkedList linkedList = new MyLinkedListImpl();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("F");

        assertThrows(IndexOutOfBoundsException.class, () -> myList.reverseLinkedList(-1, 3));
        assertThrows(IndexOutOfBoundsException.class, () -> myList.reverseLinkedList(1, 10));

        MyLinkedList reversedList = linkedList.reverseLinkedList(2, 4);

        assertEquals("A", reversedList.get(0));
        assertEquals("B", reversedList.get(1));
        assertEquals("D", reversedList.get(2));
        assertEquals("C", reversedList.get(3));
        assertEquals("E", reversedList.get(4));
        assertEquals("F", reversedList.get(5));
    }
}