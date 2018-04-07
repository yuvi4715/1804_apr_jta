package oop_java;

public class AnimalMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal one = new Human();
		Mammal two =new Human();
		Human three = new Human();
		
		//Human is an Animal
		one.eat();
		one.move();
		
		System.out.println("");
		
		//Human is a mammal
		two.eat();
		two.move();
		two.walk();
		
		System.out.println("");
		
		//Human is a human
		three.eat();
		three.move();
		three.walk();

	}

}
