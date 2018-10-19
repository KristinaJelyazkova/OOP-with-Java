// Fig. 7.11: DeckOfCardsTest.java
// Card shuffling and dealing application.

public class DeckOfCardsTest
{
   // execute application
   public static void main( String args[] )
   {
      DeckOfCards myDeckOfCards = new DeckOfCards();
      myDeckOfCards.shuffle(); // place Cards in random order

      final int CARD_COUNT = 5;
      Card hand[] = new Card[CARD_COUNT];

      // deal 5 cards
      for (int i = 0; i < hand.length; i++) {
         hand[i] = myDeckOfCards.dealCard();
      }

      /* Straight test:
      hand[0] = new Card("Three", "Diamonds");
      hand[1] = new Card("Four", "Spades");
      hand[2] = new Card("Five", "Diamonds");
      hand[3] = new Card("Six", "Clubs");
      hand[4] = new Card("Seven", "Hearts");*/

      /*Full house test:
       hand[0] = new Card("Three", "Diamonds");
       hand[1] = new Card("Four", "Diamonds");
       hand[2] = new Card("Four", "Diamonds");
       hand[3] = new Card("Three", "Diamonds");
       hand[4] = new Card("Three", "Diamonds");*/

      myDeckOfCards.printHand(hand);

      boolean flush = myDeckOfCards.flush(hand),
              straight = myDeckOfCards.straight(hand);
      if(straight && flush){
          System.out.println("Straight flush!");
          return;
      }

      if(myDeckOfCards.fourOfAKind(hand)){
          System.out.println("Four of a kind!");
          return;
      }

      if(myDeckOfCards.fullHouse(hand)){
          System.out.println("Full House!");
          return;
      }

      if(flush){
          System.out.println("Flush!");
          return;
      }

       if(straight){
           System.out.println("Straight!");
           return;
       }

       if(myDeckOfCards.threeOfAKind(hand)){
           System.out.println("Three of a kind!");
           return;
       }

       if(myDeckOfCards.twoPairs(hand)){
           System.out.println("Two pairs!");
           return;
       }

       if(myDeckOfCards.pair(hand)){
           System.out.println("Pair!");
           return;
       }

       System.out.println("High card!");
   } // end main
} // end class DeckOfCardsTest


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
