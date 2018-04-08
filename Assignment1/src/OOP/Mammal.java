//John Eifert
package OOP;

//Answers question 9 alongside Q9.java, Animal.java, and Human.java

public abstract class Mammal implements Animal 
{
	@Override
	public void eat() 
	{
		// TODO Auto-generated method stub
		System.out.println("This animal ate.");
	}
	
	//Does not implement move()
	
	static public void walk()
	{
		System.out.println("This mammal walked.");
	}
}
