/**
 * Arun, John, Maddy
 * Class for the Player
 * Multiple instances of this class will be used depending
 * on the number of players chosen for the game
 */
import java.util.ArrayList;

//All methods necessary for each player of the game
public class Player 
{
    public String name;
    public ArrayList<UnoCard> hand = new ArrayList< UnoCard >();
    
    //Constructor
    public Player(String player_name, ArrayList<UnoCard> player_hand)
    {
        this.name = player_name;
        this.hand = player_hand;
    }
    
    //Second constructor to make testing easier in TextGame
    public Player(int player_number, ArrayList<UnoCard> player_hand)
    {
        this.name = "Player " + player_number;
        this.hand = player_hand;
    }
    
    //Returns HandSize
    public int getHandSize()
    {
        return hand.size();
    }
    
    //Returns the card that exists at the parameter inserted
    public UnoCard getCardAt(int index)
    {
        return hand.get(index);
    }
    
    //For debugging/text-based purposes; prints hand
    public void printHand()
    {
    	int i = 1;
    	
    	for( UnoCard cards : hand)
    	{
    		System.out.print(i + ") ");
    		cards.printCard();
    		i++;
    	}
    }
    
    //Returns Player Name
    public String getPlayerName(Player p)
    {
        return p.name;
    }
    
    //For debugging/text-based purposes; prints name and hand
    public void printNameAndHand()
    {
    	System.out.println(name + " here is your hand:");
    	printHand();
    }
    
    //Changes player name to a new name
    public void setPlayerName(Player p, String newName){
        p.name = newName;
    }
    
    //Returns Hand
    public ArrayList<UnoCard> getHand(Player p){
        return p.hand;
    }
    
    //Driver to test functions
    public static void main(String[] args)
    {
    	CardPool testHand = new CardPool();
    	testHand.generateDeck();
    	
    	Player testPlayer1 = new Player("John", testHand.deck);
    	Player testPlayer2 = new Player(27, testHand.deck);
    	
    	testPlayer1.printHand();
    	System.out.println("\n\n");
    	testPlayer1.printNameAndHand();
    	System.out.println("\n\n");
    	testPlayer2.printNameAndHand();
    	
    }
}
