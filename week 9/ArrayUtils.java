import java.util.Random;
import java.util.function.Predicate;

public class ArrayUtils {
    static void filterNumbers(Predicate<Integer> condition, int[] array){
        for (int i = 0; i < array.length; i++) {
            if(condition.test(array[i])){
                System.out.print(array[i] + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] numbers= new int[20];
        Random generator = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = generator.nextInt(41) + 10;
            System.out.print(numbers[i] + " ");
        }
        System.out.println();

        Predicate<Integer> even = x -> x % 2 == 0,
                biggerThan30 = x -> x >= 30,
                lessThan40 = x -> x <= 40,
                inInterval = biggerThan30.and(lessThan40),
                prime = x -> {
                    if(x == 1){
                        return false;
                    }
                    for(int i = 2; i < Math.ceil(Math.sqrt(x)) + 1; i++){
                        if(x % i == 0){
                            return false;
                        }
                    }
                    return true;
                };

        filterNumbers(even, numbers);
        filterNumbers(inInterval, numbers);
        filterNumbers(prime, numbers);
    }
}
