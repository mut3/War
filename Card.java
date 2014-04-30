//Will Barnwell
//CS 142
//Week 5
//Card

/**
This class represents one playing card from a 52 card deck
*/

public class Card
{
	//public constants
	public static final int SPADES = 1, CLUBS = 2, HEARTS = 3, DIAMONDS = 4, ACE = 1, JACK = 11, QUEEN = 12, KING = 13;

	//private variables
	private int rank, suit;
	private String imageName;

	//constructor takes in ints for suit and rank and sets them
	public Card(int inputSuit, int inputRank)
	{
		rank = inputRank;
		suit = inputSuit;

		imageName =""+suit + rank +".jpg";
	}

	//methods
	public int getSuit()
	{
		return suit;
	}

	public int getRank()
	{
		return rank;
	}

	public String getImageName()
	{
		return imageName;
	}

	public String toString()
	{
		String returnStr, rankStr, suitStr;

		switch(suit)
		{
			case SPADES:
				suitStr = "SPADES";
				break;
			case CLUBS:
				suitStr = "CLUBS";
				break;
			case HEARTS:
				suitStr = "HEARTS";
				break;
			case DIAMONDS:
				suitStr = "DIAMONDS";
            break;
         default:
            suitStr = "null";
		}

		switch (rank) 
		{
			default:
				rankStr = Integer.toString(rank);
				break;
			case ACE:
				rankStr = "ACE";
				break;
			case JACK:
				rankStr = "JACK";
				break;
			case QUEEN:
				rankStr = "QUEEN";
				break;
			case KING:
				rankStr = "KING";
				break;
		}

		returnStr = rankStr + " of " + suitStr;
		return returnStr;

	}

	public Boolean equals(Card otherCard)
	{
		if(rank==otherCard.getRank() && suit==otherCard.getSuit())
		{
			return true;
		}
		else
		{
			return false;
		}
	}


}