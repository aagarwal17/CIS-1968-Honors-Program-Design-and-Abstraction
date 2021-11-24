import java.util.Scanner;

public class Hirel 
{
	public static void main (String [] args)
	{
		Scanner kb = new Scanner (System.in);
		String names[] = new String[10];
		int sp = 0;
		boolean done = false;
		int key;
		
		while (!done)
		{
			System.out.print("Enter 1 to hire, 2 to fire, 3 to quit:");
			key = kb.nextInt();
			kb.nextLine();
			if(key == 1)
			{
				System.out.print("What is the name of the new hire:");
				names[sp] = kb.nextLine();
				sp++;
			}
			else if (key == 2)
			{
				sp--;
				System.out.println("Firing " + (names[sp]));
			}
			else if (key == 3)
			{
				done = true;
			}
			else
			{
				System.out.println("Illegal command!");
			}
		}
	}
}
