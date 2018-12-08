// Fig. 19.20: WordTypeCount.java
// Program counts the number of occurrences of each word in a string
import java.util.*;

public class WordTypeCount
{
   private Map< String, Integer > map;
   private Scanner scanner;

   public WordTypeCount()
   {
      map = new HashMap< String, Integer >(); // create HashMap
      scanner = new Scanner( System.in ); // create scanner
      createMap(); // create map based on user input
      displayMap(); // display map content
   } // end WordTypeCount constructor
   
   // create map from user input
   private void createMap() 
   {
      System.out.println( "Enter a string:" ); // prompt for user input
      String input = scanner.nextLine();

      // create StringTokenizer for input
      StringTokenizer tokenizer = new StringTokenizer( input );
               
      // processing input text 
      while ( tokenizer.hasMoreTokens() ) // while more input 
      {
         String word = tokenizer.nextToken().toLowerCase(); // get word
                  
         // if the map contains the word
         if ( map.containsKey( word ) ) // is word in map
         {
            int count = map.get( word ); // get current count
            map.put( word, count + 1 );  // increment count
         } // end if
         else 
            map.put( word, 1 ); // add new word with a count of 1 to map
       } // end while
   } // end method createMap
   
   // display map content
   private void displayMap() 
   {
      ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());

      Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
         @Override
         public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
            return o2.getValue() - o1.getValue();
         }
      });

      System.out.println( "Map contains:\nKey\t\tValue" );

      Iterator<Map.Entry<String, Integer>> it = list.iterator();

      while(it.hasNext()){
         Map.Entry<String, Integer> current = it.next();
         System.out.printf( "%-10s%10s\n", current.getKey(), current.getValue() );
      }

      System.out.printf(
              "\nsize:%d\nisEmpty:%b\n", map.size(), map.isEmpty() );

   } // end method displayMap

   public static void main( String args[] )
   {
      new WordTypeCount();
   } // end main
} // end class WordTypeCount

