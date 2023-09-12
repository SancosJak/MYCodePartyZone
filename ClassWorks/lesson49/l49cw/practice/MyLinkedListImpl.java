package practice;

import java.util.List;
import java.util.NoSuchElementException;

public class MyLinkedListImpl implements MyLinkedList{

    private Node head;
    private Node tail;
    private int size;

    public MyLinkedListImpl (String data) {
        this.head = new Node(data, null, null);
        this.tail = this.head;
        this.size = 1;
    }

    @Override
    public boolean add(String data) {
        Node node1 = new Node(data, tail, null);
        this.tail.next = node1;
        this.tail = node1;
        size++;
        return true;
    }

    @Override
    public boolean add(int index, String data) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds " + size);
        }

        Node newNode = new Node(data, null, null);

        if (index == 0) {

            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        } else if (index == size) {

            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {

            Node temp = head;

            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            newNode.prev = temp.prev;
            temp.prev.next = newNode;
            newNode.next = temp;
            temp.prev = newNode;
        }

        size++;
        return true;
    }


    @Override
    public boolean set(int index, String data) throws IndexOutOfBoundsException {
        if (index > size) {
            throw new IndexOutOfBoundsException("Index: "+index+" is out of bound "+size);
        }
        Node temp = this.head;
        Node newNode = new Node(data, null, null);

        for (int i = 0; i <= index; i++) {

            if (i == index) {
                newNode.prev = temp.prev;
                Node b = newNode.prev;
                b.next = newNode;
                newNode.next = temp.next;
                temp.next = newNode;
                Node d = newNode.next;
                d.prev = newNode;
                return true;
            } else{
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public boolean addFirst(String data) {

        Node newNode = new Node(data, null, null);

        head.prev = newNode;
        newNode.next = head;
        this.head = newNode;
        size++;

        return true;
    }

    @Override
    public boolean addLast(String data) {
        return add(data);
    }

    @Override
    public boolean addAll(List<String> list) {
//        for (String data : list) {
//            add(data);
//        }
//        return true;
        for (int i = 0; i < list.size(); i++) {
           add(list.get(i));
        }
        return true;
    }

    @Override
    public boolean contains(String data) {

        Node temp = head;

        for (int i = 0; i < size ; i++) {
            if (temp.data.equals(data)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }

    @Override
    public String get(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + " is out of bound " +size);
        }
        Node temp = head;

        for (int i = 0; i <= index ; i++) {
            if (i == index) {
               return temp.data;
            } else {
                temp = temp.next;
            }
        }
        return null;
    }

    @Override
    public String getFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return head.data;
    }

    @Override
    public String getLast() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }
        return tail.data;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int indexOf(String data) {
        Node temp = head;
        for (int i = 0; i < size; i++) {
            if (temp.data.equals(data)) {
                return i;
            }
            temp = temp.next;
        }
        return -1;
    }

    @Override
    public int firstIndexOf(String data) {
        return indexOf(data);
    }

    @Override
    public int lastIndexOf(String data) {
        Node temp = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (temp.data.equals(data)) {
                return i;
            }
            temp = temp.prev;
        }
        return -1;
    }

    private boolean isEmpty() {
        return size == 0;
    }
    private static class Node {
        String data;
        Node prev;
        Node next;

        public Node(String data, Node prev, Node next) {
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
}