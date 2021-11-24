
public class Notes 
{
	public class Screen 
	{
		Constructors:
			public Screen(int width, int height, char fill_char)

			This creates a screen of width x height characters and initializes
			each pixel to fill_char.

			public Screen(int width, int height)

			This creates a screenb of width x height characters and initializes
			each pixel to a bank space (' ').

			Methods:
			public int getWidth()

			Returns the width of the screen.

			public int getHeight()

			Returns the height of the screen.

			public void setPixel(int x, int y, char c)

			Sets the pixel at location (x, y) to be the char  c.
			If x or y is out of range (0 <= x < width or 0 <= y < height)
			returns silently.

			Note that the origin is the upper left hand corner and increasing y
			moves downward.

			public char getPixel(int x, int y)

			Returns the char stored at location (x, y).
			If x or y is out of range, returns the fill_char specified when the screen
			was constructed.

			public void hline(int x1, int x2, int y, char c)

			Draws a horizontal line segment from (x1, y) to (x2, y) using
			the character c.

			public void vline(int x, int y1, int y2, char c)

			Draws a horizontal line segment from (x, y1) to (x, y2) using
			the character c.

			public void drawRect(int x1, int y1, int x2, int y2, char c)

			Draws the outline of a rectangle whose diagonally opposite vertices are given
			by (x1,y1) and (x2,y2) using the char c.

			public void fillRect(int x1, int y1, int x2, int y2, char c)

			Draws a filled in rectangle whose diagonally opposite vertices are
			given by (x1,y1) and (x2,y2) using the char c.

			public void drawText(int x, int y, String s)

			Copies the text in String to the Screen starting at (x,y).

			public void line(int x1, int y1, int x2, int y2, char c)

			Approximates a line segment from (x1,y1) to (x2,y2) using the char c.

			public String toString()
}
