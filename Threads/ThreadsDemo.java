package Threads;

public class ThreadsDemo {
    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> System.out.println("Thread1 Default constructor"));
        thread1.start();

        Runnable runnable = () -> System.out.println("Implements runnable interface");
        Thread thread2 = new Thread(runnable);
        thread2.start();

        System.out.println("Main Thread");

        Approach1 thread3 = new Approach1();
        thread3.start();

        Thread thread4 = new Thread(new Approach2());
        thread4.start();

        Thread methodRef = new Thread(Approach3::sayHello);
        methodRef.start();
    }
}
