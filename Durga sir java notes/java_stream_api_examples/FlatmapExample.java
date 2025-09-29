import java.util.Arrays;
import java.util.List;

public class FlatMapExample {
    public static void main(String[] args) {
        List<List<String>> listOfLists = Arrays.asList(
            Arrays.asList("a", "b"),
            Arrays.asList("c", "d")
        );
        listOfLists.stream()
            .flatMap(List::stream)
            .forEach(System.out::println); // Output: a, b, c, d
    }
}