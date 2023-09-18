package practice.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import practice.MyLinkedList;
import practice.MyLinkedListImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListImplTest {

    private MyLinkedList linkedList;

    @BeforeEach
    public void setUp() {
        linkedList = new MyLinkedListImpl("First");
    }

    @Test
    public void testAdd() {
        linkedList.add("Second");
        linkedList.add("Third");

        assertEquals(3, linkedList.size());
        assertEquals("First", linkedList.get(0));
        assertEquals("Second", linkedList.get(1));
        assertEquals("Third", linkedList.get(2));

    }

    @Test
    public void testAddAtIndex() {
        linkedList.add("Second");
        linkedList.add("Third");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.add(100, "Invalid Index");
        });

        linkedList.add(1, "NewSecond");

        assertEquals(4, linkedList.size());
        assertEquals("First", linkedList.get(0));
        assertEquals("NewSecond", linkedList.get(1));
        assertEquals("Second", linkedList.get(2));
        assertEquals("Third", linkedList.get(3));

    }

    @Test
    public void testSet() {
        linkedList.add("Second");
        linkedList.add("Third");

        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.set(100, "Invalid Index");
        });


        linkedList.set(1, "NewSecond");

        assertEquals(3, linkedList.size());
        assertEquals("First", linkedList.get(0));
        assertEquals("NewSecond", linkedList.get(1));
        assertEquals("Third", linkedList.get(2));
    }

    @Test
    public void testAddFirst() {
        linkedList.addFirst("NewFirst");

        assertEquals(2, linkedList.size());
        assertEquals("NewFirst", linkedList.getFirst());
        assertEquals("First", linkedList.getLast());
    }

    @Test
    public void testAddLast() {
        linkedList.addLast("NewLast");

        assertEquals(2, linkedList.size());
        assertEquals("First", linkedList.getFirst());
        assertEquals("NewLast", linkedList.getLast());
    }

    @Test
    public void testAddAll() {
        List<String> list = new ArrayList<>();
        list.add("Second");
        list.add("Third");

        linkedList.addAll(list);

        assertEquals(3, linkedList.size());
        assertEquals("First", linkedList.get(0));
        assertEquals("Second", linkedList.get(1));
        assertEquals("Third", linkedList.get(2));
    }

    @Test
    public void testContains() {
        assertFalse(linkedList.contains("Second"));

        linkedList.add("Second");
        linkedList.add("Third");

        assertTrue(linkedList.contains("Second"));
        assertFalse(linkedList.contains("Fourth"));
    }

    @Test
    public void testGet() {
        linkedList.add("Second");
        linkedList.add("Third");

        String element = linkedList.get(1);

        assertEquals("Second", element);

        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(100);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(-1);
        });
    }

    @Test
    public void testGetFirst() {
        linkedList.add("Second");
        linkedList.add("Third");

        assertEquals(1, linkedList.firstIndexOf("Second"));
        assertEquals(-1, linkedList.firstIndexOf("Fourth"));

        linkedList = new MyLinkedListImpl(null);

        assertNull(linkedList.getFirst());

//        assertThrows(NoSuchElementException.class, () -> {
//            linkedList.getFirst();
//        }, "NoSuchElementException to be thrown");
    }

    @Test
    public void testGetLast() {
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.add("Second");

        assertEquals(3, linkedList.lastIndexOf("Second"));
        assertEquals(-1, linkedList.lastIndexOf("Fourth"));

        linkedList = new MyLinkedListImpl(null);
        assertNull(linkedList.getLast());

    }

    @Test
    public void testSize() {
        assertEquals(1, linkedList.size());

        linkedList.add("Second");
        linkedList.add("Third");

        assertEquals(3, linkedList.size());
    }

    @Test
    public void testIndexOf() {
        linkedList.add("Second");
        linkedList.add("Third");

        assertEquals(1, linkedList.indexOf("Second"));
        assertEquals(-1, linkedList.indexOf("Fourth"));
    }

    @Test
    public void testFirstIndexOf() {
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.add("Second");

        int index = linkedList.firstIndexOf("Second");

        assertEquals(1, index);

        index = linkedList.firstIndexOf("Fourth");

        assertEquals(-1, index);
    }

    @Test
    public void testLastIndexOf() {
        linkedList.add("Second");
        linkedList.add("Third");
        linkedList.add("Second");

        int index = linkedList.lastIndexOf("Second");

        assertEquals(3, index);

        index = linkedList.lastIndexOf("Fourth");

        assertEquals(-1, index);
    }

}