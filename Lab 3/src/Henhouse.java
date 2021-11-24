import java.util.Random;

//Arun Agarwal Math Concepts Lab 3
public class Henhouse 
{
	public static void main (String [] args) throws InterruptedException
	{
		
		Random ran = new Random();
		Chicken chickens[] = new Chicken[10]; //Creates the array

		for(int i = 0; i < 10; i++)
		{
		  char g;
		  if(ran.nextBoolean())
		  {
		    g = 'F';
		  }
		  else
		  {
		    g = 'M';
		  }
		  chickens[i] = new Chicken("Chicken"+ i, ran.nextInt(3) + 1, g);
		  System.out.println(chickens[i]);
		}
		boolean done = false;
	
		while(!done)
		{
			Chicken currentChicken = chickens[ran.nextInt(9)];
			int num = ran.nextInt(5);
			if (num == 0)
			{
				currentChicken.cluck();
			}
			else if (num == 1)
			{
				currentChicken.eat();
			}
			else if (num == 2)
			{
				currentChicken.fly();
			}
			else if (num == 3)
			{
				currentChicken.layEgg();
			}
			else if (num == 4)
			{
				currentChicken.scratch();
			}
			else
			{
				currentChicken.sleep();
			}
			Thread.sleep(1000);
			
		}
	}
}
