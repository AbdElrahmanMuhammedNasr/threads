import java.util.ArrayList;
import java.util.List;

public class NormalSum {
    public static void main(String[] args) {
        long start2 = System.currentTimeMillis();
        List<Integer> data2 = new ArrayList<>();
        for(int i = 0; i < 1_000_000_0; i++){
            data2.add(i);
        }

        int sum2 = data2.stream()
                .mapToInt(Integer::intValue)
                .sum();
        System.out.println("normal : " + sum2);
        long end2 = System.currentTimeMillis();
        System.out.println(end2 - start2 + " ms");
    }
}
