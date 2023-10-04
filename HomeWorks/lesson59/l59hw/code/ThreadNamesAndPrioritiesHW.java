package code;

public class ThreadNamesAndPrioritiesHW {

    public static void main(String[] args) {

        Thread thread1 = new Thread(new AppRun(), "Thread-1");
        Thread thread2 = new Thread(new AppRun(), "Thread-2");
        Thread thread3 = new Thread(new AppRun(), "Thread-3");

        thread1.setPriority(5);
        thread2.setPriority(3);
        thread3.setPriority(8);

        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class AppRun implements Runnable {
        @Override
        public void run() {
            while (true) {
                System.out.println(Thread.currentThread().getName() + ", Priority: " + Thread.currentThread().getPriority());
            }
        }
    }
}
