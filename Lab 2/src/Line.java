//Arun Agarwal Lab2 2/1/2020
import java.util.Scanner;

public class Line
{
  private char theLine[];
  private int width;
  private char bg;

  public Line(int width, char fill)
  {
    theLine = new char[width];
    for(int i = 0; i < width; i++)
    {
      theLine[i] = fill;
    }
    this.width = width;
    this.bg = fill;
  }

  public Line(int width)
  {
    this(width, ' ');
  }

  public int getWidth()
  {
    return this.width;
  }
 
  public char getBg()
  {
    return this.bg;
  }

  public void setPixel(int x, char c)
  {
    if (x >= 0 && x < width)
    {
      theLine[x] = c; 
    }
  }

  public char getPixel(int x)
  {
    if (x >= 0 && x < width)
      return theLine[x];
    else
      return this.bg;
  }

  public String toString()
  {
    String retval = "";
    for (int i = 0; i < this.width; i++)
      retval += this.theLine[i];
    return retval;
  }
    
  public static void main(String args[])
  {
    Line myLine = new Line(20, '.');
    System.out.println(myLine);
    myLine.setPixel(5, '&');
    myLine.setPixel(10, 'W');
    System.out.println(myLine);
  }
}