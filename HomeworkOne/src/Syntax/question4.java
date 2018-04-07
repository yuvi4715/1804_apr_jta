// Write a program to add, subtract, multiply and divide two numbers using methods with parameters using only one class.

package Syntax;

public class question4 {

	public static void main(String[] args) {
		double x = 4;
		double y = 24;
		System.out.println("The addition output is: " + addition(x, y));
		System.out.println("The subtraction output is: " + subtraction(x, y));
		System.out.println("The multiplication output is: " + multiplication (x, y));
		System.out.println("The division output is: " + division(x, y));
		
	}
	
	public static double addition(double x, double y) {
		return x + y;
	}
	public static double subtraction(double x, double y) {
		return x - y;
	}
	public static double multiplication(double x, double y) {
		return x * y;
	}
	public static double division(double x, double y) {
		return x / y;
	}

}
