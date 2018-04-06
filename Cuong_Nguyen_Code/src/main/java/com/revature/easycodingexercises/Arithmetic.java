package com.revature.easycodingexercises;

import java.util.Scanner;

public class Arithmetic {

	public static void main(String[] args) {
		/*
		 * 36. Write a program called Arithmetic that takes three command-line
		 * arguments: two integers followed by an arithmetic operator (+, -, * or /).
		 * The program shall perform the corresponding operation on the two integers and
		 * print the result.
		 */
		Scanner user = new Scanner(System.in);
		System.out.println("Please enter first integer to operate on: ");
		int firstNumber = user.nextInt();
		System.out.println("Please enter second integer to operate on: ");
		int secondNumber = user.nextInt();
		System.out.println("Pick an operator for the two integers you picked: +, -, * or /");
		char operator = user.next().charAt(0);
		if (operator == '+') {
			int sum = firstNumber + secondNumber;
			System.out.println("You chose to add the two numbers, your result is: "+ sum);
		}
		if (operator == '-') {
			int subtract = firstNumber - secondNumber;
			System.out.println("You chose to subtract the two numbers, your result is: " + subtract);
		}
		if (operator == '*') {
			int multiply = firstNumber * secondNumber;
			System.out.println("You chose to multiply the two numbers, your result is: " + multiply);
		}
		if (operator == '/') {
			int divide = firstNumber / secondNumber;
			System.out.println("You chose to divide the two numbers, your result is: " + divide);
		}
		user.close();
	}

}
