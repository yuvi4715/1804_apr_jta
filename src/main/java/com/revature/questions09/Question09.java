package com.revature.questions09;

public class Question09 {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Animal one = new Human();
		one.eat();
		one.move();
		((Human) one).walk();
		
		Mammal two = new Human();
		two.eat();
		two.move();
		two.walk();
		
		Human three = new Human();
		three.eat();
		three.move();
		three.walk();
		
		
	}
}
