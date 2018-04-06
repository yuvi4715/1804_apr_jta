package com.revature.oop;

// Question 9
public class AnimalApp {

	public static void main(String[] args) {
		Animal animalOne = new Human();
		Mammal animalTwo = new Human();
		Human animalThree = new Human();

		System.out.println("Animal One Eat: ");
		animalOne.eat();
		System.out.println("Animal One Move: ");
		animalOne.move();
//		animalOne.walk();
		
		System.out.println("Animal Two Eat: ");
		animalTwo.eat();
		System.out.println("Animal Two Move: ");
		animalTwo.move();
		System.out.println("Animal Two Walk: ");
		animalTwo.walk();
		
		System.out.println("Animal Three Eat: ");
		animalThree.eat();
		System.out.println("Animal Three Move: ");
		animalThree.move();
		System.out.println("Animal Three Walk: ");
		animalThree.walk();
	}

}
