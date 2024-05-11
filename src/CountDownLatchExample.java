import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Processor extends Thread {
    private int delay;
    private CountDownLatch latch;
    public Processor(int delay, CountDownLatch latch){
        this.delay = delay;
        this.latch = latch;
    }

    @Override
    public void run(){
        try{
            System.out.println("thread "+Thread.currentThread().getName()+" is running");
            Thread.sleep(delay);
            if(new Random().nextInt(1,10) >5 ){
                throw new RuntimeException("error");
            }
            latch.countDown();
            System.out.println(latch.getCount()+" "+Thread.currentThread().getName()+ " finished "+delay);
        }
        catch (Exception e){
            System.out.println(e.getMessage() + " interrupted");
        }finally {
            System.out.println("===================================================================");
        }
    }
}
public class CountDownLatchExample {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            executorService.submit(new Processor(new Random().nextInt(1000,6000), countDownLatch));
        }
        countDownLatch.await();
        executorService.shutdown();
        System.out.println("count ------------> "+countDownLatch.getCount());
        System.out.println("all task down i can run now");
    }
}
