package com.revature.corejava;

public class Assignment_Java {

	public static void main(String[] args)

	{
		/*
		 * 1.Write a program to add, subtract, multiply and divide two non-zero
		 * hard-coded numbers.
		 */
		// Hard-coded numbers are defined numbers, not variables
		// In this case, 10 and 2 are our non-zero hard-coded numbers
		int Add, Subtract, Multiply, Divide;
		Add = 10 + 2;
		Subtract = 10 - 2;
		Multiply = 10 * 2;
		Divide = 10 / 2;
		System.out.println("10 + 2 = ." + Add);
		System.out.println("10 - 2 = ." + Subtract);
		System.out.println("10 * 2 = ." + Multiply);
		System.out.println("10 / 2 = ." + Divide);
		/*
		 * 2.Write a program to search for the greatest of three numbers using
		 * Short-circuit Operators and print the result.
		 */
		int FirstNumber = 1;
		int SecondNumber = 5;
		int ThirdNumber = 2;
		/*
		 * && and || are short-circuit operators, they do not evaluate the right side if
		 * not necessary.
		 */
		boolean FirstPosition = (FirstNumber > ThirdNumber) && (FirstNumber > SecondNumber);
		boolean SecondPosition = (SecondNumber > FirstNumber) && (SecondNumber > ThirdNumber);
		boolean ThirdPosition = (ThirdNumber > FirstNumber) && (ThirdNumber > SecondNumber);
		System.out.println(FirstPosition);
		System.out.println(SecondPosition);
		System.out.println(ThirdPosition);
		/*
		 * 3.Write a program – declare two variables a & b and initialize them to true
		 * and false respectively. Get the output of the following computations: !a a |
		 * b (!a & b) | (a & !b)
		 */
		boolean a = true;
		boolean b = false;
		System.out.println(!a);
		System.out.println(a | b);
		System.out.println((!a & b) | (a & !b));
	}
}
