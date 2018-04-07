package oop;
/**
 * Dominick Sermeno
 * Batch 1804
 * Q's: 9
 */
public abstract class Mammal implements Animal 
{
	public void eat() 
	{
		System.out.println("I am a eating mammal! ");
	}
	
	public abstract void move();

	
	public static void walk()
	{
		System.out.println("I am a walking Mammal!");
	}
	
	
}
