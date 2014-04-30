/**
*Will Barnwell
*CS110 Final Project
*War
nerds use javaDocs
*/
import java.util.ArrayList;
public class WarGame
{
	//Lets write some pseudo code

	//play
		//if p1 has cards in deck
			//flip top card
		//elif p1 has cards in pile
			//shuffle p1 deck and flip top card
		//else p1 loses

		//repeat if-elif-else block for p2

		//compare cards
		//if p1 card > p2 card
			//p1 wins this draw and both cards are added to Winnings and they are marked as winners
		//elif p2 card > p1 card
			//p2 """"""
		//else
			//return a war starter


		//return Winnings AL and a 1 or 2 showing who won or 0 for war

	



	//main
	public static void main(String[] args) 
	{
		//create a deck
		Deck d = new Deck();
		//shuffle it
		d.shuffle();
		//split it in half 
		//call one half player1Deck and the other half player2Deck
		Deck player1Deck = new Deck(d,0,26);
		Deck player2Deck = new Deck(d,26,52);
		
		//debug prints for decks
    	/*int length1=d.cardsRemaining();
    	int length2=player1Deck.cardsRemaining();
    	int length3=player2Deck.cardsRemaining();
      	System.out.println(length1+" "+length2+" "+length3);
		for(int i=0;i<length1;i++)
			System.out.println(d.getCard(i).toString());
		for(int i=0;i<length2;i++)
			System.out.println(player1Deck.getCard(i).toString());
		for(int i=0;i<length3;i++)
			System.out.println(player2Deck.getCard(i).toString());*/
		//end debug prints

		
		
	}
		


}