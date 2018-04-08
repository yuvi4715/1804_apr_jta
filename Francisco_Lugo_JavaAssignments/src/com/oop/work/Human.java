package com.oop.work;

public class Human extends Mammal{
	
	@Override
	public void eat() {
		System.out.println("Human is eating");
	}

	public void walk() {
		System.out.println("Human is walking");
	}
}
