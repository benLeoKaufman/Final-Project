import java.util.*;

public class gameClass
{
   private Deck1 deck;
   private Deck1 deck1;
   private Deck1 deck2;
   private int score1;    //hold the score for player 1
   private int score2;    //hold the score for player 2
   private int roundNum = 0;

   private Card player1_card;
   private Card player2_card;
   

   public gameClass()
   {
      //create 3 decks
      deck = new Deck1();   //master deck - will be split between player 1 and 2
      deck1 = new Deck1();  //deck for player 1
      deck2 = new Deck1();  //deck for player 2
      
      deck.freshDeck(); //add all cards to deck
      deck.shuffle();   //shuffle the new deck
      
      
      //deal decks to the 2 players
      for (int i = 0; i < 26; i++)
      {
         deck1.add(deck.dealCard());
         deck2.add(deck.dealCard());
      }
   }
   
   /**
      The playWar method determines the winner of each round.  After each rounnd
      it then adds the corresponding cards to the winners deck.  When there is a
      tie there is a war between players 1 and 2
   */
   public void playWar()
   {
      String input;
      //play the game until on of the 2 decks are empty
      //deal cards for standard rounds
      player1_card = deck1.dealCard();
      player2_card = deck2.dealCard();
        
      //if there is a tie deal cards for war round
      if(player1_card.equals(player2_card))
      {
         System.out.println("I choose to declare a war upon thee!");
      
         Card player1_war1 = deck1.dealCard();
         Card player1_war2 = deck1.dealCard();
            
         Card player2_war1 = deck2.dealCard();
         Card player2_war2 = deck2.dealCard();
                           
            

              
         //print results of the war dealing

         System.out.println("1:" + player1_war1.toString());
         System.out.println("1:" + player1_war2.toString());

         System.out.println("2:" + player2_war1.toString());
         System.out.println("2:" + player2_war2.toString());

           
         score1 = 0;
         score2 = 0;
              
         //calculate winner and score for war round
         if(player1_war2.getRank() > player2_war2.getRank())
         {
              score1 += 1;
         }
         if(player1_war2.getRank() < player2_war2.getRank())
         {
              score2 += 1;
         }
              
         //display war results
         System.out.println("Player 1 score: " + score1 + " " + "Player 2 score: " + score2);
              
         //determine winner of war and add corresponding cards
         if(score1 > score2)
         {
               System.out.println("Player 1 wins the war");
               deck1.add(player1_war1);
               deck1.add(player2_war1);
               deck1.add(player1_war2);
               deck1.add(player2_war2);
               
               deck1.add(player1_card);
               deck1.add(player2_card);

               
               System.out.println("Player 1 has: "+deck1.cardsRemaining());
               System.out.println("Player 2 has: "+deck2.cardsRemaining());
         }
         else
         {
               System.out.println("Player 2 wins the war");
               deck2.add(player1_war1);
               deck2.add(player2_war1);
               deck2.add(player1_war2);
               deck2.add(player2_war2);
               
               deck2.add(player1_card);
               deck2.add(player2_card);

               //display the remaining cards in each players deck
               System.out.println("Player 1 has: " + deck1.cardsRemaining());
               System.out.println("Player 2 has: " + deck2.cardsRemaining());

          }
        }
        
        //determine if a player won a standard round and add corresponding cards
        else if(player1_card.getRank() > player2_card.getRank())
        {
           deck1.add(player1_card);
           deck1.add(player2_card);
           System.out.println("Player 1 wins round");
        }
        else if(player1_card.getRank() < player2_card.getRank())
        {
           deck2.add(player1_card);
           deck2.add(player2_card);
           System.out.println("Player 2 wins round");
        }
        
        //display the original round
        System.out.println("Cards:");
        System.out.println("Player 1:"+player1_card.toString());
        System.out.println("Player 2:" + player2_card.toString());       
        System.out.println("Player 1 has: " + deck1.cardsRemaining());
        System.out.println("Player 2 has: " + deck2.cardsRemaining()); 
         roundNum+=1;
   }//end playWar   
   
   
   public int getRoundNum()
   {
      return roundNum;
   }
   
   public void getWinner()
   {
     //determine which player has won and display results
     if(deck1.cardsRemaining() > deck2.cardsRemaining())
     {
        System.out.println("Player 1 wins after " + roundNum + " rounds!");
     }
     else if (deck1.cardsRemaining() < deck2.cardsRemaining())
     {
        System.out.println("Player 2 wins after " + roundNum + " rounds!");
     }
     else
     {
         System.out.println("Did you even play?");
         System.out.println("Exiting...");
     }

   }
   
   public int getDeck1Size()
   {
      return deck1.cardsRemaining();
   }

   public int getDeck2Size()
   {
      return deck2.cardsRemaining();
   }
}