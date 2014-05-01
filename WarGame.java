/**
*Will Barnwell
*CS110 Final Project
*War
nerds use javaDocs
*/
import java.util.ArrayList;
public class WarGame
{	
	//set card images folder here (will also need to update the path for the card back image in WarGUI)
	final String image_path = "cards/";
	//player Decks
	Deck player1Deck;
	Deck player2Deck;
	//Cards for playing
	Card p1Card;
	Card p2Card;
	//create winnings piles
	ArrayList<Card> p1Winnings = new ArrayList<Card>();
	ArrayList<Card> p2Winnings = new ArrayList<Card>();
	//create neutral winnings Array
	ArrayList<Card> winnings = new ArrayList<Card>();
	//gamestate int default to ongoing play mode
	int gameState=0;
	//roundwinner int
	int roundWinner;
	//status Message
	String statusText = "Will has goofed if you can see this message";


	//Constructor
	public WarGame() 
	{
		//create a deck
		Deck d = new Deck();
		//shuffle it
		d.shuffle();
		//split it in half 
		//call one half player1Deck and the other half player2Deck
		player1Deck = new Deck(d,0,26);
		player2Deck = new Deck(d,26,52);

		statusText = "Welcome to War";
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

	public Card getActiveCard(int player)
	{
		switch(player)
		{
			case 1:
				return p1Card;
			case 2:
				return p2Card;
			default:
				return null;//this is stupid but this will never be called 
		}
	}
	public String getCardImage(int player)
	{
		switch(player)
		{
			case 1:
				return image_path+p1Card.getImageName();
			case 2:
				return image_path+p2Card.getImageName();
			default:
				return image_path+"back.jpg";//this is stupid but this will never be called 
		}
	}
	public int getDeckSize(int player)
	{
		switch(player)
		{
			case 1:
				return player1Deck.cardsRemaining();
			case 2:
				return player2Deck.cardsRemaining();
			default:
				return -1;//this is stupid but this will never be called 
		}
	}
	public int getGameState()
	{
		return gameState;
	}
	public String getStatusText()
	{
		return statusText;
	}
	public boolean hasDeckCards(int player)
	{
		switch(player)
		{
			case 1:
				return !player1Deck.isEmpty();
			case 2:
				return !player2Deck.isEmpty();
			default:
				return true;//this is stupid but this will never be called 
		}
	}

	//Lets write some pseudo code
	//now lets make it real

	//play
	public void play()
	{
		//==========================
		//draw cards
		//==========================
		//if p1 has cards in deck
		if(!player1Deck.isEmpty())
		{
			//flip top card
			p1Card = player1Deck.dealCard();
		}
		//elif p1 has cards in pile
		else if(!p1Winnings.isEmpty())
		{
			//shuffle p1 deck and flip top card
			int l = p1Winnings.size();
			for(int i=0;i<l;i++)
				player1Deck.addCard(p1Winnings.remove(0));
			player1Deck.shuffle();
			p1Card = player1Deck.dealCard();
		}
		//else
		else
		{ 
			//p2 wins
			p2Win();
			
		}

		//repeat if-elif-else block for p2
		//if p1 has cards in deck
		if(!player2Deck.isEmpty())
		{
			//flip top card
			p2Card = player2Deck.dealCard();
		}
		//elif p2 has cards in pile
		else if(!p2Winnings.isEmpty())
		{
			//shuffle p2 deck and flip top card
			int l = p2Winnings.size();
			for(int i=0;i<l;i++)
				player2Deck.addCard(p2Winnings.remove(0));
			player2Deck.shuffle();
			p2Card = player2Deck.dealCard();
		}
		//else
		else
		{ 
			//p1 wins
			p1Win();
		}


		//================================
		//compare cards
		//================================
		//if p1 card > p2 card
		if(p1Card.getRank()>p2Card.getRank())
		{
			//p1 wins this draw and both cards are added to Winnings 
			//and they are marked as winners
			roundWinner=-1;
		}
		//elif p2 card > p1 card
		else if(p2Card.getRank()>p1Card.getRank())
		{
			//p2 wins this draw and both cards are added to Winnings 
			//and they are marked as winners
			roundWinner=1;
		}
		//else
		else//p2Card==p1Card
		{
			//war starter
			roundWinner=0;
		}
		
		statusText = "Player 1 drew "+p1Card.toString()
		+"\nPlayer 2 drew "+p2Card.toString(); 
		//===============================
		//results
		//===============================
		//add cards to winnings
		winnings.add(p1Card);
		winnings.add(p2Card);

		//distribut winnings to winner or process the war
		int len = winnings.size();
		switch(roundWinner)
		{
			case -1:
				statusText+=", Player 1 wins the hand.";
				for (int i=0;i<len;i++) 
				{
					p1Winnings.add(winnings.remove(0));
				}
				break;
			case 1:
				statusText+=", Player 2 wins the hand.";
				for (int i=0;i<len;i++) 
				{
					p2Winnings.add(winnings.remove(0));
				}
				break;
			default://war
				statusText+=", war!";
				winnings.add(player1Deck.dealCard());
				winnings.add(player2Deck.dealCard());
		}

	}
	private void p1Win()
	{
		gameState = -1;
	}
	private void p2Win()
	{
		gameState = 1;
	}
		


		//return Winnings AL and a 1 or 2 showing who won or 0 for war

	
	//methods to implement based on GUI
		//_________
		



	
		


}