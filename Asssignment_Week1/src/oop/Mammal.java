package oop;
//Kevin Rivera - Revature
//Assignment Week 1: OOP - Problem 9.
//This is the Mammal class which implements the interface animal.

public class Mammal implements animal{

	@Override
	public void eat() {
		System.out.println("I am a mammal and I am eating!!!");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub	
	}
	
	public static void walk() {
		System.out.println("I am a mammal and I am walking!!!");
	}

}
