package Assignment1;

public abstract class Mammal implements Animal 
{
	@Override
	public void eat() 
	{
		// TODO Auto-generated method stub
		System.out.println("This animal ate.");
	}
	
	
	static public void walk()
	{
		System.out.println("This mammal walked.");
	}
}
