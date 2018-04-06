package oop;

public class OOPMain {

	public static void main(String[] args)
	{
		Animal one = new Human(); 	
		Mammal two = new Human(); 	
		Human three = new Human();
		one.eat();
		one.move();
		//one.walk(); //cannot call this method
		two.eat();
		two.move();
		two.walk(); 
		three.eat();
		three.move();
		three.walk(); // prefers human.walk(); to match static type
	}

}
