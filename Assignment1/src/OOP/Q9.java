//John Eifert
package OOP;

//Answers question 9 alongside Mammal.java, Animal.java, and Human.java

public class Q9 
{
	public static void main(String args[])
	{
		Animal one = new Human();
		Mammal two = new Human();
		Human three = new Human();
		
		
		one.eat();
		one.move();
		
		two.eat();
		two.move();
		two.walk();
		
		three.eat();
		three.move();
		three.walk();
	}
}
