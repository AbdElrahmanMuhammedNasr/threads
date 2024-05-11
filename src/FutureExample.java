import java.util.concurrent.*;
public class FutureExample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        Future<Integer> future = executor.submit(new Callable<Integer>() {
            public Integer call() throws Exception {
                Thread.sleep(5000);
                return 42;
            }
        });
        System.out.println("Other tasks running...");
//        future.cancel(true);

        System.out.println(future.isDone());
        int result = future.get();
        System.out.println(future.isDone());
        System.out.println("Computation result: " + result);
        executor.shutdown();
    }
}