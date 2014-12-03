
import java.util.Random;
import java.util.ArrayList;

/**

Ben Kaufman
CS 110 Java
War Card Game

this class creates the arraylist deck object 
and has methods that allow you to add remove and shuffle
card objects in a deck arraylist as well as return the 
arraylists size and whether or not its empty
*/
public class Deck1 
{
   final int CARDS_IN_DECK = 52;
   int current_card_count = 0;
   ArrayList<Card> deck;
   
   /**
   initializes the deck arraylist
   */
   public Deck1()
   {
      deck = new ArrayList<Card>();

   }
   
   /**
   Loads the deck arraylist with all of the card objects
   */
   public void freshDeck()
   {
            
      deck = new ArrayList<Card>();
      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.CLUBS;s++)
         {
           deck.add(new Card(r,s));
         }
      }
     
   
   }
   /**
   Adds a card object to a deck arraylist
   */
   public void add(Card c)
   {
      deck.add(c);
   }
   /**
   Removes a card object from an deck arraylist
   */
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   /**
   returns the number of objects remaining in a deck arraylist object
   */
   public int cardsRemaining()
   {  
      return deck.size();
   }
   /**
   shuffles the card objects in a deck arraylist
   */
   public void shuffle()
   {
      int randNum;
      Card temp;
      Random r = new Random();
      for (int i = 0; i < deck.size(); i++)
      {
         randNum = r.nextInt(deck.size());
         temp = deck.get(i);
         deck.set(i,deck.get(randNum));
         deck.set(randNum,temp);
      }      
   }
   /**
   returns true if there are no remaining card objects in a deck arraylist
   */
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }

}

