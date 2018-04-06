package oop;

public class Human extends Mammal
{


	@Override
	public void move() 
	{
		System.out.println("I am a moving human");
		
	}
	
	public void eat() 
	{
		System.out.println("I am a eating human! ");
	}

	public static void walk()
	{
		System.out.println("I am a walking human");
	}
	
}
