
public class Main {

    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Worker2 worker2 = new Worker2();
        worker.start();
        worker2.start();

        worker.wait();
        worker.join();
        worker2.join();


        System.out.println("Hello world!");

    }
}

class Worker  extends Thread {
    @Override
    public void run() {
        for (int i =0; i < 10; i++) {
            System.out.println("worker 1 " + i  + " "+ Thread.currentThread().getName());

        }
    }
}

class Worker2  extends Thread {
    @Override
    public void run() {
        for (int i =0; i < 10; i++) {
            System.out.println("worker 2 " + i  + " "+ Thread.currentThread().getName());
        }
    }
}