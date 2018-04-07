package com.revature.oop;

public class OopMain {

	public static void main(String[] args) {
		Animal one = new Human(); 	
		Mammal two = new Human(); 	
		Human three = new Human();
		
		Animal.eat();
		Animal.move();
		
		Mammal.walk();
		Mammal.eat();
		
		Human.walk();
		Human.eat();

	}

}
