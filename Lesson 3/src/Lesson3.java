
public class Lesson3 
{
	public static void main (String [] args)
	{
		String a = "cat";
		String b = "dog";
		
		//if (a > b)
		//{
		//	do something
		//}
		//this will compare the addresses not the words
		if (a.compareTo(b) > 0)
		{
			System.out.print("yes");
		}
		else System.out.print("no");
	}
}
