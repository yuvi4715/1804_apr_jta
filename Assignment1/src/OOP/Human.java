//John Eifert
package OOP;

//Answers question 9 alongside Q9.java, Animal.java, and Mammal.java

public class Human extends Mammal 
{
	//Already inherits walk() from Mammal, so no code is necessary for that
	
	@Override
	public void eat()
	{
		System.out.println("This human ate.");
	}
	
	//Human has to override move() since it is not abstract
	@Override
	public void move() 
	{
	}
}
