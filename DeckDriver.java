
import java.util.Scanner;

/**

Ben Kaufman
CS 110 Java
War Card Game

This class uses the deck1 class and the card class to create a 52 card deck arraylist
divide the deck into two separate decks of 26 for two players and then uses the two
decks to play the card game war
*/
public class DeckDriver
{
   
   public static void main(String [] args) 
   {
      
      Deck1 deck = new Deck1();
      Deck1 deck1 = new Deck1();
      Deck1 deck2 = new Deck1();
            
      deck.freshDeck();
      deck.shuffle();
      
      for (int i = 0; i < 26; i++)
      {
         deck1.add(deck.dealCard());
         deck2.add(deck.dealCard());
      }
      
      playWar(deck1, deck2);
       
   }
   
   /**
   The playWar method determines the winner of each round and adds the corresponding cards as well
   as when there is a tie and then creates a war between the two players
   and adds the corresponding cards to the winner.
   */
   public static void playWar(Deck1 d1, Deck1 d2)
   {
   int input;
   int score1;
   int score2;
   
      //play individual rounds until a deck is empty with input and while loop
      Scanner keyboard = new Scanner(System.in);
      
      System.out.println("Enter a number to play a round");
      
      while(!(d1.isEmpty()) && !(d2.isEmpty()))
        {
           input = keyboard.nextInt();
           
           //deal cards for standard rounds
           Card player1_card = d1.dealCard();
           Card player2_card = d2.dealCard();
           
           //if there is a tie deal cards for war round
           if(player1_card.getRank()==player2_card.getRank())
           {
               Card player1_war1 = d1.dealCard();
               Card player2_war1 = d2.dealCard();
               Card player1_war2 = d1.dealCard();
               Card player2_war2 = d2.dealCard();
               Card player1_war3 = d1.dealCard();
               Card player2_war3 = d2.dealCard();
                 
                 //print results of the war dealing
                 System.out.println("War");
                 System.out.println("******");
                 System.out.println("1:"+player1_war1.toString());
                 System.out.println("2:"+player2_war1.toString());
                 System.out.println("1:"+player1_war2.toString());
                 System.out.println("2:"+player2_war2.toString());
                 System.out.println("1:"+player1_war3.toString());
                 System.out.println("2:"+player2_war3.toString());
                 
                 score1 = 0;
                 score2 = 0;
                 
                 //calculate winner and score for war round
                 if(player1_war1.getRank()>player2_war1.getRank())
                 {
                 score1 += 1;
                 }
                 if(player1_war1.getRank()<player2_war1.getRank())
                 {
                 score2 += 1;
                 }
                 if(player1_war2.getRank()<player2_war2.getRank())
                 {
                 score2 += 1;
                 }
                 if(player1_war2.getRank()>player2_war2.getRank())
                 {
                 score1 += 1;
                 }
                 if(player1_war3.getRank()<player2_war3.getRank())
                 {
                 score2 += 1;
                 }
                 if(player1_war3.getRank()>player2_war3.getRank())
                 {
                 score1 += 1;
                 }
                 
                 //display war results
                 System.out.println("Player 1 score:"+score1+" "+"Player 2 score:"+score2);
                 
                 //determine winner of war and add corresponding cards
                 if(score1>score2)
                 {
                 System.out.println("Player 1 wins the war");
                  d1.add(player1_war1);
                  d1.add(player2_war1);
                  d1.add(player1_war2);
                  d1.add(player2_war2);
                  d1.add(player1_war3);
                  d1.add(player2_war3);
                  
                  d1.add(player1_card);
                  d1.add(player2_card);

                  
                  System.out.println("Player 1 has: "+d1.cardsRemaining());
                  System.out.println("Player 2 has: "+d2.cardsRemaining());
                 }
                 else
                 {
                 System.out.println("Player 2 wins the war");
                  d2.add(player1_war1);
                  d2.add(player2_war1);
                  d2.add(player1_war2);
                  d2.add(player2_war2);
                  d2.add(player1_war3);
                  d2.add(player2_war3);
                  
                  d2.add(player1_card);
                  d2.add(player2_card);
   
                  //display the remaining cards in each players deck
                  System.out.println("Player 1 has: "+d1.cardsRemaining());
                  System.out.println("Player 2 has: "+d2.cardsRemaining());

                 }




           }
           
           //determine if a player won a standard round and add corresponding cards
           else if(player1_card.getRank()>player2_card.getRank())
           {
           
           d1.add(player1_card);
           d1.add(player2_card);
           System.out.println("Player 1 wins round");
           }
           else if(player1_card.getRank()<player2_card.getRank())
           {
           d2.add(player1_card);
           d2.add(player2_card);
           System.out.println("Player 2 wins round");

           }
           
           //display the original round
           System.out.println("Original Play");

           System.out.println("Player 1:"+player1_card.toString());
           System.out.println("Player 2:"+player2_card.toString());
           
           System.out.println("Player 1 has: "+d1.cardsRemaining());
           System.out.println("Player 2 has: "+d2.cardsRemaining());
           
           
           }//end while
           
           //determine which player has won and display results
           if(d1.isEmpty())
           {
           System.out.println("Player 1 wins!");
           }
           else
           {
           System.out.println("Player 2 wins!");
           }

   }//end playWar
   
   //allows you to display the contents of the deck
   public static void displayDeck(Deck1 d)
   {
      int i = 0;
      while (!(d.isEmpty()))
         System.out.println(i++ + " : " + d.dealCard().toString());

   }
}