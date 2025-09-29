import java.util.Arrays;
import java.util.List;

public class SortedExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Alice", "Bob");
        names.stream()
            .sorted()
            .forEach(System.out::println); // Output: Alice, Bob, John
    }
}