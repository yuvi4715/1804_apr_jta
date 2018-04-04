package oop;
//Kevin Rivera - Revature
//Assignment Week 1: OOP - Problem 9.
//This is the Human class which extends the Mammal class.

public class Human extends Mammal{
	
	@Override
	public void eat() {
		System.out.println("I am a human and I am eating!!!");
	}
	
	public static void walk() {
		System.out.println("I am a human and I am walking!!!");
	}
	
	public static void main(String[] args) {
		animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		//Call the methods of each object
		one.eat();
		one.move();
		two.eat();
		two.move();
		two.walk();
		three.eat();
		three.move();
		three.walk();
	}

}
