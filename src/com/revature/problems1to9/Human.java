package com.revature.problems1to9;

//problem 9
public class Human extends Mammal {

	@Override
	public void eat() {
		System.out.println("The human eats");

	}

	public static void walk() {
		System.out.println("The human walks");
	}



	public static void main(String args[]) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		//create a Animal using the Human Class
		one.eat();
		one.move();
		//one.walk(); //can't call since Animal class doesn't know about child methods
		
		//create a Mammal using the Human Class
		two.eat();
		two.move();
		two.walk();
		
		//create a Human using the Human Class
		three.eat();
		three.move(); 
		three.walk();
		
		
		//Observations
		//one.walk(); //can't call since Animal class doesn't know about child methods
		//created a Animal using the Human 
		//created a Mammal using the Human Class 
		//created a Human using the Human Class
		//move does nothing since its not implemented
		//
		
	}

}
