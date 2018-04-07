package assignment.Joey.OOP;
/*** Create two objects as follows:
Animal one = new Human();         
Mammal two = new Human();        
Human three = new Human();
Call each of the methods for each of the objects: eat(), move(), walk(). 
*/
public class OOPMain {
	public static void main(String[] args) {
		//Animal zero =new Mammal();
		Animal one = new Human();         
		Mammal two = new Human();        
		Human three = new Human();
		System.out.println("Animal reference");
		one.eat();
		one.move();
		//Animal.walk(); Method undefined 
		System.out.println("Mammal reference");
		two.eat();
		two.move();
		Mammal.walk();
		System.out.println("Human reference");
		three.eat();
		three.move();
		Human.walk();
		
	}
}
