package OOP;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Animal one = new Human();
		Mammal two = new Human(); 	
		Human three = new Human();
		
		// all three say the human is eating
		one.eat(); 
		two.eat();
		three.eat();
		
		// none of the moves show anything
		one.move();
		two.move();
		three.move();
		

		two.walk(); // says walking
		three.walk(); // says human walking
		
		
		Mammal.walk(); // says walking
		Human.walk(); // says human walking

	}

}
