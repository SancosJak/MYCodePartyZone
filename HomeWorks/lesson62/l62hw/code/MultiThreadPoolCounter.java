package code;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class MultiThreadPoolCounter {
    public static void main(String[] args) {

        AtomicInteger counter = new AtomicInteger(0);
        ExecutorService executorService = Executors.newFixedThreadPool(8);

        for (int i = 0; i < 3; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 5000; j++) {
                    counter.incrementAndGet();
                }
            });
        }

        for (int i = 0; i < 5; i++) {
            executorService.execute(() -> {
                for (int j = 0; j < 3000; j++) {
                    counter.decrementAndGet();
                }
            });
        }

        executorService.shutdown();

        while (!executorService.isTerminated()) {

        }

        assert counter.get() == 0 : "Counter is not zero!";
        System.out.println("Final Counter Value is: " + counter.get());
    }
}
