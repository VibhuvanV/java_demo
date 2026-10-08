package Threads;

class Message {

    boolean available = false;

    public synchronized void produce() {
        available = true;
        System.out.println("Produced");
        notify();
    }

    public synchronized void consume() {
        while(!available) {
            try {
                wait();
            }
            catch(Exception e) {
            }
        }
        System.out.println("Consumed");
        available = false;
    }
}

public class WaitNotify {
    public static void main(String[] args) {
        Message msg = new Message();
        Thread consumer = new Thread(
                msg::consume);

        Thread producer = new Thread(
                msg::produce);
        consumer.start();
        try {
            Thread.sleep(2000);
        }
        catch(Exception e) {}
        producer.start();
    }
}