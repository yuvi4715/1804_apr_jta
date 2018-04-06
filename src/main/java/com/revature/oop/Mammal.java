package com.revature.oop;

public abstract class Mammal implements Animal {

	@Override
	public void eat() {
		System.out.println("Eating");
	}
	
	static void walk() {
		System.out.println("Mammal walking here");
	}

}
