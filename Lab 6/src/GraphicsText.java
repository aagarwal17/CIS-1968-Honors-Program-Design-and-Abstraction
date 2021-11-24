/**
 * 
 * @author Arun Agarwal
 * Program Design and Abstraction
 * Lab 6: Graphics awt
 *
 */
//I will create a graphics window that allows someone to enter
//player names (there will be a button that says confirm) for two
//people. There will be a button on the bottom that says add more players,
//This will allow the player to add up to two more people
//make a save button
//change background color, insert uno image, change button colors, make scroll bar, 
import java.awt.Font;
import java.awt.*;
import java.awt.event.*;
public class GraphicsText extends Frame implements ActionListener
{
	TextField field1;
	TextField field2;
	TextField field3;
	Button b1;
	Button b2;
	Button b3;
	Label start;
	Label player1;
	Label player2;
	
	TextField fieldExtra1;
	TextField fieldExtra2;
	Label player3;
	Label player4;
	
	Image unoSymbol;
	String[] playersArray;
	
	Scrollbar vertical;
	MenuBar mb;
	Menu menu;
	Menu submenu;
	MenuItem reset;
	MenuItem play;
	MenuItem exit;
	MenuItem maximize;
	MenuItem save;
	
	public GraphicsText()
	{
		
		setLayout(null);
		setBackground(Color.red);
		
		start = new Label("WELCOME TO UNO!!!  PLAYER ENTRY: "); //edit font size and color and style
		start.setBounds(120, 50, 400, 40);
		start.setFont(new Font("Title", Font.BOLD, 20));
		start.setForeground(Color.blue);
		
		player1 = new Label("Player 1 Name: ");
		player1.setBounds(25,90,115,30);
		player1.setBackground(Color.yellow);
		player1.setFont(new Font("Calabri", Font.BOLD, 15));
		
		field1 = new TextField();
		field1.setBounds(170,90,150,30);
		field1.setBackground(Color.yellow);
		field1.setForeground(Color.red);
		
		player2 = new Label("Player 2 Name: ");
		player2.setBounds(25,130,115,30);
		player2.setBackground(Color.yellow);
		player2.setFont(new Font("Calabri", Font.BOLD, 15));
		
		field2 = new TextField();
		field2.setBounds(170,130,150,30);
		field2.setBackground(Color.yellow);
		field2.setForeground(Color.red);
		
		field3 = new TextField();
		field3.setBounds(130,180,300,30);
		field3.setEditable(false);
		field3.setBackground(Color.yellow);
		field3.setForeground(Color.red);
		
		b1 = new Button("Confirm/Save? ");
		b1.setBounds(25,170,95,50);
		b1.setBackground(Color.yellow);
		b1.setFont(new Font("Calabri", Font.BOLD, 12));
		
		b2 = new Button("Add 1 More Player? ");
		b2.setBounds(25,235,150,50);
		b2.setBackground(Color.yellow);
		b2.setFont(new Font("Calabri", Font.BOLD, 14));
		
		b3 = new Button("Add 2 More Players? ");
		b3.setBounds(190,235,150,50);
		b3.setBackground(Color.YELLOW);
		b3.setFont(new Font("Calabri", Font.BOLD, 14));
		
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		
		player3 = new Label("Player 3 Name: ");
		player3.setBounds(25,300,115,30);
		player3.setBackground(Color.yellow);
		player3.setFont(new Font("Calabri", Font.BOLD, 15));
		
		fieldExtra1 = new TextField(" ");
		fieldExtra1.setBounds(170,300,150,30);
		fieldExtra1.setBackground(Color.yellow);
		fieldExtra1.setForeground(Color.red);
		
		player4 = new Label("Player 4 Name: ");
		player4.setBounds(25,340,115,30);
		player4.setBackground(Color.yellow);
		player4.setFont(new Font("Calabri", Font.BOLD, 15));
		
		fieldExtra2 = new TextField(" ");
		fieldExtra2.setBounds(170,340,150,30);
		fieldExtra2.setBackground(Color.yellow);
		fieldExtra2.setForeground(Color.red);
		
		
		MediaTracker mt = new MediaTracker(this);
		unoSymbol = Toolkit.getDefaultToolkit().getImage("MyImageResize.png");
		mt.addImage(unoSymbol, 0);;
		
		playersArray = new String[4];
		
		//vertical = new Scrollbar(Scrollbar.VERTICAL, 10, 10, 10, 450);
		vertical = new Scrollbar();
		vertical.setBounds(610,25,10,420);
		add(vertical);
		
		MenuBar mb = new MenuBar();
		Menu menu = new Menu("Menu");
		Menu submenu = new Menu("More");
		MenuItem reset = new MenuItem("Reset");
		MenuItem play = new MenuItem("Play");
		MenuItem exit = new MenuItem("Exit");
		MenuItem save = new MenuItem("Save");
		MenuItem maximize = new MenuItem("Maximize");
		
		reset.addActionListener(this);
		play.addActionListener(this);
		exit.addActionListener(this);
		save.addActionListener(this);
		maximize.addActionListener(this);
		
		menu.add(reset);
		menu.add(play);
		menu.add(exit);
		submenu.add(save);
		submenu.add(maximize);
		menu.add(submenu);
		mb.add(menu);
		setMenuBar(mb);
		
		
		add(start);
		add(field1);
		add(field2);
		add(b1);
		add(b2);
		add(b3);
		add(player1);
		add(player2);
		
		setSize(630,450);
		setTitle("UNO Entry Screen");
		setVisible(true);
		
		addWindowListener(new WindowAdapter()
		{
			  public void windowClosing(WindowEvent we)
			  {
			    System.exit(0);
			  }
		});
		
	}
	
	public void update(Graphics g)
	{
		paint(g);
	}
	public void paint (Graphics g)
	{
		g.drawImage(unoSymbol, 380, 230, this);
	}
	public void actionPerformed (ActionEvent e)
	{
		String name1 = field1.getText();
		String name2 = field2.getText();
		String name3 = fieldExtra1.getText();
		String name4 = fieldExtra2.getText();
		String output;
		if(e.getSource() == b1)
		{
			if (name1.equals("") || name2.equals("") || name3.equals("") || name4.equals(""))
			{
				output = ("Error! All Names Must be Entered!");
				field3.setText(output);
				field3.setBounds(130,180,190,30);
				add(field3);
			}
			else if (!name3.equals(" ") && !name4.equals(" "))
			{
				output = ("Confirmed! Player 1 is " + name1 + " , Player 2 is " + name2 + " , Player 3 is" + name3 + " , and Player 4 is" + name4);
				field3.setText(output);
				field3.setBounds(130,180,490,30);
				add(field3);
				playersArray[0] = name1;
				playersArray[1] = name2;
				playersArray[2] = name3;
				playersArray[3] = name4;
			}
			else if(!name3.equals(" "))
			{
				output = ("Confirmed! Player 1 is " + name1 + " , Player 2 is " + name2 + " , and Player 3 is" + name3);
				field3.setText(output);
				field3.setBounds(130,180,390,30);
				add(field3);
				playersArray[0] = name1;
				playersArray[1] = name2;
				playersArray[2] = name3;
			}
			else
			{
				output = ("Confirmed! Player 1 is " + name1 + " and Player 2 is " + name2);
				field3.setText(output);
				field3.setBounds(130,180,300,30);
				add(field3);
				playersArray[0] = name1;
				playersArray[1] = name2;
			}
			
			for (int i = 0; i < 2; i++)
			{
				System.out.println("Player " + (i + 1) + " is " + playersArray[i]);
			}
			for (int i = 2; i < 4; i++)
			{
				System.out.println("Player " + (i + 1) + " is" + playersArray[i]);
			}
		}
		if(e.getSource() == b2)
		{
			add(player3);
			add(fieldExtra1);
			b2.setVisible(false);
		}
		else if(e.getSource() == b3)
		{
			add(player3);
			add(fieldExtra1);
			add(player4);
			add(fieldExtra2);
			b3.setVisible(false);
			b2.setVisible(false);
		}
		if(e.getSource() == exit)
		{
			System.exit(0);
		}
	}
	
	public static void main(String[] args)
	{
		GraphicsText mine = new GraphicsText();
	}
}