import java.util.Arrays;
import java.util.List;

public class DistinctExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 2, 3, 4, 4);
        numbers.stream()
            .distinct()
            .forEach(System.out::println); // Output: 1, 2, 3, 4
    }
}