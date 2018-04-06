package question9;

public class q9 {

	public static void main(String[] args) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		one.eat();
		one.move();
		two.eat();
		Mammal.walk();
		three.eat();
		Mammal.walk();
	}

}
