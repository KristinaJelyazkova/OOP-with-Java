// Fig. 7.10: DeckOfCards.java
// DeckOfCards class represents a deck of playing cards.
import java.util.Random;

public class DeckOfCards
{
   private Card deck[]; // array of Card objects
   private int currentCard; // index of next Card to be dealt
   private final int NUMBER_OF_CARDS = 52; // constant number of Cards
   private Random randomNumbers; // random number generator

   // constructor fills deck of Cards
   public DeckOfCards()
   {
      String faces[] = { "Ace", "Deuce", "Three", "Four", "Five", "Six", 
         "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King" };
      String suits[] = { "Hearts", "Diamonds", "Clubs", "Spades" };

      deck = new Card[ NUMBER_OF_CARDS ]; // create array of Card objects
      currentCard = 0; // set currentCard so first Card dealt is deck[ 0 ]
      randomNumbers = new Random(); // create random number generator

      // populate deck with Card objects
      for ( int count = 0; count < deck.length; count++ ) 
         deck[ count ] = 
            new Card( faces[ count % 13 ], suits[ count / 13 ] );
   } // end DeckOfCards constructor

   // shuffle deck of Cards with one-pass algorithm
   public void shuffle()
   {
      // after shuffling, dealing should start at deck[ 0 ] again
      currentCard = 0; // reinitialize currentCard

      // for each Card, pick another random Card and swap them
      for ( int first = 0; first < deck.length; first++ ) 
      {
         // select a random number between 0 and 51 
         int second =  randomNumbers.nextInt( NUMBER_OF_CARDS );
         
         // swap current Card with randomly selected Card
         Card temp = deck[ first ];        
         deck[ first ] = deck[ second ];   
         deck[ second ] = temp;            
      } // end for
   } // end method shuffle

   // deal one Card
   public Card dealCard()
   {
      // determine whether Cards remain to be dealt
      if ( currentCard < deck.length )
         return deck[ currentCard++ ]; // return current Card in array
      else        
         return null; // return null to indicate that all Cards were dealt
   } // end method dealCard

    private int[] totalHand(Card hand[]){
        int frequency[] = new int[13];

        for(Card card : hand){
            ++frequency[card.getFace()];
        }

        return frequency;
    }

    private int[] totalHandSuits(Card hand[]){
        int frequency[] = new int[4];

        for(Card card : hand){
            ++frequency[card.getSuit()];
        }

        return frequency;
    }

    private boolean atLeastKOfAKind(Card hand[], int k){
        int frequency[] = totalHand(hand);

        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] >= k){
                return true;
            }
        }

        return false;
    }

    private boolean exactlyKOfASuit(Card hand[], int k){
        int frequency[] = totalHandSuits(hand);

        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] == k){
                return true;
            }
        }

        return false;
    }

    private boolean exactlyKOfAKind(Card hand[], int k){
        int frequency[] = totalHand(hand);

        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] == k){
                return true;
            }
        }

        return false;
    }

    public boolean pair(Card hand[]){
        return atLeastKOfAKind(hand, 2);
    }

    public boolean twoPairs(Card hand[]){
        int frequency[] = totalHand(hand);
        int countPairs = 0;

        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] >= 2){
                if(countPairs == 1){
                    return true;
                }
                countPairs++;
            }
        }

        return false;
    }

    public boolean threeOfAKind(Card hand[]){
        return atLeastKOfAKind(hand, 3);
    }

    public boolean fourOfAKind(Card hand[]){
        return atLeastKOfAKind(hand, 4);
    }

    public boolean flush(Card hand[]){
       return exactlyKOfASuit(hand, 5);
    }

    public boolean straight(Card hand[]){
       int frequency[] = totalHand(hand);
       int countStraight = 0;

        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] >= 1){
                countStraight++;
                if(countStraight == 5){
                    return true;
                }
            }
            else{
                countStraight = 0;
            }
        }

        return (countStraight == 4) && (frequency[0] >= 1);
    }

    public boolean fullHouse(Card hand[]){
        return exactlyKOfAKind(hand, 2) && exactlyKOfAKind(hand, 3);
    }

    public void printHand(Card hand[]){
       for(Card card : hand){
           System.out.println(card);
       }
    }
} // end class DeckOfCards


/**************************************************************************
 * (C) Copyright 1992-2005 by Deitel & Associates, Inc. and               *
 * Pearson Education, Inc. All Rights Reserved.                           *
 *                                                                        *
 * DISCLAIMER: The authors and publisher of this book have used their     *
 * best efforts in preparing the book. These efforts include the          *
 * development, research, and testing of the theories and programs        *
 * to determine their effectiveness. The authors and publisher make       *
 * no warranty of any kind, expressed or implied, with regard to these    *
 * programs or to the documentation contained in these books. The authors *
 * and publisher shall not be liable in any event for incidental or       *
 * consequential damages in connection with, or arising out of, the       *
 * furnishing, performance, or use of these programs.                     *
 *************************************************************************/
