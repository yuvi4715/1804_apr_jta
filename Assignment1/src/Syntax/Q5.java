//John Eifert
package Syntax;

//Answers question 5 alongside MethodClass.java

public class Q5 
{
	public static void main(String args[])
	{
		double number1 = 1.3;
		double number2 = 3.1;
		
		
		System.out.println("number 1 = " + number1);
		System.out.println("number 2 = " + number2);
		
		System.out.println("number 1 + number 2 = " + MethodClass.add(number1, number2));
		
		System.out.println("number 1 - number 2 = " + MethodClass.subtract(number1, number2));
		
		System.out.println("number 1 * number 2 = " + MethodClass.multiply(number1, number2));
		
		System.out.println("number 1 / number 2 = " + MethodClass.divide(number1, number2));
	}
}
