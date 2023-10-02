package practice;

public class TeacherCode_58 {
    public static void main(String[] args) {
        // создаем два экземпляра класса MyThread
        // вся основная логика заключается в методе run()
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();
        // в случае если мы запустим выполнение потоков при помощи run(), то выполнение будет находиться
        // в основном потоке и о параллелизме не может быть и речи, втортой поток(myThread2) не начнет свою работу,
        // пока нре выполнит всю логику из метода run();
//        myThread1.run();
//        myThread2.run();
        // для запуска потоков парралельно следует обратиться к методу start(), этот метод создает отдельный поток
        // выполнения, который не зависит от других потоков и не будет жрать выполнения работы какого-либо потока
//        myThread1.start();
//        myThread2.start();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Runnable + " + i);
                    try {
                        Thread.sleep(300);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        };
        myThread1.start();
        myThread2.start();
        r.run();
        // пример использования конструктора класса Thread, который в качестве аргумента принимает экземрляр
        // интерфейса Runnable
        Thread thread1 = new Thread(r);
        // использование анонимного интерфейса в качестве аргумента клсса Thread:
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    System.out.println("Thread + " + i);
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });

        thread1.start();
        thread2.start();
    }
    static class MyThread extends Thread {
        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println("MyThread + " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
