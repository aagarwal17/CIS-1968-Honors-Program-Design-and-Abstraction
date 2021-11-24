/**
 /*Arun Agarwal tuk82261
 * Honors Program Design and Abstraction
 * Lab 1
 */
import java.util.Scanner;
public class Lab1
{
  public static void main(String args[])
  {
    final int maxNames = 100; //final means it cannot be changed
    Scanner kb = new Scanner(System.in);
    String names[] = new String[maxNames];
    int count = 0;
    boolean done = false;
    String target;
    
    count = getData(names, maxNames); //fills the array names and returns how many
    System.out.println("The number of names in the list is " + count);
    sort(names, count); //any kind of sort you know how to write
    while (!done)
    {
      System.out.println("\nWhat name are you looking for:");
      target = kb.nextLine();
      if(target.equals(""))
      {
        done = true;
      }
      else
      {
        boolean target2 = lookup(names, target, count);//returns true if found, false otherwise
        if(target2)
        {
          System.out.println("PRESENT");
        }
        else
        {
          System.out.println("ABSENT"); 
        }
      }
    }
  } 

  public static int getData(String s[], int size)
  {
//read names into the array s which has been declared to hold at most
//size strings.  Return when an empty string ("") is entered, or when
//size names have been entered.  The return value should be the number 
//of names actually entered
	  String name = "startingString";
	  Scanner names = new Scanner(System.in);
	  int countNames = 0;
	  int i = 0;
	  
	  while (!name.equals("") || s.length != size) 
	  {
  		 System.out.print("Please type in name or exit by pressing enter: ");
		 name = names.nextLine();
		 if(name.length() != 0)
			 name = name.substring(0,1).toUpperCase() + name.substring(1).toLowerCase();
		 if (name.equals(""))
			 break;
		 s[i] = name;
		 i++;
		 countNames++;
	  }
	  return countNames;
  }

  public static void sort(String s[], int count)
  {
// alphabetize the array of Strings.  Count tells how many names
// are in the array.
	  for (int i = 0; i < count - 1; i++)
	  {
		  for (int j = i + 1; j < count; j++)
		  {
			  if(s[i].compareTo(s[j]) > 0)
			  {
				  String temp = s[i];
				  s[i] = s[j];
				  s[j] = temp;
			  }
		  }
	  }
	  System.out.print("Your list of names is: ");
	  for(int i=0; i < count; i++)
	  {
		  if (i == 0)
			  System.out.print(s[i]);
		  else
			  System.out.print(", " + s[i]);
	  }
  }

  public static boolean lookup(String s[], String target, int size)
  {
//determine whether the String in target is found in the array.  Return
//true if it is present, false otherwise
	  for (int i = 0; i < size; i++)
	  {
		  if (s[i].equals(target) || s[i].toLowerCase().equals(target))
			  return true;
	  }
	  return false;
  }
}
