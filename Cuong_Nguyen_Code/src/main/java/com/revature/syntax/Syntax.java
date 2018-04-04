package com.revature.syntax;

public class Syntax {
	public static void main(String[] args) {
		/*
		 * 4.Write a program to add, subtract, multiply and divide two numbers using
		 * methods with parameters using only one class.
		 */
		new Syntax().Add(5, 2);
		new Syntax().Subtract(5, 2);
		new Syntax().Multiply(5, 2);
		new Syntax().Divide(5, 2);
		/*
		 * 6.Create an example for each control statement.
		 */
		int FirstNumber = 5;
		int SecondNumber = 3;
		int ThirdNumber = 3;
		if (FirstNumber < SecondNumber)
			System.out.println("The first number is less than the second.");
		else if (FirstNumber > SecondNumber)
			System.out.println("The first number is greater than the second.");
		else
			System.out.println("The two numbers are equal.");
		switch (FirstNumber) {
		case 5:
			System.out.println("The first number is equal to five");
			break;
		}
		for (int First = FirstNumber; SecondNumber < First; First--) {
			System.out.println("The first number is greater than the second number");
			if (First == ThirdNumber)
				continue;
		}

		while (SecondNumber <= FirstNumber) {
			System.out.println("Our second number is equal to: " + SecondNumber);
			SecondNumber++;
			System.out.println("Now our second number is added by 1.");
			System.out.println("Our second number is now equal to " + SecondNumber);
		}

		do {

			System.out.println("The first number is higher than the third");
			ThirdNumber = ThirdNumber + 2;

		} while (ThirdNumber < FirstNumber);
	}

	void Add(int x, int y) {
		int adding = x + y;
		System.out.println(adding);

	}

	void Subtract(int x, int y) {
		int subtraction = x - y;
		System.out.println(subtraction);
	}

	void Multiply(int x, int y) {
		int multiplying = x * y;
		System.out.println(multiplying);
	}

	void Divide(int x, int y) {
		int dividing = x / y;
		System.out.println(dividing);
	}

}
