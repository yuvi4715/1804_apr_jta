//Create an Animal interface with two methods: eat() and move(). Write a class called Mammal that implements Animal and the eat() but does not implement move(). Mammal should also have a static method called walk(). Create a Human class that extends Mammal, overrides eat() and has a static method called walk(). Create two objects as follows:
//Animal one = new Human(); 	Mammal two = new Human(); 	Human three = new Human();
//Call each of the methods for each of the objects: eat(), move(), walk(). Note the results.

//Inteface: Animal
//Methods: eat(); move()
//class Mammal: implements animal and eat(); static method: walk()
//class Human: extends Mammal; overries eat(); static method: walk()
//Animal one = new Human(); 	
//Mammal two = new Human(); 	
//Human three = new Human();
//

package OOP;


public class question9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Animal one = new Human(); 	
		Mammal two = new Human(); 	
		Human three = new Human();
		one.eat();
		two.eat();
		three.eat();
		one.move();
		two.move();
		three.move();
		
	}

}
