package com.revature.EasyCodingExercises;

import java.util.Scanner;

public class KeyboardScanner {
//problem 35
	public static void main(String[] args) {
		try {
			Scanner keyboard = new Scanner(System.in);
			System.out.print("Enter an integer: ");
			int num1 = keyboard.nextInt();
			System.out.print("Enter a double: ");
			double num2 = keyboard.nextDouble();
			keyboard.nextLine();
			System.out.print("Enter a string: ");
			String s = keyboard.nextLine();
			
			System.out.print("" + num1 +" "+ + num2 + " "+ s);
			keyboard.close();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
