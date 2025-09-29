import java.util.stream.Stream;

public class SkipExample {
    public static void main(String[] args) {
        Stream.of(1, 2, 3, 4, 5)
            .skip(2)
            .forEach(System.out::println); // Output: 3, 4, 5
    }
}