import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;


public class ExecutorServiceExample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(1);
        for (int i = 0; i < 5; i++) {
            executor.submit(() -> {
                System.out.println("Task " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();

        System.out.println("Main thread is waiting for the executor to finish...");
//        ScheduledExecutorService executor1 = Executors.newScheduledThreadPool(2);
//        executor1.schedule(() -> System.out.println("Task executed after 3 seconds"), 3, TimeUnit.SECONDS);
//        executor1.scheduleAtFixedRate(() -> System.out.println("Task executed every 1 second"), 0, 1, TimeUnit.SECONDS);
//        executor1.shutdown();
    }
}
