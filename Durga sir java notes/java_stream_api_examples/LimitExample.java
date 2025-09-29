import java.util.stream.Stream;

public class LimitExample {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
            .limit(3)
            .forEach(System.out::println); // Output: 1, 2, 3
    }
}