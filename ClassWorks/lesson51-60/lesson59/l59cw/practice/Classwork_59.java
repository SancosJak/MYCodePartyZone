package practice;

public class Classwork_59 {

    public static void main(String[] args) {

        Classwork_59 tasks = new Classwork_59();

//        tasks.task1();
          tasks.task2();
//        tasks.task3();
//        tasks.task4();
//        tasks.task5();
    }

    // Задача 1: Создание и старт двух потоков
    public void task1() {
        Thread thread1 = new Thread(() -> {
            Thread.currentThread().setName("Thread - 1");
            System.out.println(Thread.currentThread().getName());
        });
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread - 2");
                System.out.println(Thread.currentThread().getName());
            }
        });

        thread1.start();
        thread2.start();
    }

    // Задача 2: Использование метода sleep()
    public void task2() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Thread");
            }
        });
        thread.start();
        System.out.println(thread.isInterrupted());
    }

    // Задача 3: Установка и получение приоритета потока. создайте поток, установите для него максмально возможный
    // приоритет. Выведите на экран "Task 3: Thread Priority: ..."
    public void task3() {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                Thread.currentThread().setName("Thread - prio");
                Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
                System.out.println("Task 3: Thread Priority: " + Thread.currentThread().getPriority());
            }
        });

        thread.start();
    }

    // Задача 4: Использование join() для ожидания завершения потока. Создайте поток, который печатает числа от 1 до 5
    // с интервалом в 1с, главный поток должен дождаться выполнения этого потока
    public void task4() {

        Thread thread = new Thread(() -> {
            for (int i = 1; i <= 5; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Task 4: Thread has finished execution");
    }

    // Задача 5: Использование потока-демона. Создайте демон-поток, который каждые 500 мс печатает в консоль
    // "Task 5: Daemon Thread is running", дайте поработать данному потоку 2 секунды, потом завршите выполнение
    // главного потока
    public void task5() {
        Thread daemonThread = new Thread(() -> {
            while (true) {
                System.out.println("Task 5: Daemon Thread is running");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        daemonThread.setDaemon(true); // Set the thread as a daemon

        daemonThread.start();

        // Let the daemon thread work for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Task 5: Main Thread is finishing, and the daemon will be terminated");
    }
}
