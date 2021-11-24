
public class War 
{
	public static void main(String [] args)
	{
		Scanner kb = new Scanner(System.in);
		int numWars = 0;
		int numWins1 = 0;
		int numWins2 = 0;
		int numTies = 0;
		int winner;
		
		int numGames;
		System.out.println("How many games do you want to play?: ");
		numGames = kb.nextInt();
		
		for (int i = 0; i < numGames; i++)
		{
			winner = doWar();
			if (winner == 1)
			{
				numWins1++;
			}
			else if (winner == 2)
			{
				numWins2++;
			}
			else if (winner == 0)
			{
				numTies = 0;
			}
		}
	}
}
