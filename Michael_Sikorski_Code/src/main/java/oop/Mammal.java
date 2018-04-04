package oop;

public abstract class Mammal implements Animal {

	@Override
	public void eat() {
		System.out.println("The mammal eats.");
	}

	public static void walk() {
		System.out.println("Mammals walk on 2 or 4 legs.");
	}

	/*
	 * public void move() { // TODO Auto-generated method stub
	 * 
	 * }
	 */
}
