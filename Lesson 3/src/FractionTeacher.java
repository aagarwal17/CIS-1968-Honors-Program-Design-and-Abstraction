
public class FractionTeacher 
{
	// class invariants: bottom > 0
	// gcd(top, bottom) = 1
	  private int top;
	  private int bottom;

	  public Fraction(int t, int b)
	  {
	    if (b == 0)
	    {
	      System.err.println("Attempt to create impossible Fraction");
	      System.exit(1);
	    }
	      
	    this.top = t;
	    this.bottom = b;
	    this.gcd();
	    if(this.bottom < 0)
	    {
	      this.bottom = -this.bottom;
	      this.top = - this.top;
	    }
	  } 
	  
	  public Fraction(int t)
	  {
	    this(t, 1);
	  }

	  public Fraction()
	  {
	    this(0, 1);
	  }

	  public Fraction(Fraction f)
	  {
	    this(f.top, f.bottom);
	  }

	  public int getNumerator()
	  {
	    return this.top;
	  }

	  public int getDenominator()
	  {
	    return this.bottom;
	  }

	  private static int abs(int a)
	  {
	    if(a > 0)
	      return a;
	    else
	      return -a;
	  }

	  public String toString()
	  {
	    String retval = "";
	    if(this.top == 0)
	      retval = "0";
	    else if(this.bottom == 1)
	      retval += this.top;
	    else if(abs(this.top) < this.bottom)
	      retval += this.top + "/" + this.bottom;
	    else //improper fraction
	      retval += this.top / this.bottom + "+" + this.top % this.bottom + "/" + this.bottom;
	    return retval; 
	  }

	  public Fraction plus(Fraction rhs)
	  {
	    Fraction retval = new Fraction();
	    retval.top = this.top * rhs.bottom + this.bottom * rhs.top;
	    retval.bottom = this.bottom * rhs.bottom;
	    retval.gcd();
	    return retval;
	  }

	  public Fraction negate()
	  {
	    Fraction retval = new Fraction(this);
	    retval.top = -retval.top;
	    return retval;
	  }

	  public Fraction minus(Fraction rhs)
	  {
	    return this.plus(rhs.negate());
	  }

	  public Fraction times(Fraction rhs)
	  {
	    Fraction retval = new Fraction();
	    retval.top = this.top * rhs.top;
	    retval.bottom = this.bottom * rhs.bottom;
	    retval.gcd();
	    return retval;
	  }

	  public Fraction invert()
	  {
	    if (this.top == 0)
	    {
	      System.err.println("Attempt to calculate 1/0.");
	      System.exit(1);
	    }
	    Fraction retval = new Fraction();
	    retval.top = this.bottom;
	    retval.bottom = this.top;
	    return retval;
	  }

	  public Fraction divideBy(Fraction rhs)
	  {
	    return new Fraction(this.times(rhs.invert()));
	  }

	  public int compareTo(Fraction rhs)
	  {
	    Fraction temp = this.minus(rhs);
	    return temp.top;
	  }

	  private void gcd()
	  {
	    int a = this.top;
	    int b = this.bottom;
	    int temp;
	    
	    while(b != 0)
	    { temp = b;
	      b = a%b;
	      a = temp;
	    }
	    this.top /= a;
	    this.bottom /= a;
	  }
	      
	    

	  public static void main(String args[])
	  {
	    Fraction f1 = new Fraction(54,28);
	    Fraction f2 = new Fraction(130,310);
	    System.out.println("f1 = " + f1);
	    System.out.println("f2 = " + f2);
	    Fraction f3 = f1.plus(f2);
	    System.out.println("Sum = " + f3);
	    Fraction f4 = f1.minus(f2);
	    System.out.println("Difference = " + f4);
	    Fraction f5 = f1.times(f2);
	    System.out.println("Product = " + f5);
	    Fraction f6 = f1.divideBy(f2);
	    System.out.println("Quotient = " + f6);
	    int ct = f1.compareTo(f2);
	    System.out.println("f1.compareTo(f2) = " + ct);
	  }
}
