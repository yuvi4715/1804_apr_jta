package com.revature.oop;

public class Human extends Mammal{

	static void walk() {
		System.out.println("Humans walk on two legs");
	}

	public void eat() {
		System.out.println("Eat a cheeseburger");
	}

	public void move() {
		
	}

	public static void main(String[] args) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();
		one.move();
		//one.walk();
		two.eat();
		two.move();
		two.walk();
		three.eat();
		three.move();
		three.walk();
	}
}
