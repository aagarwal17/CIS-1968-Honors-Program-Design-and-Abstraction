/**
 * Arun, John, Maddy
 * UNO Card Class for Final Project
 */

//This class contains the code for the singular card (face, value, etc.)
	public class UnoCard 
	{
	
	    Color setTemp() 
	    {
	        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	    }
		
		public enum Color { RED, YELLOW, BLUE, GREEN, WILD }
		public enum Face  { ZERO, ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, 
						    EIGHT, NINE, SKIP, REVERSE, DRAW2, BLANK, DRAW4 }
	
		Color hue;
		Face command;
		Color tempColor; //Temporary chosen color for wild
	    
		//constructor
		public UnoCard( Color newColor, Face newFace )
		{
			this.hue = newColor;
			this.command = newFace;
		}
		
		//sets color
		public void setColor(Color newColor)
		{
			this.hue = newColor;
		}
		
		//returns color
		public Color getColor()
		{
			return hue;
		}
		
		//Gets temporary wild color
        public Color getTemp() 
        {
            return tempColor;
        }
        
        //Sets temporary wild color when a wild card is played
        public void setTemp(Color newColor) 
        {
            this.tempColor = newColor;
        }
	        
	    //Sets the face value of the card    
		public void setFace(Face newFace)
		{
			this.command = newFace;
		}
		
		//Returns the face value of the card
		public Face getFace()
		{
			return command;
		}
		
		//Checks if card is Wild; returns true or false
        public boolean isWild() //Checks if the card is a wild card
        {
            return this.hue == Color.WILD;
        }
	    
        //Prints card to console
	    public void printCard()
		{
			if( this.command == Face.BLANK )
				System.out.println( hue + "");
			else
				System.out.println( hue + " " + command);
		}
		
		//driver (use to test methods)
		public static void main(String[] args)
		{
			UnoCard test1 = new UnoCard(Color.RED, Face.ZERO);
			UnoCard test2 = new UnoCard(Color.WILD, Face.BLANK);
			
			test1.printCard();
			test2.printCard();
		}
	}