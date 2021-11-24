//Arun Agarwal Lab2 2/1/2020
import java.util.Scanner;

public class Screen
{
  private Line[] theScreen;
  private int width, height;
  private char bg;

  public Screen(int w, int h, char fill)
  {
    this.height = h;
    this.width = w;
    this.bg = fill;
    theScreen = new Line[h];
    for (int i = 0; i < h; i++)
    {
      theScreen[i] = new Line(w, fill);
    }
  }

  public Screen(int w, int h)
  {
    this(w, h, ' ');
  }

  public int getWidth()
  {
    return this.width;
  }

  public int getHeight()
  {
    return this.height;
  }

  public char getBg()
  {
    return this.bg;
  }

  public void setPixel(int x, int y, char c)
  {
    if (y >= 0 && y < this.height)
    {
      theScreen[y].setPixel(x, c);
    }
  }

  public char getPixel(int x, int y)
  {
    if (y >= 0 && y < this.height)
    {
      return theScreen[y].getPixel(x);
    }
    else
    {
      return this.bg;
    }
  }

  private static int max(int a, int b)
  {
    if (a > b)
      return a;
    else
      return b;
  }

  private static int min(int a, int b)
  {
    if (b > a)
      return a;
    else
      return b;
  }
 
  public void hLine(int x1, int x2, int y, char c)
  {
    for (int x = min(x1,x2);x <= max(x1, x2); x++)
    {
      this.setPixel(x, y, c);
    }
  }

  public void vLine(int x, int y1, int y2, char c)
  {
    for (int y = min(y1,y2);y <= max(y1, y2); y++)
    {
      this.setPixel(x, y, c);
    }
  }

  public void drawRect(int x1, int y1, int x2, int y2, char c)
  {
    hLine(x1, x2, y1, c);
    hLine(x1, x2, y2, c);
    vLine(x1, y1, y2, c);
    vLine(x2, y1, y2, c);
  }

  public void fillRect(int x1, int y1, int x2, int y2, char c)
  {
    for (int y = y1; y <= y2; y++)
    {
      this.hLine(x1, x2, y, c);
    }
  }

  public void line(int x1, int y1, int x2, int y2, char c)
  {
    if(Math.abs(x2 - x1) > Math.abs(y2 - y1))
    {
      for (int x = min(x1, x2); x <= max(x1, x2); x++)
      {
        int y = (x - x1) *(y2 - y1) / (x2 - x1)  + y1;
        this.setPixel(x, y, c);
      }
    }  
    else
    {
      for (int y = min(y1, y2); y <= max(y1, y2); y++)
      {
        int x = (y - y1) * (x2 - x1) / (y2 - y1) + x1;
        this.setPixel(x, y, c);
      }
    }
  }

  public void drawText(int x, int y, String s)
  {
    for(int i = 0; i < s.length(); i++)
    {
      this.setPixel(x + i, y, s.charAt(i));
    }
  }

  public String toString()
  {
    String retval = "";
    for (int y = 0; y < this.height; y++)
    {
      retval += (theScreen[y].toString() + '\n');
    }
    return retval;
  }


  //public static void main(String args[])
  //{
    //Screen myScreen = new Screen(20, 20, '.');
    //System.out.println(myScreen);

    //myScreen.drawText(4, 4, "Hello world!");
	//System.out.println(myScreen);
  //}
}

