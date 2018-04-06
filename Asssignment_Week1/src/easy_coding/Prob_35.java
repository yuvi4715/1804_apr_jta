package easy_coding;

import java.util.Scanner;

//Kevin Rivera - Revature
//Assignment Week 1: Easy Coding Exercises - Problem 35.
//This takes input from the user via a scanner, and prints the collected input.

public class Prob_35 {
	public static void main(String[] args) {
		keyboardScanner();
	}

	public static void keyboardScanner() {
		int inputInt;
		String inputString;
		double inputDouble;
		Scanner input = new Scanner(System.in);
		
		System.out.println("Type an int: ");
		inputInt = input.nextInt();
		System.out.println("You entered: " + inputInt + "\n");
		System.out.println("Type a string: ");
		inputString= input.next();
		System.out.println("You entered: "+ inputString + "\n");
		System.out.println("Type a double: ");
		inputDouble = input.nextDouble();
		System.out.print("You entered: " + inputDouble + "\n");
		
		//Always close your resources!!
		input.close();
	}
}
