package code;

import practice.Classwork_60;

public class Homework_60 {
    public static void main(String[] args) {
        Classwork_60 tasks = new Classwork_60();
        tasks.task1();
//        tasks.task2();
//        tasks.task3();
//        tasks.task4();
//        tasks.task5();
    }

    // Задача 1: Создание и старт двух потоков
    public void task1() {
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Task 1: Поток 1 выполняется");
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                System.out.println("Task 1: Поток 2 выполняется");
            }
        });

        thread1.start();
        thread2.start();
    }

    // Задача 2: Использование метода sleep()
    public void task2() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Задача 2: Поток выполняется");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();
    }

    // Задача 3: Установка и получение приоритета потока. создайте поток, установите для него максмально возможный
    // приоритет. Выведите на экран "Task 3: Thread Priority: ..."

    public void task3() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Task 3: Поток выполняется");
            }
        });

        thread.setPriority(Thread.MAX_PRIORITY);

        thread.start();

        System.out.println("Task 3: Приоритет потока: " + thread.getPriority());
    }

    // Задача 4: Использование join() для ожидания завершения потока. Создайте поток, который печатает числа от 1 до 5
    // с интервалом в 1с, главный поток должен дождаться выполнения этого потока
    public void task4() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Задача 4: Поток выполняется");
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Задача 4: Поток 1 - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task 4: Thread has finished execution");
    }


    // Задача 5: Использование потока-демона. Создайте демон-поток, который каждые 500 мс печатает в консоль
    // "Task 5: Daemon Thread is running", дайте поработать данному потоку 2 секунды, потом завршите выполнение
    // главного потока
    public void task5() {
        Thread daemonThread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Task 5: Демон-поток выполняется");
                while (true) {
                    System.out.println("Task 5: Демон-поток выполняется");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        daemonThread.setDaemon(true);

        daemonThread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Task 5: Main Thread is finishing and daemon will be terminated");
    }

    // Задача 6: создайте 2 потока 1.поток - демон, который 10 раз выводи в консоль "Daemon Thread is running", засыпая
    // на 1 секунду каждый раз. Второй пото должен проделать аналогичную работу, но 5 раз и выводить сообщение
    // "Non Daemon Thread is running" и остановить свое выполнение. В потоке мейн следует проверить, работает ли
    // поток-демон, если да, то остановить его, если нет, то просто закончить работу.

    public void task6() {
        Thread daemonThread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Task 6: Демон-поток выполняется");
                for (int i = 1; i <= 10; i++) {
                    System.out.println("Task 6: Демон-поток - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        Thread nonDaemonThread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Task 6: Обычный поток выполняется");
                for (int i = 1; i <= 5; i++) {
                    System.out.println("Task 6: Обычный поток - " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        daemonThread.setDaemon(true);

        daemonThread.start();
        nonDaemonThread.start();


        while (daemonThread.isAlive()) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Task 6: Главный поток завершает выполнение");
    }
}
