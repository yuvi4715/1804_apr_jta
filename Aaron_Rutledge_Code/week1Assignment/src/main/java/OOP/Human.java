package oop;

public class Human extends Mammal{
	
	public void eat() {
	
		System.out.println("Humans are omnivores.");
		
	}
	
	public static void walk() {
		
		System.out.println("Humans walk on two legs.");
		
	}
	
	public void move() {
		System.out.println("This line is here so Human doesn't have to be abstract");
		
	}
	
	

}
