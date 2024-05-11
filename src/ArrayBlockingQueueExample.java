import java.util.concurrent.ArrayBlockingQueue;

public class ArrayBlockingQueueExample {

    public static void main(String[] args) {
        ArrayBlockingQueue<Integer> arrayBlockingQueue = new ArrayBlockingQueue(10);

       new Thread(() -> {
           int i = 0;
           while (true){
               try {
                   arrayBlockingQueue.put(++i);
               } catch (InterruptedException e) {
                   throw new RuntimeException(e);
               }
               System.out.println("add " +i);
           }
       }).start();


        new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(5000);
                    Integer peek = arrayBlockingQueue.peek();
                    if(peek % 2 == 0){
                        System.out.println("even value ");
                    }else {
                        System.out.println("odd value ");
                    }
                    System.out.println("return value "+arrayBlockingQueue.take());
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }).start();

    }
}
