import java.util.ArrayList;
import java.util.Random;

/** 
Java Docs are for nerds.
This is an arrayList based Deck Class which guess what, creates a deck of Card objects
*/


public class Deck 
{
   

   ArrayList<Card> deck;
   //creates a brand new 52 card deck
   public Deck()
   {
      final int CARDS_IN_DECK = 52;
            freshDeck();
   }
   public Deck(Deck otherDeck)
   {
      int length = otherDeck.cardsRemaining();
      deck = new ArrayList<Card>();
      for(int i=0;i<length;i++)
         deck.add(otherDeck.getCard(i));

   }
   //Takes a pre-existing Deck and creates a smaller deck using the index from-to
   public Deck(Deck ogDeck, int indFrom, int indTo)
   {
      final int CARDS_IN_DECK = indTo-indFrom;
      Deck sourceDeck = new Deck(ogDeck);
      int length = sourceDeck.cardsRemaining();
      //debug prints
      System.out.println(length);
      System.out.println(CARDS_IN_DECK);
      //end debug
      deck = new ArrayList<Card>();
      
      for(int i=0;i<indFrom && i<=length;i++)
         sourceDeck.dealCard();
      for(int i=0;i<CARDS_IN_DECK;i++)
         deck.add(sourceDeck.dealCard());
   }

   public void freshDeck()
   {
      deck = new ArrayList<Card>();
      

      for (int r = Card.ACE; r<=Card.KING;r++)
      {
         for (int s=Card.SPADES;s<=Card.DIAMONDS;s++)
         {
           deck.add(new Card(s,r));
         }
      }
      System.out.println(deck.size());
     
   
   }
   public Card dealCard()
   {
      Card c = deck.remove(0);  //  remove it (returns removed object)
      return c;
   }
   public Card getCard(int i)
   {
      Card c = deck.get(i);
      return c;
   }
   public int cardsRemaining()
   {  
      return deck.size();
   }
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
   public boolean isEmpty()
   {
      return (deck.size() == 0);
   }
   // by rank only
   /*public static void main(String [] args) 
   {
      Deck deck = new Deck();
      deck.shuffle();
      int i = 0;
//      while (deck.cardsRemaining() > 0)
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.dealCard().toString());
      System.out.println(deck.cardsRemaining());
      deck.freshDeck();
      while (!(deck.isEmpty()))
         System.out.println(i++ + " : " + deck.dealCard().toString());
         
      Card c1 = new Card(Card.ACE,Card.HEARTS);
      Card c2 = new Card(Card.JACK,Card.SPADES);
      Card c3 = new Card(4,Card.HEARTS);
      
      System.out.println(highCard(c1,c2,c3));
      

   }*/
   public static Card highCard(Card...cards)
   {
   
      Card high = cards[0];
      for (int i=1;i<cards.length;i++)
      {
         if (cards[i].getRank() > high.getRank())
         {
         
            high = cards[i];
         }
      }
      return high;
   
   }
}

