
public class Reverse 
{
	public static void reverse(int a[], int size)
	{
		for (int i = 0; i < size/2; i++)
		{
			int temp = a[i];
			a[i] = a[size - 1 - i];
			a[size - 1 - i] = temp;
		}
	}
	
	public static void reverse2(int a[], int size)
	{
		for (int i = 0; i < size; i++)
		{
			int temp = a[i];
			a[i] = a[size - 1 - i];
			a[size - 1 - i] = temp;
		}
	}
}
