import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

public class MostFrequentElement {
    public static <E> Pair<E, Integer> mostFrequent(ArrayList<E> arr){
        Iterator<E> it = arr.iterator();
        E result = arr.get(0);
        Integer occurrences = Collections.frequency(arr, result);
        Integer currentOccurrences = occurrences;

        while(it.hasNext()){
            E current = it.next();
            currentOccurrences = Collections.frequency(arr, current);

            if(currentOccurrences > occurrences){
                result = current;
                occurrences = currentOccurrences;
            }
        }

        return new Pair<E, Integer>(result, occurrences);
    }

    public static void main(String[] args) {
        int [] elements = {1, 3, 4, 1, 5, 2, 3, 6, 6, 6,
                4, 1, 2, 6, 2, 3, 1, 2, 1, 5, 5, 1, 1, 5, 4};
        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < elements.length; i++) {
            arr.add(elements[i]);
        }

        Pair<Integer, Integer> result = mostFrequent(arr);

        System.out.printf("The most frequent element %d occurs %d times.%n",
               result.getKey(), result.getValue());

        String[] elements2 = {"red", "green", "yellow", "red", "yellow", "yellow",
                "blue", "black", "yellow", "blue", "red", "yellow", "red"};
        ArrayList<String> arr2 = new ArrayList<>();

        for (int i = 0; i < elements2.length; i++) {
            arr2.add(elements2[i]);
        }

        Pair<String, Integer> result2 = mostFrequent(arr2);

        System.out.printf("The most frequent element %s occurs %d times.%n",
                result2.getKey(), result2.getValue());
    }
}
