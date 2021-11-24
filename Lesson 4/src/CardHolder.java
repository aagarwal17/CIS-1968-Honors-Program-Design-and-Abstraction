import java.util.Random;

/**
 * Arun Agarwal Card Holder
 * @author aruna
 *
 */
public class CardHolder 
{
	private static final int SHUFNUM = 1000;
	//now that this final, it cannot be changed; you should now never see it on the lefthand
	//side of a statement (because this would be changing its value). Constants like this
	//are written in all caps by convention
	private Card[] theCards;
	private int numCards;
	private int size;
	String suit;
	
	public CardHolder(int size, boolean fill)
	{
		this.theCards = new Card[size];
		this.size = size;
		this.numCards = 0;
		if (fill)
		{
			for (int i = 0; i < 52; i++)
			{
				int v = i % 13 + 1;
				int s = i/13;
				if (s==0)
				{
					suit = "Clubs";
				}
				else if (s==1)
				{
					suit = "Diamonds";
				}
				else if (s==2)
				{
					suit = "Hearts";
				}
				else
				{
					suit = "Spades";
				}
				this.theCards[i] = new Card(v, suit);
				this.numCards++;
			}
		}
	}
	
	//public CardHolder()
	//{
	//	
	//}
	
	public int getNumCards ()
	{
		return this.numCards;
	}
	
	public void shuffle ()
	{
		Random ran = new Random(); //ran is a memory cell that can hold an instance of the Random class
		int where;
		Card temp;
		for(int i = 0; i < numCards; i++)
		{
			where = ran.nextInt(52);
			temp = this.theCards[0];
			this.theCards[0] = this.theCards[where];
			this.theCards[where] = temp;
		}
	}
	
	public Card getCardFromHolder() throws CardHolderException
	{
		if (this.numCards < 1)
		{
			throw new CardHolderException("Attempt to get card from empty CardHolder");
		}
		Card retval = this.theCards[0];
		this.numCards--;
		for (i = 0; i < numCards; i++)
		{
			this.theCards[i]= this.numCards[i+1];
		}
		return retval;
	}
	
	public void putCardIntoHolder (Card c) throws CardHolderException
	{
		if(numCards == this.size)
		{
			throw new CardHolderException("Too many cards.");
		}
		this.theCards[numCards] = c;
		this.numCards++;
		
	}
	
	public String toString()
	{
		String retval = "";
		for (int i = 0; i < this.howMany; i++)
		{
			retval += this.theCards[i] + "\n";
		}
		return retval;
	}
	
	public static void main (String [] args) throws CardHolderException
	{
		CardHolder deck = new CardHolder(52, true);
		System.out.println(deck);
		deck.shuffle();
		System.out.println(deck);
		
	}
}
