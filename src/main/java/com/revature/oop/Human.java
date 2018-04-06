package com.revature.oop;

public class Human extends Mammal {
	public void eat() {
		System.out.println("I am eating!");
	}
	
	static void walk() {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
}
