package com.revature.questions01_06;

public class Question04 {

	public static void main(String[] args) {
	
		number_operation(11, 23);
		System.out.println("------------");
		number_operation(44,1);
		
	}
	
	
	public static void number_operation(double a, double b) {
		
		System.out.println("Addition: " + Double.toString(a + b));
		System.out.println("Subtraction: " + Double.toString(a - b));
		System.out.println("Multiplication: " + Double.toString(a * b));
		System.out.println("Division: " + Double.toString(a / b));

	}
}
