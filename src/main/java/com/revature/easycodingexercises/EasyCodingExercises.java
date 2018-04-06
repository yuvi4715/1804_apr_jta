package com.revature.easycodingexercises;

import java.util.Scanner;

public class EasyCodingExercises {

	public static void main(String[] args) {
		checkPassFail(50);
		checkOddEven(78);
		printNumberInWord(9, true, true);
		
//		keyboardScanner();
		
	}
	
	// Question 32
	static void checkPassFail(int mark) {
		String result = mark >= 50 ? "PASS" : "FAIL";
		System.out.println(result);
	}
	
	// Question 33
	static void checkOddEven(int n) {
		String result = n % 2 != 0 ? "Odd Number" : "Even Number";
		System.out.println(result);
	}
	
	// Question 34
	static void printNumberInWord(int n, boolean isDaytime, boolean isWeekday) {
		if (isDaytime) {
			System.out.println("It is daytime");
			if (isWeekday) {
				System.out.println("And it's a weekday");
			}
		}
		
		switch(n) {
		case 1:
			System.out.println("ONE");
			break;
		case 2:
			System.out.println("TWO");
			break;
		case 3:
			System.out.println("THREE");
			break;
		case 4:
			System.out.println("FOUR");
			break;
		case 5:
			System.out.println("FIVE");
			break;
		case 6:
			System.out.println("SIX");
			break;
		case 7:
			System.out.println("SEVEN");
			break;
		case 8:
			System.out.println("EIGHT");
			break;
		case 9:
			System.out.println("NINE");
			break;
		default:
			System.out.println("OTHER");
		}
	}
	
	// Question 35
	static void keyboardScanner() {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter an int: ");
		String stringInput = scanner.nextLine();
		System.out.println("You entered: " + stringInput);
		
		System.out.print("Enter a double: ");
		stringInput = scanner.nextLine();
		System.out.println("You entered: " + stringInput);
		
		System.out.print("Enter a String: ");
		stringInput = scanner.nextLine();
		System.out.println("You entered: " + stringInput);
	}

}
