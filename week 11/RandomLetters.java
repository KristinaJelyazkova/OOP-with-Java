import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class RandomLetters {
    public static void main(String[] args) {
        Random generator = new Random();
        List<Character> list = new ArrayList<>();

        for (int i = 0; i < 30; i++) {
            list.add((char)('a' + generator.nextInt(26)));
        }

        System.out.println("The letters in the list:");
        list.forEach(letter -> System.out.print(letter + " "));
        System.out.println();

        System.out.println("The sorted list in ascending order:");
        list.stream()
                .sorted()
                .forEach(letter -> System.out.print(letter + " "));
        System.out.println();

        System.out.println("The sorted list in descending order:");
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(letter -> System.out.print(letter + " "));
        System.out.println();

        System.out.println("The sorted list in ascending order with duplicates removed:");
        list.stream()
                .distinct()
                .sorted()
                .forEach(letter -> System.out.print(letter + " "));
        System.out.println();
    }
}
