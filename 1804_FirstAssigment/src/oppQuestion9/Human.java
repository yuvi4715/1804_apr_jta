package oppQuestion9;

public class Human extends Mammal{

	@Override
	public void eat() {
		
	}
	

	
	@Override
	public void move() {
		
	}
	
	
	public static void walk() {
		
	}
	
	public static void main(String[] args) {
		
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();
		one.move();
		Mammal.walk();
		
		two.eat();
		two.move();
		Human.walk();
		
		three.eat();
		three.move();
	    Human.walk();
			
		
	}

	
	//Create an Animal interface with two methods: eat() and move(). Write a class called Mammal 
	//that implements Animal and the eat() but does not implement move(). Mammal should also 
	//have a static method called walk(). Create a Human class that extends Mammal, 
	//overrides eat() and has a static method called walk(). Create three objects as follows:
	//Animal one = new Human(); 	Mammal two = new Human(); 	Human three = new Human();
	//Call each of the methods for each of the objects: eat(), move(), walk(). Note the results.
	
	
	
}
