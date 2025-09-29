import java.util.Arrays;
import java.util.List;

public class FilterExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie", "David");
        names.stream()
            .filter(name -> name.startsWith("A"))
            .forEach(System.out::println); // Output: Alice
    }
}