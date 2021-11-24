//Arun Agarwal Lab2 Main Program 2/1/2020
import java.util.Scanner;

public class Main 
{
	public static void main(String [] args)
	{
		Scanner kb =  new Scanner(System.in);
		int saleValues[] = new int[12];
		String months[] = new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		int value = 0;
		for (int i=0; i < 12; i++)
		{
		  	System.out.print("Please type in a sales value for " + months[i] + " (integers only): $");
			value = kb.nextInt();
			saleValues[i] = value;
		}

		int highestValue = 0;
		for (int k = 0; k < 12; k ++)
		{
			if (saleValues[k] > highestValue)
			{
				highestValue = saleValues[k];
			}
		}	
		System.out.print("Your array: ");
		for(int j=0; j < 12; j++)
		 {
			  if (j == 0)
				  System.out.print(saleValues[j]);
			  else
				  System.out.print(", " + saleValues[j]);
			 
		 }
		System.out.println();
		Screen myScreen = new Screen(136, 108, ' ');
		

		myScreen.drawText(61,0,"Monthly Sales");
		myScreen.vLine(1, 1, 104, '|');
		myScreen.hLine(2, 135, 104, '_');
		
		int xMove = 2;
		for (int m = 0; m < saleValues.length; m++)
		{
			double ratio = (double) saleValues[m]/highestValue;
			int y = 103 - (int)(ratio * 100);
			myScreen.drawRect(xMove + 1, 103, xMove + 10, y, '+');
			myScreen.fillRect(xMove + 2, y + 1, xMove + 9, 102, '.');
			myScreen.drawText(xMove + 4, y - 1, "$" + saleValues[m]);
			xMove += 11;
		}
		
		myScreen.drawText(4, 105, "January    February     March     April       May        June       July      August   September   October    November   December");
		myScreen.drawText(4, 107, "                                                             Month");
		
		System.out.println(myScreen);
		
		
	}
	
}
