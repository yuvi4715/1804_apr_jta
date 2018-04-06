//John Eifert
package Syntax;

public class Q4 
{
	public static void main(String args[])
	{
		double number1 = 1.3;
		double number2 = 3.1;
		
		
		System.out.println("number 1 = " + number1);
		System.out.println("number 2 = " + number2);
		
		System.out.println("number 1 + number 2 = " + add(number1, number2));
		
		System.out.println("number 1 - number 2 = " + subtract(number1, number2));
		
		System.out.println("number 1 * number 2 = " + multiply(number1, number2));
		
		System.out.println("number 1 / number 2 = " + divide(number1, number2));
	}
	
	
	public static double add(double a, double b)
	{
		return(a+b);
	}
	
	public static double subtract(double a, double b)
	{
		return(a-b);
	}
	
	public static double multiply(double a, double b)
	{
		return(a*b);
	}
	
	public static double divide(double a, double b)
	{
		return(a/b);
	}
}
