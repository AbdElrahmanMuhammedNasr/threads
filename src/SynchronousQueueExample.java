import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

public class SynchronousQueueExample {

    public static void main(String[] args) {
        SynchronousQueue<Integer> synchronousQueue = new SynchronousQueue();

       new Thread(() -> {
           int i = 0;
           while (true){
               try {
                   synchronousQueue.put(++i);
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("add " +i);
           }
       }).start();


        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(10000);
                    System.out.println("return value "+synchronousQueue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

        Runnable runnable = () -> {

        };

    }
}
