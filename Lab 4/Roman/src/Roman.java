public class Roman implements Comparable<Roman>
{
  private int value;

  public Roman()
  {
    value = 0;
  }

  public Roman(int v)
  {
    value = v;
  }

  public Roman(String s) throws NumberFormatException
  {
    value = R2int(s);
  }

  private static int R2int(String s) throws NumberFormatException
  {
    int retval = 0;

    for (int i = 0; i < s.length(); i++)
    {
      if ( (i+1 < s.length()) && cval(s.charAt(i)) < cval(s.charAt(i+1)) )
      {
        retval -= cval(s.charAt(i));
      }
      else
      {
        retval += cval(s.charAt(i));
      }
    }
    return retval;
  }

  private static int cval(char c) throws NumberFormatException
  {
    switch(c)
    {
case 'i':
case 'I':
      return 1;
case 'v':
case 'V':
      return 5;
case 'x':
case 'X':
      return 10;
case 'l':
case 'L':
      return 50;
case 'c':
case 'C':
      return 100;
case 'd':
case 'D':
      return 500;
case 'm':
case 'M':
      return 1000;
default:
      throw (new NumberFormatException());
    }
  }

  public String toString()
  {
    String retval = "";
    int val = this.value; 
    if (val < 0)
    {
      retval += "-";
      val = -val;
    }
    while (val >= 1000)
    {
      retval += "M";
      val -= 1000;
    }
    if (val >= 900)
    {
      retval += "CM";
      val -= 900;
    }
    if (val >= 500)
    {
      retval += "D";
      val -= 500;
    }
    if (val >= 400)
    {
      retval += "CD";
      val -= 400;
    }
    while (val >= 100)
    {
      retval += "C";
      val -= 100;
    }
    if (val >= 90)
    {
      retval += "XC";
      val -= 90;
    }
    if (val >= 50)
    {
      retval += "L"; 
      val -= 50;
    }
    if (val >= 40)
    {
      retval += "XL";
      val -= 40;
    }
    while (val >= 10)
    {
      retval += "X";
      val -= 10;
    }
    if (val >= 9)
    {
      retval += "IX";
      val -= 9;
    }
    if (val >= 5)
    {
      retval += "V";
      val -= 5;
    }
    if (val >= 4)
    {
      retval += "IV";
      val -= 4;
    }
    while (val >= 1)
    {
      retval += "I";
      val -= 1;
    }
    return retval;
  }

  public Roman plus(Roman rhs)
  {
    return new Roman(this.value + rhs.value);
  }

  public Roman minus(Roman rhs)
  {
    return new Roman(this.value - rhs.value);
  }

  public Roman times(Roman rhs)
  {
    return new Roman(this.value * rhs.value);
  }

  public Roman over(Roman rhs)
  {
    return new Roman(this.value / rhs.value);
  }

  public int compareTo(Roman rhs)
  {
    return this.value - rhs.value;
  }

  public static void main(String args[]) throws NumberFormatException
  {
    Roman lhs = new Roman(args[0]);
    Roman rhs = new Roman(args[2]);

    switch(args[1].charAt(0))
    {
case '+': 
      System.out.println(lhs.plus(rhs));
      break;
case '-':
      System.out.println(lhs.minus(rhs));
      break;
case '.':
      System.out.println(lhs.times(rhs));
      break;
case '/':
      System.out.println(lhs.over(rhs));
      break;
default:
      System.out.println("Undefined operator " + args[1]);
    }
  }
} 