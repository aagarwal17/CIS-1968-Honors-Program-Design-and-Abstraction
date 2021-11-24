import java.util.Scanner;

public class Stars
{
  public static void main(String args[])
  {
    Scanner kb = new Scanner(System.in);
    int n;

    System.out.println("Enter n:");
    n = kb.nextInt();
    stars(n);
  }

  public static void stars(int k)
  {
    if(k == 1)
    {
      System.out.println('*');
    }
    else
    {
      stars(k-1);
      for (int i = 0; i < k; i++)
      {
        System.out.print('*');
      }
      System.out.println();
      stars(k-1);
    }
  }
}
  