package practice;

public class DeadlockAvoidanceExample {
    private static final Object lock1 = new Object();
    private static final Object lock2 = new Object();

    public static void doSomething() {
        synchronized (lock1) {
            System.out.println("Lock1 acquired");

            synchronized (lock2) {
                System.out.println("Lock2 acquired");
            }
        }
    }

    public static void doSomethingElse() {
        synchronized (lock1) {
            System.out.println("Lock1 acquired");

            synchronized (lock2) {
                System.out.println("Lock2 acquired");
            }
        }
    }
}
