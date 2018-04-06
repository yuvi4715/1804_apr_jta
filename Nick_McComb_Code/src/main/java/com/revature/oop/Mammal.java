package com.revature.oop;

public abstract class Mammal implements Animal{
	public void eat() {
		System.out.println("Chewing on some food");
	}
	
	static void walk() {
		System.out.println("Walking on some legs");
	}
}
