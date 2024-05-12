package streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExample {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 65, 69, 8,55,89,66,84,258,6,5558,1, 7, 8);
        List<Integer> collect = list.stream()
                .filter(i -> i > 5)
                .filter(i -> i % 2 == 0)
                .filter(i -> i % 3 == 0)
                .map(i ->i*3)
                .filter(i -> i * 2 > 60)
                .collect(Collectors.toList());

        System.out.println(collect.toString());
    }
}
