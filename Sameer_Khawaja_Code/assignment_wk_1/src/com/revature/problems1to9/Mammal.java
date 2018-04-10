package com.revature.problems1to9;
//problem 9
public abstract class Mammal implements Animal{

	

	@Override
	public void eat() {
		System.out.println("The mammal is eating");
		
	}
	
	public static void walk() {
		System.out.println("The mammal walks");
	}
	
	
	public void move() {
		//unimplemented
	}


}
