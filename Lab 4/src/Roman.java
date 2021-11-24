import java.util.Scanner;

/**
 * 
 * @author Arun Agarwal Lab 4: Roman Numeral Conversion
 *
 */
public class Roman
{
  private int theValue;

  public Roman(String s)
  {
	  theValue = convertToDecimal(s);
  }
  
  public Roman()
  {
	  theValue = 0;
  }
  public Roman(int v)
  {
	  theValue = v;
  }
  
  private static int convertToDecimal(String romanNumeral)
  {
	  	 int retval = 0;
	  	 romanNumeral = romanNumeral.toUpperCase();
		 int l = romanNumeral.length();
		 int num = 0;
		 int previousnum = 0;
		 for (int i = l - 1; i >= 0; i--)
		 {
			 char x = romanNumeral.charAt(i);
			 x = Character.toUpperCase(x);
			 switch(x)
			 {
			 	case 'I':
				previousnum = num;
				num = 1;
				break;
				
			 	case 'V':
			 	previousnum = num;
			 	num = 5;
			 	break;
			 	
			 	case 'X':
			 	previousnum = num;
			 	num = 10;
			 	break;
			 	
			 	case 'L':
			 	previousnum = num;
			 	num = 50;
			 	break;
			 	
			 	case 'C':
			 	previousnum = num;
			 	num = 100;
			 	break;
			 	
			 	case 'D':
			 	previousnum = num;
			 	num = 500;
			 	break;
			 	
			 	case 'M':
			 	previousnum = num;
			 	num = 1000;
			 	break;
			 }
			 
			 if (num < previousnum)
				 retval = retval - num;
			 else
				 retval = retval + num;
			 
		 }
		 for (int i = 1; i <= romanNumeral.length() - 2; i++)
		 {
			 char previous = romanNumeral.charAt(i - 1);
			 char x = romanNumeral.charAt(i);
			 char after = romanNumeral.charAt(i + 1);
			 if (previous == 'I' && x == 'I' && (after == 'V' || after == 'X'))
				 throw new IllegalArgumentException("Cannot have II precede X or V");
			 if (previous == 'X' && x == 'X' && (after == 'L' || after == 'C'))
				 throw new IllegalArgumentException("Cannot have XX precede L or C");
			 if (previous == 'C' && x == 'C' && (after == 'D' || after == 'M'))
				 throw new IllegalArgumentException("Cannot have CC precede D or M");
		 }
		 return retval;
  }

  public String toString()
  {
	  	int tempValue = this.theValue;
	  	String s = "";
	  	 if (tempValue < 0)
	     {
	       s += "-";
	       tempValue = -tempValue;
	     }
	    while (tempValue >= 1000) {
	        s += "M";
	        tempValue -= 1000;        }
	    while (tempValue >= 900) {
	        s += "CM";
	        tempValue -= 900;
	    }
	    while (tempValue >= 500) {
	        s += "D";
	        tempValue -= 500;
	    }
	    while (tempValue >= 400) {
	        s += "CD";
	        tempValue -= 400;
	    }
	    while (tempValue >= 100) {
	        s += "C";
	        tempValue -= 100;
	    }
	    while (tempValue >= 90) {
	        s += "XC";
	        tempValue -= 90;
	    }
	    while (tempValue >= 50) {
	        s += "L";
	        tempValue -= 50;
	    }
	    while (tempValue >= 40) {
	        s += "XL";
	        tempValue -= 40;
	    }
	    while (tempValue >= 10) {
	        s += "X";
	        tempValue -= 10;
	    }
	    while (tempValue >= 9) {
	        s += "IX";
	        tempValue -= 9;
	    }
	    while (tempValue >= 5) {
	        s += "V";
	        tempValue -= 5;
	    }
	    while (tempValue >= 4) {
	        s += "IV";
	        tempValue -= 4;
	    }
	    while (tempValue >= 1) {
	        s += "I";
	        tempValue -= 1;
	    }    
	  return (s + "");
  }
  
  public String toString2()
  {
	  return (this.theValue + "");
  }
  public Roman add(Roman rhs)
  {
	  return new Roman (this.theValue + rhs.theValue);
  }

  public Roman subtract(Roman rhs)
  {
	  return new Roman (this.theValue - rhs.theValue);
  }

  public Roman multiply(Roman rhs)
  {
	  return new Roman (this.theValue * rhs.theValue);
  }

  public Roman divideBy(Roman rhs)
  {
	  return new Roman (this.theValue / rhs.theValue);
  }

  public int compareTo(Roman rhs)
  {
	  return this.theValue - rhs.theValue;
  }
    
  public static void main (String [] args) throws InterruptedException
  {
	  /**String input = "startingInput";
	  Scanner scan = new Scanner(System.in);
	  while (!input.equals(""))
	  {
		  System.out.println("Please Enter a Roman Number or a Decimal Number: ");
		  String romanNumeral = scan.nextLine();
		  Roman romToDec = new Roman(romanNumeral);
		  Roman romOther = new Roman("IIII");
		  System.out.println("The equivalent of the Roman Numeral and the Roman Numeral simplified are: " + romToDec);
		  if (romToDec.compareTo(romOther) == 0)
			  System.out.println("romToDec.compareTo(IIII): Your input is equivalent to the trial value. ");
		  else if (romToDec.compareTo(romOther) == 1)
			  System.out.println("romToDec.compareTo(IIII): Your input is greater than the trial value. ");
		  else
			  System.out.println("romToDec.compareTo(IIII): Your input is less than the trial value. ");
		  System.out.println("Add: " + romToDec.add(romOther));
		  System.out.println("Subtract: " + romToDec.subtract(romOther));
		  System.out.println("Multiply: " + romToDec.multiply(romOther));
		  System.out.println("Divide: " + romToDec.divideBy(romOther));
		 **/ 
		  Roman numToRoman = new Roman(1149);
		  Roman num2ToRoman = new Roman(1199);
		  Roman romToDec = new Roman("CCVII");
		  Roman rom2ToDec = new Roman("MCXCVI");
		  System.out.println("1149 in Roman is " + numToRoman);
		  System.out.println("1199 in Roman is " + num2ToRoman);
		  System.out.println("CCVII in Roman is " + romToDec.toString2());
		  System.out.println("MCXCVI in Roman is "  + rom2ToDec.toString2());
		  System.out.println("Add: " + numToRoman.toString2() + " + " + num2ToRoman.toString2() + " = " + numToRoman.add(num2ToRoman).toString2());
		  System.out.println("Subtract: " + numToRoman.toString2() + " - " + num2ToRoman.toString2() + " = " + numToRoman.subtract(num2ToRoman).toString2());
		  System.out.println("Multiply: " + numToRoman.toString2() + " * " + num2ToRoman.toString2() + " * " + numToRoman.multiply(num2ToRoman).toString2());
		  System.out.println("Divide: " + numToRoman.toString2() + " / " + num2ToRoman.toString2() + " = " + numToRoman.divideBy(num2ToRoman).toString2());
		  System.out.println("CompareTo: " + numToRoman.toString2() + " compared to " + num2ToRoman.toString2() + " = " + numToRoman.compareTo(num2ToRoman));	   
  		}  
	  //NEED TO FIGURE OUT STILL HOW TO CALL AND TEST THE OTHER METHODS WRITTEN!!!
	  //THERE IS ALSO THE PROBLEM WITH EXITING THIS WHILE LOOP. THE INPUT WHEN EXITING IS ENTER, WHICH IS CONSIDERED
	  //LESS THAN ONE, SO THE CONSOLE GIVES AN OUTPUT OF "INVALID ROMAN NUMBER VALUE". NEED TO FIX THIS!!!
  }
