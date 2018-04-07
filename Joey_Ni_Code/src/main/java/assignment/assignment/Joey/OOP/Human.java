package assignment.Joey.OOP;
/**
 * a Human class that extends Mammal, 
 * overrides eat() and has a static method 
 * called walk(). 
 * @author joeyi
 *
 */
public class Human extends Mammal {

	@Override
	public void eat() {
		System.out.println("Human eat");
	}
	//static methods cannot override?
	public static void walk() {
		System.out.println("Human walk");	
	}
	@Override
	public void move() {
		System.out.println("Human move");
	}
	

}
