package easy_coding;
//Kevin Rivera - Revature

import java.util.Scanner;
import java.util.StringTokenizer;

//Assignment Week 1: Easy Coding Exercises - Problem 36.
//This program takes 3 input arguments, two integers, and an operator
//and performs the operation with the given arguments.

public class Prob_36 {
	public static void main(String[] args) {
		arithmetic();
	}

	public static void arithmetic() {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two integers, separated by space, followed by an operator (+, -, *, /).");
		String str = input.nextLine();
		StringTokenizer tokenized = new StringTokenizer(str);
		int result = 0;
		
		//Get the arguments and put them in their variables.
		int num1 = Integer.parseInt(tokenized.nextToken());
		int num2 = Integer.parseInt(tokenized.nextToken());
		String op = tokenized.nextToken();
		
		//Do the operation depending on the operator
		if (op.equals("+"))
			result = num1 + num2;
		else if (op.equals("-"))
			result = num1 - num2;
		else if (op.equals("*"))
			result = num1 * num2;
		else if (op.equals("/"))
			result = num1 / num2;
		
		System.out.println("Result is: " + result);
		
		input.close();	
	}
}
