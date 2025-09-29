import java.util.Arrays;
import java.util.List;

public class PeekExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack");
        names.stream()
            .peek(System.out::println) // For debugging
            .map(String::toUpperCase)
            .forEach(System.out::println);
    }
}