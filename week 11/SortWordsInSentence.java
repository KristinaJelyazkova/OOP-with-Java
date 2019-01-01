import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class SortWordsInSentence {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String sentence = in.nextLine();
        String[] words = sentence.split(" ");

        Stream.of(words)
                .map(String::toLowerCase)
                .distinct()
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}
