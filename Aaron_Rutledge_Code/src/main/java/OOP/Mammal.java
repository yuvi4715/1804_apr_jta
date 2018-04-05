package oop;

public abstract class Mammal implements Animal{
	
	public void eat() {
		System.out.println("Mammals can be omnivores, herbivores, or carnivores!");
	}
	
	public static void walk() {
		System.out.println("Mammals can walk on two our four legs.");
	}

}
