package oop;

public class Problem9 {
	
	public static void main(String[] args) {
		
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();
		one.move();
		//one.walk();
		
		two.eat();
		two.move();
		//two.walk();
		
		three.eat();
		three.move();
		three.walk();
		
		
		
	}

}
