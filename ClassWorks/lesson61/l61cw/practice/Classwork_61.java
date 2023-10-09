package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;


public class Classwork_61 {
    public static void main(String[] args) {
        Classwork_61 cw = new Classwork_61();
        cw.task1AtomicInteger();
        cw.task2AtomicArray();
        cw.task3CopyOnWriteArrayList();
        cw.task4ConcurrentHashMap();
        cw.task5BlockingQueue();
    }

    // Задача 1: Использование AtomicInteger для инкремента и декремента значения в многопоточной среде.
    void task1AtomicInteger() {
        AtomicInteger atomicInt = new AtomicInteger(0);

        // Создайте несколько потоков, которые будут инкрементировать и декрементировать значение atomicInt.
        // Убедитесь, что обновленное значение является правильным, после выполнения всех потоков.

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 5000; j++) {
                    atomicInt.incrementAndGet();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 3000; j++) {
                    atomicInt.decrementAndGet();
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Final Counter Value: " + atomicInt.get());
    }

    // Задача 2: Использование AtomicReferenceArray для управления массивом объектов в многопоточной среде.
    void task2AtomicArray() {
        AtomicReferenceArray<String> atomicArray = new AtomicReferenceArray<>(10);

        // Создайте потоки, которые будут изменять различные индексы atomicArray и убедитесь, что чтение данных
        // происходит корректно.
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int index = i;
            Thread thread = new Thread(() -> {
                atomicArray.set(index, "Thread " + index);
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        for (int i = 0; i < atomicArray.length(); i++) {
            System.out.println("Index " + i + ": " + atomicArray.get(i));
        }
    }

    // Задача 3: Использование CopyOnWriteArrayList для безопасной записи во время итерирования.
    void task3CopyOnWriteArrayList() {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();

        // Придумайте сценарий, где несколько потоков читают и пишут в список одновременно.
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {
                for (String item : list) {
                    System.out.println("Read: " + item);
                }

                list.add("New Item");
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Задача 4: Использование ConcurrentHashMap для хранения и извлечения пар ключ-значение в многопоточной среде.
    void task4ConcurrentHashMap() {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap<>();

        //  Создайте сценарий, где несколько потоков добавляют, удаляют и читают пары ключ-значение одновременно,
        // не используя явные блокировки.
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(() -> {

                map.put("Key", "Value");
                map.remove("Key");

                String value = map.get("Key");
                if (value != null) {
                    System.out.println("Read: " + value);
                }
            });
            threads.add(thread);
            thread.start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // Задача 5: Использование BlockingQueue для потокобезопасного добавления и извлечения объектов.
    void task5BlockingQueue() {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        // Создайте производителя, который помещает объекты в очередь, и потребителя, который извлекает объекты из
        // очереди. Убедитесь, что потребитель может консумировать объекты правильно, даже если производитель добавляет их в
        // произвольные моменты времени.

        List<Thread> threads = new ArrayList<>();

        Thread producer = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    String item = "Item " + i;
                    queue.put(item);
                    System.out.println("Produced: " + item);
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    String item = queue.take();
                    System.out.println("Consumed: " + item);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        producer.start();
        consumer.start();

        try {
            producer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
