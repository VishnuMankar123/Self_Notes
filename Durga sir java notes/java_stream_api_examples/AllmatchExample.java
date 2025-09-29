import java.util.Arrays;
import java.util.List;

public class AllMatchExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Apple", "Ape", "Ant");
        boolean allStartWithA = names.stream().allMatch(name -> name.startsWith("A"));
        System.out.println(allStartWithA); // Output: true
    }
}