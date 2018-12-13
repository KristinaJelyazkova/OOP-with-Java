import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest {
    public static void main(String[] args) {
        List<String> list = Stream.of("aBc", "d", "ef", "123456")
                .map(String::toUpperCase)
                .sorted()
                .collect(Collectors.toList());

        list.forEach(x -> System.out.print(x + " "));
        System.out.println();
    }
}
