package practice;

public class Classwork58 {
    public static void main(String[] args) {
        //task1();
//        task2();
//        task3();
//        task4();
//        task5();
    }

    /**
     * Задача 1: Создать два потока, один поток должен выводить четные числа от 0 до 10, а другой - нечетные числа от 1 до 9.
     */
    public static void task1() {
        Thread evenThread = new Thread(() -> {
            for (int i = 0; i <= 10; i += 2) {
                System.out.println("Even: " + i);
            }
        });

        Thread oddThread = new Thread(() -> {
            for (int i = 1; i <= 9; i += 2) {
                System.out.println("Odd: " + i);
            }
        });

        evenThread.start();
        oddThread.start();
    }

    /**
     * Задача 2: Создать поток, который выводит числа от 1 до 5 с интервалом в 1 секунду, после чего главный поток выводит "Завершено".
     */
    public static void task2() {
        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Завершено");
    }

    /**
     * Задача 3: Создать поток, который ждет 5 секунд перед тем как вывести "Поток завершен", главный поток должен дождаться завершения этого потока.
     */
    public static void task3() {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Поток завершен");
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Задача 4: Создать два потока, которые выводят "Поток 1" и "Поток 2" соответственно, каждые 1 и 3 секунды.
     */
    public static void task4() {
        Thread thread1 = new Thread(() -> {
            while (true) {
                System.out.println("Поток 1");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread thread2 = new Thread(() -> {
            while (true) {
                System.out.println("Поток 2");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread1.start();
        thread2.start();
    }

    /**
     * Задача 5: Создать поток, который выводит числа от 10 до 1, после чего главный поток выводит "Старт".
     */
    public static void task5() {
        Thread thread = new Thread(() -> {
            for (int i = 10; i >= 1; i--) {
                System.out.println(i);
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Старт");
    }
}
