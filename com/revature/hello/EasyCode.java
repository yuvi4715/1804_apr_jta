package com.revature.hello;

import java.util.Scanner;

public class EasyCode {

	// Easy Coding Exercise
	// Write a program called CheckPassFail which prints "PASS" if the int variable
	// "mark" is more than or equal to 50; or prints "FAIL" otherwise.
	// Write a program called CheckOddEven which prints "Odd Number" if the int
	// variable “number” is odd, or “Even Number” otherwise. Hint: you may use
	// modulus operator.
	// Write a program called PrintNumberInWord which prints "ONE", "TWO",... ,
	// "NINE", "OTHER" if the int variable "number" is 1, 2,... , 9, or other,
	// respectively. Use (a) a "nested-if" statement; (b) a "switch-case" statement.
	// Write a program called KeyboardScanner to prompt user for an int, a double,
	// and a String. Print the input onto the console.
	// Write a program called Arithmetic that takes three command-line arguments:
	// two integers followed by an arithmetic operator (+, -, * or /). The program
	// shall perform the corresponding operation on the two integers and print the
	// result.
	// Write a program called GradesStatistics, which reads in n grades (of int
	// between 0 and 100, inclusive) and displays the average, minimum, maximum, and
	// standard deviation. Your program shall check for valid input. You should keep
	// the grades in an int[] and use a method for each of the computations.

	public static void main(String[] args) {
		{
			// CheckPassFail
			int mark = 50;

			if (mark >= 50)
				System.out.println("PASS");
			else
				System.out.println("FAIL");
		}
		{
			int num = 2;
			// CheckOddEven
			if (num % 2 == 0)
				System.out.println("Even number");
			else
				System.out.println("Odd number");
		}
		{
			// PrintNumberInWord
			int number = 6;
			if (number == 0)
				System.out.println("ZERO");
			else if (number == 1)
				System.out.println("ONE");
			else if (number == 2)
				System.out.println("TWO");
			else if (number == 3)
				System.out.println("THREE");
			else if (number == 4)
				System.out.println("FOUR");
			else if (number == 5)
				System.out.println("FIVE");
			else if (number == 6)
				System.out.println("SEX");
			else if (number == 7)
				System.out.println("SEVEN");
			else if (number == 8)
				System.out.println("EIGHT");
			else if (number == 9)
				System.out.println("NINE");
			else
				System.out.println("OTHER");
		}
		{
			// KeyboardScanner
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter an int: ");
			int i = Integer.parseInt(sc.nextLine());
			System.out.println("echoing input: " + i);
			System.out.println("Enter a double: ");
			double d = Double.parseDouble(sc.nextLine());
			System.out.println("echoing input: " + d);
			System.out.println("Enter a String: ");
			String s = sc.nextLine();
			System.out.println("echoing input: " + s);
			sc.close();
		}
	}
}
