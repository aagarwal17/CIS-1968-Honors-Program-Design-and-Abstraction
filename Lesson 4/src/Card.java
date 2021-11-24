/**
 * Arun Agarwal
 * Card Class
 * @author aruna
 *
 */
public class Card 
{
	private int value;
	private char suit;
	private static String names [] = {"Joker", "Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten",
	"Jack", "Queen", "King"};
	//by using the word static, there is no only one reference to names, rather than making an array names for each created card
	
	
	public Card (int v, char s) throws IllegalArgumentException
	{
		if (v < 1 || v > 13)
		{
			//System.err.println("Illegal value " + v);
			//System.exit(1);
			throw new IllegalArgumentException("Illegal card value " + v);
		}
		
		this.value = v;
		
		if (s == 'c')
			s = 'C';
		if (s == 'd')
			s = 'D';
		if (s == 'h')
			s = 'H';
		if (s == 's')
			s = 'S';
		if (s != 'C' && s != 'D' && s != 'H' && s != 'S') 
		{
			System.err.println("Illegal suit " + s);
			System.exit(1);
		}

		this.suit = s;
	}
	
	public String toString()
	{
		String s = "";
		if(this.suit == 'C')
			s = "Clubs";
		if(this.suit == 'D')
			s = "Diamonds";
		if(this.suit == 'H')
			s = "Hearts";
		if(this.suit == 'S')
			s = "Spades";
		
		return "The " + this.names[this.value] + " of " + s;
	}
	
	public int getValue()
	{
		return this.value;
	}
	
	public char getSuit()
	{
		return this.suit;
	}
	
	public int compareTo(Card rhs)
	{
		return this.value - rhs.value;
	}
	
	public static void main(String [] args) throws IllegalArgumentException //do not need to throw this AND have try/catch
	{
		Card c1 = new Card(10, 'D');
		Card c2 = new Card(12, 'H');
		//Card c3;
		//try
		//{
		//	c3 = new Card(99, "Diamonds");
		//}
		//catch (IllegalArgumentException e)
		//{
		//	System.out.println("Illegal value for card");
		//	c3 = new Card(1, "Spades");
		//}
		System.out.println("Your cards are " + c1 + ", and "  + c2);
	}
}
