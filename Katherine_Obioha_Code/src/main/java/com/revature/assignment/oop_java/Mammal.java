package oop_java;

/**
 * 
 * @author katherine obioha
 * 
 * Implement Animal interface but do not implement the move method
 *
 * create a static method called walk
 */
public abstract class Mammal implements Animal {
	
	public Mammal()
	{
		super();
	}

	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("A mammal eats");
	}

	
	static void walk()
	{
		System.out.println("A mammal walks");
	}

}
