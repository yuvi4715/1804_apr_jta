package com.revature.easycodingexercises;

import java.util.Scanner;

public class KeyboardScanner {
	public static void main(String[] args) {
		/*
		 * 35. Write a program called KeyboardScanner to prompt user for an integer, a
		 * double, and a String. Print the input onto the console.
		 */
		System.out.println("Please enter an integer: ");
		Scanner User = new Scanner(System.in);
		Integer newInteger = User.nextInt();
		System.out.println("The integer you chose was: " + newInteger);
		System.out.println();

		System.out.println("Please enter a double: ");
		Double newDouble = User.nextDouble();
		System.out.println("The double you chose was: " + newDouble);
		System.out.println();

		System.out.println("Please enter a string: ");
		String newString = User.next();
		System.out.println("The string you chose was: " + newString);
		User.close();
	}

}
