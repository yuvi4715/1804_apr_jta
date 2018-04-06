package com.revature.OOP;

public class Mammal implements Animal {
	
	
	static void walk() {
		System.out.println("Walking the Mammal way.");
	}

	@Override
	public void eat() {
		System.out.println("Mammal is eating.");
		
	}

}




