package com.revature.oop;

public class Human extends Mammal {
	
	public void eat() {
		System.out.println("Human eating here");
	}
	
	static void walk() {
		System.out.println("Human walking here!!");
	}

	@Override
	public void move() {
		System.out.println("Human moving here!!");
	}
}
