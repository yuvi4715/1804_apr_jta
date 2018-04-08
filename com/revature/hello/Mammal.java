package com.revature.hello;

public abstract class Mammal implements Animal{
	// 9
	// Create an Animal interface with two methods: eat() and move().
//	Write a class
	// called Mammal that implements Animal and the eat() but does not implement
	// move(). Mammal should also have a static method called walk().
//	Create a Human
	// class that extends Mammal, overrides eat() and has a static method called
	// walk(). Create three objects as follows:
	// Animal one = new Human(); Mammal two = new Human(); Human three = new
	// Human();
	// Call each of the methods for each of the objects: eat(), move(), walk(). Note
	// the results.
	
	public void eat() {
		System.out.println("Mammal.eat()");
	}
	public static void walk() {
		System.out.println("Mammal.walk()");
	}
	
	public static void main(String args[]) {
		Animal one = new Human(); 
		Mammal two = new Human();
		Human three = new Human();

		System.out.println("Animal: ");
		one.eat();
		one.move();
		Human.walk();

		System.out.println("Mammal: ");
		two.eat();
		two.move();
		Mammal.walk();

		System.out.println("Human: ");
		three.eat();
		three.move();
		Human.walk();		// static methods should be called in static ways
	}
}

interface Animal{
	public void eat();
	public void move();
}