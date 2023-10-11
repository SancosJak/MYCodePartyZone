package code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolShutdownExample {
    public static void main(String[] args) {
        // Создание пула потоков с двумя потоками
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // Отправляем задачи на выполнение
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Task());
        }

        // Завершение выполнения пула потоков после выполнения всех задач
        executorService.shutdown();

        try {
            // Ждем завершения всех задач или таймаута в течение 10 секунд
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                // Принудительное завершение, если пул потоков не завершил работу после таймаута
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            // В случае прерывания пытаемся завершить пул потоков немедленно
            executorService.shutdownNow();
        }
    }

    // Пример задачи для выполнения
    static class Task implements Runnable {
        @Override
        public void run() {
            try {
                // Имитация длительной работы задачи
                Thread.sleep(2000);
                System.out.println("Task executed by " + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                System.out.println("Task interrupted: " + Thread.currentThread().getName());
            }
        }
    }
}
