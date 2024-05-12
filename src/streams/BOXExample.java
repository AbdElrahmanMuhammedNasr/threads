package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class BOXExample {
    public static void main(String[] args) {
        int  [] numbers = new int[] {1,2,36};
        List<Integer> x = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        System.out.println(x);

    }
}
