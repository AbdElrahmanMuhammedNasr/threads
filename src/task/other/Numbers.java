package task.other;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class Numbers {
    public static void main(String[] args) {
        LongStream.rangeClosed(0,1000).boxed().collect(Collectors.toList());
    }
}
