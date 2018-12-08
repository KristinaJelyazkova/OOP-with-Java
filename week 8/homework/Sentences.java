import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.SortedMap;

public class Sentences {
    public static ArrayList<String> sentenceSeparator(String text){
        //String[] sentences = text.split("\\.");
        String[] sentences = text.split("[.?!]+");
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < sentences.length; i++) {
            result.add(sentences[i].trim());
        }

        return result;
    }

    public static ArrayList<String> reverse(ArrayList<String> arr){
        ArrayList<String> result = new ArrayList<>(arr);
        Collections.reverse(result);

        return result;
    }

    public static void print(ArrayList<String> arr){
        Iterator it = arr.iterator();

        while(it.hasNext()){
            System.out.println("Sentence: " + it.next());
        }
    }

    public static void main(String[] args) {
        String text = "About Time is a 2013 British romantic comedy-drama film. "
                + "It is about a young man with the special ability to time travel who tries to change his past in order"
                + " to improve his future! The film was written and directed by Richard Curtis. It stars Domhnall Gleeson, "
                + "Rachel McAdams and Bill Nighy? It was released in the United Kingdom on 4 September 2013.";

        ArrayList<String> arr = sentenceSeparator(text);
        ArrayList<String> reverseArr = reverse(arr);

        print(arr);
        System.out.println();
        print(reverseArr);
    }
}
