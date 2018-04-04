package com.revature.oop;

// Main class that has results for hw1 problem #9

public class AnimalMain {

	public static void main(String[] args) {
		
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();
		one.move();
		((Mammal)one).walk(); // This line doesnt work because walk() is not defined in Animal
		
		two.eat();
		two.move();
		two.walk();
		
		three.eat();
		three.move();
		three.walk();
	}
}
