package oop;
// inherits from mammal which uses interface. Outputs are notable.
public class Human extends Mammal{
	static Animal one = new Human(); // static instances 
	static Mammal two = new Human();
	static Human three = new Human();
	
	
	
	
	@Override
	public void move() {
		System.out.println("I move on 2 legs.");
		
	}
	
	public void eat() {
		System.out.println("I just ate a sandwhich");
	}
	
	static void walk() {
		System.out.println("I walked four feet to my house door");
	}
	
	public static void main(String[] args) {
		System.out.println("Human Animal");
		one.eat();
		one.move();
		System.out.println("Human Mammal");
		two.eat();
		two.walk();
		System.out.println("Human");
		three.eat();
		three.walk();
		three.move();
		
	}

}
