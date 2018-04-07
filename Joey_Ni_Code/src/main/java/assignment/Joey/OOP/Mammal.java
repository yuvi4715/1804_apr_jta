package assignment.Joey.OOP;
/**Mammal that implements Animal and the eat() 
but does not implement move(). Mammal 
should also have a static method called walk(). */

public abstract class Mammal implements Animal {
//abstract since Mammal does not follow the interface contract
	@Override
	public void eat() {
		System.out.println("Mammal eating");
		
	}
	public static void walk() {
		System.out.println("Mammal walking");
	}

}
