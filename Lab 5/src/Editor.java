/**
 * Arun Agarwal Program Design Lab 5
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.io.*;

public class Editor
{
  private ArrayList<TextLine> theText;
  private String prompt;
  private enum Keywords  {READ, SAVE, LIST, RESEQUENCE, QUIT, EXIT, UNDEFINED;};
  private Scanner console;

  public Editor()
  {
    this.theText = new ArrayList<TextLine>();
    this.prompt = ">";
    this.console = new Scanner(System.in);
  }

  public String getPrompt()
  {
	  return this.prompt;
  }


  public void setPrompt(String p)
  {
	  this.prompt = p;
  }

  private static boolean isInt(String s) // see if a string represents an integer
  {                                      
    boolean retval = false;
    try
    {
      Integer.parseInt(s);
      retval = true; 
    }
    catch (NumberFormatException e)
    {
      retval = false;
    }
    return retval;
  }
 
  public void process() throws FileNotFoundException
  {
    boolean done = false;
    String line;
    while (!done)
    {
      System.out.print(this.prompt);
      line = console.nextLine().toUpperCase(); // Work only with upper case
      String splitString[] = line.split(" ", 2);
// at this point, the line that was read in has been split into two
// arrays.  splitString[0] contains the first token, splitString[1] 
// contains all the rest of the line.

//At this point, you need to decide whether this is a command or
//a line of text to be entered.
	      if (this.isInt(splitString[0]))
	      {
	    	  
	// Here we have a line of text to be entered.  Write the code to
	//insert it into the ArrayList named theText.
	    	  TextLine addition = new TextLine(Integer.parseInt(splitString[0]), splitString[1]);
	    	  this.theText.add(addition);
	    	  
	    	  
	      }
      else //otherwise, it is a command, so call doCommand to perform it.
        done = this.doCommand(splitString[0]);
    }
  }

  private boolean doCommand(String com) throws FileNotFoundException
  {
    boolean retval = false;
    Keywords command;
//This first bit takes the string in the first word of the line
//and turns it into one of the manifest constants of the 
//enumerated data type.  This makes it fairly easy to add new
//commands later.
    try
    {
      command = Keywords.valueOf(com);// command is a Keywords and can
    }                                 // can be used as the target of a switch.
    catch (IllegalArgumentException e)
    {
      command = Keywords.UNDEFINED; //An undefined Keywords will cause
    }                               //an exception. 
    switch (command)
    {
		case READ: this.read();
		           break;
		case SAVE: this.save();
		           break;
		case LIST: this.list();
		           break;
		case RESEQUENCE: this.resequence();
		           break;
		case QUIT:
		case EXIT: retval = true; 
		           break;
		case UNDEFINED: System.out.println("Undefined command:" + com);
    }
    return retval;
  }

// You need to implement the following routines.
  
  private void read() throws FileNotFoundException
  {
	  Scanner input = new Scanner(new File("lab5.txt"));
	  while(input.hasNextLine())
	  {
		  String line = input.nextLine().toUpperCase();
		  String splitString[] = line.split(" ", 2);
		  if (this.isInt(splitString[0]))
		  {
			  TextLine addition = new TextLine(Integer.parseInt(splitString[0]), splitString[1]);
			  theText.add(addition);
		  }
	  }
  }

  private void save() throws FileNotFoundException
  {
	  PrintWriter output = new PrintWriter(new File("New.txt"));
	  for(int i = 1; i < theText.size(); i++)
	  //sorting list
		{
		  TextLine temp = theText.get(i);
		  int j = i-1;
		  while ((j > -1) && ((theText.get(j).compareTo(temp) == 1)))
		  {
			  theText.set(j+1,  theText.get(j));
			  j--;
		  }
		  theText.set(j+1, temp);
		}
	  for (int i = 0; i < theText.size(); i++)
	  {
		  TextLine toPrint = theText.get(i);
		  output.println(toPrint.lineNum + " " + toPrint.theText);
	  }
	  output.close();
  }
  
  private void list()
  {
	  for(int i = 1; i < theText.size(); i++)
		  //sorting list, again
			{
			  TextLine temp = theText.get(i);
			  int j = i-1;
			  while ((j > -1) && ((theText.get(j).compareTo(temp) == 1)))
			  {
				  theText.set(j+1,  theText.get(j));
				  j--;
			  }
			  theText.set(j+1, temp);
			}
	  for (int i = 0; i < theText.size(); i++)
	  {
		  TextLine toPrint = theText.get(i);
		  System.out.println(toPrint.lineNum + " " + toPrint.theText);
	  }
  }

  private void resequence()
  {
	  for(int i = 0; i < theText.size(); i++)
	  {
		  TextLine numChange = theText.get(i);
		  numChange.lineNum = 10 + 10*i;
		  
	  }
  }

  public static void main(String args[]) throws FileNotFoundException
  {
    Editor e = new Editor();
    e.process();
  }
}

