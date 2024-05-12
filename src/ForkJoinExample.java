import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

class CalculateSum extends RecursiveAction{
    List<Integer> data;
    private static  int sum = 0;
    private static final int THRESHOLD = 2;
    public CalculateSum(List<Integer> data) {
        this.data = data;
    }

    @Override
    protected void compute() {

        if(data.size() > THRESHOLD){
            sum = data.stream()
                    .mapToInt(Integer::intValue)
                    .sum();
        }else {
            CalculateSum calculateSumFirst = new CalculateSum(data.subList(0, THRESHOLD));
            CalculateSum calculateSumSecond = new CalculateSum(data.subList(THRESHOLD, data.size() - 1));

            List<CalculateSum> list = Arrays.asList(calculateSumFirst, calculateSumSecond);
            ForkJoinTask.invokeAll(list);

        }
    }

    public static int getSum() {
        return sum;
    }
}
public class ForkJoinExample  {
    public static ForkJoinPool forkJoinPool = new ForkJoinPool(50);

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        List<Integer> data = new ArrayList<>();
        for(int i = 0; i < 1_000_000_0; i++){
            data.add(i);
        }
        CalculateSum calculateSum = new CalculateSum(data);

//        ForkJoinPool forkJoinPool = new ForkJoinPool();
        forkJoinPool.invoke(calculateSum);
        System.out.println("ForkJoin Sum : " + calculateSum.getSum());
        long end = System.currentTimeMillis();
        System.out.println(end - start + " ms");

    }

}
