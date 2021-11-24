//Arun Agarwal 
//CIS 1968
//Add two numbers from the user

import java.util.Scanner;

public class Addtwo 
{

	public static void main(String[] args) 
	{
		int num1, num2;
		int sum;
		Scanner kb = new Scanner(System.in);
		
		System.out.print("Enter an integer");
		num1 = kb.nextInt();
		System.out.print("Enter another integer");
		num2 =  kb.nextInt();
		
		sum = num1 + num2;
		System.out.println("The sum of " + num1 + " and " + num2 + " is " + sum);

	}

}
