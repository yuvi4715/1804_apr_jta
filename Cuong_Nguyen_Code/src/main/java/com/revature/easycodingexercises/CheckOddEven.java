package com.revature.easycodingexercises;

import java.util.Scanner;

public class CheckOddEven {
	/*
	 * 33. Write a program called CheckOddEven which prints "Odd Number" if the int
	 * variable “number” is odd, or “Even Number” otherwise. Hint: you may use
	 * modulus operator.
	 */
	public static void main(String[] args) {
		Scanner user = new Scanner(System.in);
		System.out.println("Please enter a number to check if its odd or even: ");
		int number = user.nextInt();
		int test = number % 2;
		if (test == 0)
			System.out.println("Even Number");
		else
			System.out.println("Odd Number");
		user.close();
	}


}
