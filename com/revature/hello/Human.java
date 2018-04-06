package com.revature.hello;


public class Human extends Mammal{
	
	public void eat() {
		System.out.println("Human.eat()");
	}

	public void move() {
		System.out.println("Human.move()");
	}
	
//	Static methods cannot be overridden because method overriding only occurs in the context of dynamic
	public static void walk() {
		System.out.println("Human.walk()");
	}
	
}