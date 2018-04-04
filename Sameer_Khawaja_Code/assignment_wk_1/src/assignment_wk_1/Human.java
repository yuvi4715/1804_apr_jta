package assignment_wk_1;

//problem 9
public class Human extends Mammal {

	@Override
	public void eat() {
		System.out.println("The human eats");

	}

	public static void walk() {
		System.out.println("The human walks");
	}



	public static void main(String args[]) {
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
