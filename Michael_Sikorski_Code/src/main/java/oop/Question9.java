package oop;

public class Question9 {

	public Question9() {
		System.out.println("-- Question 9 --");
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();

		one.eat();
		one.move();
		// one.walk();

		two.eat();
		two.move();
		two.walk();

		three.eat();
		three.move();
		three.walk();
		System.out.println();
	}

}
