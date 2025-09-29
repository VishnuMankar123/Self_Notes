import java.util.Arrays;
import java.util.List;

public class NoneMatchExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Bob", "Charlie", "David");
        boolean noneStartWithA = names.stream().noneMatch(name -> name.startsWith("A"));
        System.out.println(noneStartWithA); // Output: true
    }
}