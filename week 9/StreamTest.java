import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamTest {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int sum = list.stream()
                .filter(value -> value % 2 != 0)
                .reduce(0, (x, y) -> x + y);

        System.out.println("The sum of the odd numbers in the list is "
            + sum);
    }
}
