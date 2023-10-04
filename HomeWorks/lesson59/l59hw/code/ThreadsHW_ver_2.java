package code;

public class ThreadsHW_ver_2 {
    public static void main(String[] args) {

        Thread thread1 = new Thread(new ThreadConstructor("Thread-1", Thread.MIN_PRIORITY)); // prio 1
        Thread thread2 = new Thread(new ThreadConstructor("Thread-2", Thread.NORM_PRIORITY)); // prio 5
        Thread thread3 = new Thread(new ThreadConstructor("Thread-3", Thread.MAX_PRIORITY)); // prio 10

        thread1.start();
        thread2.start();
        thread3.start();
    }
}

class ThreadConstructor implements Runnable {
    private final String name;
    private final int priority;

    public ThreadConstructor(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    @Override
    public void run() {
        while (true) {
            System.out.println(name + ", Priority: " + priority);
        }
    }
}
