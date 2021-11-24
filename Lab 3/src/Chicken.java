//Arun Agarwal Program Design Lab 3
//Don't forget: an instance of a class is an object
public class Chicken 
{
	String name;
	int age;
	char gender;
	
	public Chicken(String name, int age, char gender)
	{
		this.name = name;
		this.age = age;
		if (age < 0)
		{
			throw new IllegalArgumentException("Age cannot be below zero");
		}
		else if (age >= 100)
		{
			throw new IllegalArgumentException("Chickens do not live that long");
		}
		if (gender != 'M' && gender != 'F')
		{
			throw new IllegalArgumentException("This is not a gender");
		}
		//gender should only be M or F; age should be only positive values and below 100
		this.gender = gender;
	}
	
	public String getName()
	{
		return this.name;
	}
	public int getAge()
	{
		return this.age;
	}
	public char getGender()
	{
		//this method will need an if else for if male, rooster; if female, hen
		return this.gender;
	}
	public void fly()
	{
		System.out.println("" + name + " attempts to fly.");
	}
	public void cluck()
	{
		System.out.println("" + name + " makes clucking sounds.");
	}
	public void layEgg()
	{
		if (gender == 'M')
		{
			System.out.println("" + name + " does not lay an egg.");
		}
		else
		{
			System.out.println("" + name + " lays an egg.");
		}
	}
	public void sleep()
	{
		System.out.println("" + name + " falls asleep.");
	}
	public void scratch()
	{
		System.out.println("" + name + " scratches in the dirt.");
	}
	public void eat()
	{
		System.out.println("" + name + " eats a beetle.");
	}
	public String toString()
	{
		if (gender == 'M')
		{
			return (name + " is a " + age + " year old rooster.");
		}
		else
		{
			return (name + " is a " + age + " year old hen.");
		}
	}
	
	public static void main (String [] args)
	{
		Chicken c1 = new Chicken("Henrietta", 1, 'M');
		c1.fly();
		c1.cluck();
		c1.layEgg();
		c1.sleep();
		c1.scratch();
		c1.eat();
		System.out.println(c1);
		
		Chicken c2 = new Chicken("Roberto", 16, 'M');
		c2.fly();
		c2.cluck();
		c2.layEgg();
		c2.sleep();
		c2.scratch();
		c2.eat();
		System.out.println(c2);
	}
	
}
