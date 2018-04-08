package com.oop.work;

public class Mammal implements Animal {

	@Override
	public void eat() {
		System.out.println("Mammal is eating.");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		
	}
	
	public void walk(){
		System.out.println("Mammal is walking");
	}

}
