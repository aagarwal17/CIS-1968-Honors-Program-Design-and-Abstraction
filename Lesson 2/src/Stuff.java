//Arun Agarwal

import java.util.Scanner;

public class Stuff 
{
	
	
	public static void main(String[] args) 
	{
		Scanner in = new Scanner(System.in);
		int n;
		System.out.print("How many lights? ");
		n = in.nextInt();
		boolean lights[];
		//lights currently contains the value null
		lights = new boolean[n+1];
		for (int i = 0; i < n + 1; i++)
		{
			lights[i] = false;
		}
		for (int pass = 1; pass <= n; pass++)
		{
			for (int i = 1; i <= n; i++)
			//i represents which light gets turned on; it represents each light, and the ones that get switched are the ones that are divisible by the pass number
			{
				if (i % pass == 0)
				{
					lights[i] = !lights[i];
				}
			}
		}
		for (int i = 1; i <= n; i++)
		//i++ increment after i; ++i increment before i
		{
			if(lights[i])
			{
				System.out.print("on ");
			}
			else
			{
				System.out.print("off ");
			}
		}
		System.out.println();
	}

}
