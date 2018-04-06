package com.revature.OOP;

public class Human extends Mammal {
	/*
	/*
	 * 9. Create an Animal interface with two methods: eat() and move(). Write a
	 * class called Mammal that implements Animal and the eat() but does not
	 * implement move(). Mammal should also have a static method called walk().
	 * Create a Human class that extends Mammal, overrides eat() and has a static
	 * method called walk(). Create two objects as follows: Animal one = new
	 * Human(); Mammal two = new Human(); Human three = new Human(); Call each of
	 * the methods for each of the objects: eat(), move(), walk(). Note the results.
	 * 
	 */
	
	public void eat() {
		System.out.println("Human is eating.");
	}
	static void walk() {
		System.out.println("Human is walking.");
	}
	
	public static void main(String[] args) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		one.eat();
		one.move();
//		one.walk();
		two.eat();
		two.move();
		two.walk();
		three.eat();
		three.move();
		three.walk();
		
	}

}
