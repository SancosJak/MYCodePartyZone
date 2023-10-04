package practice;

public class TeacherCode_59_3 {
    public static void main(String[] args) {

        System.out.println(Thread.currentThread().getName());
        Thread.currentThread().setPriority(8);

        Thread thread = new Thread() {
            public void run() {
                Thread.currentThread().setName("My name");
                System.out.println(Thread.currentThread().getName());
                System.out.println(Thread.currentThread().getPriority());
            }
        };
        thread.start();
        System.out.println(thread.getName());
        Thread.currentThread().setName("Super Main");
        System.out.println(Thread.currentThread().getName());
    }
}
