package problems1to9;

public class MammalHumanTest {

	public static void main(String[] args) {
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		one.eat();
		one.move();
		//one.walk();
		
		two.eat();
		two.move();
		Mammal.walk();
		
		three.eat();
		three.move();
		Human.walk();

	}

}
