package Threads;

class MyThread extends Thread {
    public MyThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread ID : " + getId());
        System.out.println("Thread Name : " + getName());
        System.out.println("Priority : " + getPriority());

        try {
            for(int i=1;i<=5;i++) {
                System.out.println(getName() + " : " + i);
                Thread.sleep(1000);
            }
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class ThreadMethodsDemo {
    public static void main(String[] args) throws InterruptedException {
        MyThread t1 = new MyThread("Producer");
        t1.setPriority(Thread.MAX_PRIORITY);

        MyThread t2 = new MyThread("Consumer");
        t2.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Main Thread Finished");
    }
}