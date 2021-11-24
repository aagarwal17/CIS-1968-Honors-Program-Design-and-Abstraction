//Arun Agarwal

public class Fraction 
{
	//class invariants: bottom > 0
	// gcd(top, bottom) = 1
	private int top;
	private int bottom;
	//every time you create instance variables, it is a good idea to use "this"
	public Fraction(int t, int b)
	{
		if (b == 0)
			{
				System.err.println("Attempt to create impossible Fraction");
				System.exit(1);
			}
		
		if (b < 0)
		{
			b = -b;
			t = -t;
		}
		
		this.top = t;
		this.bottom = b;
		this.gcd();
		//you do not need this in this case, but if you had named them int top and int bottom, the compiler would
		//get confused and you would need to include it
	
	}
	
	public Fraction(int t)
	{
		this(t, 1);
		//calls the constructor with two integers (the one above)
		
	}
	
	public Fraction()
	{
		this (0,1);
	}
	//constructors have no return type associated with them and their name is the same name as the class
	
	public Fraction(Fraction f)
	{
		this(f.top,f.bottom);
	}
	public int getNumerator()
	{
		return this.top;
	}
	
	public int getDenominator()
	{
		return this.bottom;
	}
	
	public String toString()
	{
		String returnvalue = "";
		if(this.top==0)
		{
			returnvalue = "0";
		}
		else if (this.bottom ==1)
			
		returnvalue += this.top + "/" + this.bottom;
		return returnvalue;
	}
	
	//parameter rhs stands for right hand side
	public Fraction addTo(Fraction rhs)
	{
		Fraction returnvalue = new Fraction();
		returnvalue.top = this.top*rhs.bottom + this.bottom*rhs.top;
		returnvalue.bottom = this.bottom*rhs.bottom;
		return returnvalue;
	}
	
	public Fraction multiplyTo(Fraction rhs)
	{
		Fraction returnvalue = new Fraction();
		returnvalue.top = this.top*rhs.top;
		returnvalue.bottom = this.bottom*rhs.bottom;
		return returnvalue;
	}
	
	//this is private, meaning it cannot be accessed outside the class. The client has no need to see this. There are no
	//parameters because you can use the same ones from above by doing this.top and this.bottom
	private void gcd()
	{
		int a = this.top;
		int b = this.bottom;
		int temp;
		
		while (b > 0)
		{
			temp = a;
			b = a%b;
			a = temp;
		}
		this.top /= a;
		this.bottom /= a;
	}
	
	public static void main (String [] args)
	{
		Fraction f1 = new Fraction(1,-2);
		//System.out.println("top = " + f1.getNumerator() + "bottom = " + f1.getDenominator());
		System.out.println(f1);
		Fraction f2 = new Fraction(2,3);
		Fraction f3 = f1.addTo(f2);
		System.out.println(f3);
		Fraction f4 = f3.multiplyTo(f2);
		System.out.println(f4);
		
		Fraction f5 = new Fraction(6,18);
		Fraction f6 = new Fraction(-17, 51);
		System.out.println("" + f5 + f6);
	}
}
