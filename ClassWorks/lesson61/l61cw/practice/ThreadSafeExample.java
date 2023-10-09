package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadSafeExample {
    private final ReentrantLock lock = new ReentrantLock();
    private final List<Integer> syncList = Collections.synchronizedList(new ArrayList<>());
    private final CopyOnWriteArrayList<Integer> copyOnWriteList = new CopyOnWriteArrayList<>();

    public void performAction() {
        Thread writeThread1 = new Thread(() -> writeData(syncList, "Thread-1"));
        Thread writeThread2 = new Thread(() -> writeData(copyOnWriteList, "Thread-2"));

        Thread readThread1 = new Thread(() -> readData(syncList, "Thread-3"));
        Thread readThread2 = new Thread(() -> readData(copyOnWriteList, "Thread-4"));

        writeThread1.start();
        writeThread2.start();
        readThread1.start();
        readThread2.start();
    }

    private void writeData(List<Integer> list, String threadName) {
        for (int i = 0; i < 1000; i++) {
            lock.lock();
            try {
                list.add(i);
            } finally {
                lock.unlock();
            }
        }
        System.out.println(threadName + " write completed");
    }

    private void readData(List<Integer> list, String threadName) {
        for (int i = 0; i < 1000; i++) {
            lock.lock();
            try {
                int data = list.size() > i ? list.get(i) : -1;
            } finally {
                lock.unlock();
            }
        }
        System.out.println(threadName + " read completed");
    }

    public static void main(String[] args) {
        new ThreadSafeExample().performAction();
    }
}
