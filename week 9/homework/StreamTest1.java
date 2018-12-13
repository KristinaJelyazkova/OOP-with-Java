import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest1 {
    public static void main(String[] args) {
        IntStream.range(1, 101)
                .mapToObj(Integer::toString)
                .reduce((x, y) -> x + "#" + y)
                .ifPresent(System.out::println);

        System.out.println();

        Random generator = new Random();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            list.add(generator.nextInt(31));
        }

        Supplier<Stream<Integer>> streamSupplier = () -> list.stream();

        streamSupplier.get()
                .forEach(System.out::println);

        System.out.println();

        boolean isDivBy5 =
                streamSupplier.get()
                .anyMatch(x -> x % 5 == 0);

        System.out.printf("There is %s number divisible by 5 in the list.%n%n",
                isDivBy5 ? "a" : "no");

        boolean areLessThan15 =
                streamSupplier.get()
                .allMatch(x -> x < 15);

        System.out.printf("%sll numbers are less than 15.%n%n",
                areLessThan15 ? "A" : "Not a");

        double average =
                streamSupplier.get()
                .mapToInt(x -> x)
                .average()
                .orElse(1);

        System.out.printf("The average of the numbers is %.2f.%n%n",
                average);

        long greaterThanAverage =
                streamSupplier.get()
                .filter(x -> x > average)
                .count();

        System.out.printf("The numbers greater than the average are %s than 5.%n",
                greaterThanAverage > 5 ? "more" : "not more");
    }
}
