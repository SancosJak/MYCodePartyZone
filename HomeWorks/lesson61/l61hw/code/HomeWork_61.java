package code;

import java.util.concurrent.atomic.AtomicInteger;

public class HomeWork_61 {

    private static final AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) {

        // Инкрементирующие потоки
        Thread incThread1 = createIncrementingThread(5000);
        Thread incThread2 = createIncrementingThread(5000);
        Thread incThread3 = createIncrementingThread(5000);

        // Декрементирующие потоки
        Thread decThread1 = createDecrementingThread(3000);
        Thread decThread2 = createDecrementingThread(3000);
        Thread decThread3 = createDecrementingThread(3000);
        Thread decThread4 = createDecrementingThread(3000);
        Thread decThread5 = createDecrementingThread(3000);

        // Запуск потоков
        incThread1.start();
        incThread2.start();
        incThread3.start();
        decThread1.start();
        decThread2.start();
        decThread3.start();
        decThread4.start();
        decThread5.start();

        // Дожидаемся завершения потоков
        try {
            incThread1.join();
            incThread2.join();
            incThread3.join();
            decThread1.join();
            decThread2.join();
            decThread3.join();
            decThread4.join();
            decThread5.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        // Выводим финальное значение счетчика
        System.out.println("Final Counter Value: " + counter.get());
    }

    // Метод создания инкрементирующего потока
    private static Thread createIncrementingThread(int incrementTimes) {
//        return new Thread(() -> {
//            for (int i = 0; i < incrementTimes; i++) {
//                counter.incrementAndGet();
//            }
//        });
        return new Thread(() -> counter.addAndGet(incrementTimes));
    }

    // Метод создания декрементирующего потока
    private static Thread createDecrementingThread(int decrementTimes) {
//        return new Thread(() -> {
//            for (int i = 0; i < decrementTimes; i++) {
//                counter.d ecrementAndGet();
//            }
//        });
        return new Thread(() -> counter.addAndGet(-decrementTimes));
    }

}
