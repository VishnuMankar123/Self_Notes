import java.util.Arrays;
import java.util.List;

public class AnyMatchExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Alice", "Bob", "Charlie");
        boolean hasA = names.stream().anyMatch(name -> name.startsWith("A"));
        System.out.println(hasA); // Output: true
    }
}