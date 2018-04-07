package oop;

public interface Animal {

	public abstract void eat();

	default void move() {
		System.out.println("The animal moves");
	}

	default void walk() {
		System.out.println("The animal walks");
	}

}
