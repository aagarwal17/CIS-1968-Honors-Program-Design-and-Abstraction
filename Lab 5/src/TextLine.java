/**
 * 
 * @author Arun Agarwal Program Design Lab 5
 *
 */
public class TextLine
{
  public int lineNum;
  public String theText;
 
  public TextLine(int l, String t)
  {
	  this.lineNum = l;
	  this.theText = t;
  }
  
  public int compareTo(TextLine text)
  {
	  if(this.lineNum > text.lineNum)
	  {
		  return 1;
	  }
	  else if (this.lineNum < text.lineNum)
	  {
		  return -1;
	  }
	  else
		  return 0;
  }
}