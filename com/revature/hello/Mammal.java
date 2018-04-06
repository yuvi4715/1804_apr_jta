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
		
		one.eat();
		one.move();
		((Human)one).walk();
		Human.walk();

		System.out.println("two: ");
		two.eat();
		two.move();
		two.walk();
		Mammal.walk();

		System.out.println("three: ");
		two.eat();
		two.move();
		two.walk();		// calls mammal's walk(), just call static method's with the class name
	}
}

interface Animal{
	public void eat();
	public void move();
}