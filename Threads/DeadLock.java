package Threads;

public class DeadLock {
    public static final String R1 = "Hello";
    public static final String R2 = "Hi";
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (R1) {
                System.out.println("Thread T1 locked : resource R1");
                synchronized (R2) {
                    System.out.println("Thread T2 locked : resource R2");
                }
            }
        });

        Thread t2 = new Thread(() -> {
            synchronized (R2) {
                System.out.println("Thread T1 locked : resource R1");
                synchronized (R1) {
                    System.out.println("Thread T2 locked : resource R2");
                }
            }
        });

        t1.start();
        t2.start();
    }
}
