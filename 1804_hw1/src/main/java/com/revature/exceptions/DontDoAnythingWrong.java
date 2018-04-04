package com.revature.exceptions;

import java.util.Scanner;

public class DontDoAnythingWrong {
		
	public static void ducked() throws YouDidSomethingWrongException {
		
		decision();		
	}
	
	public static void decision() throws YouDidSomethingWrongException {
		
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter '1' for good behavior or '0' to throw exception: ");
		int inp = reader.nextInt(); // Scans the next token of the input as a boolean.
		
		while (inp != 1 && inp != 0) {
			inp = reader.nextInt();
		}
		
		reader.close(); // user input finished
		
		if (inp == 0) {
			throw new YouDidSomethingWrongException();			
		}else {
			System.out.println("Good Job!");
		}
	}
	
	public static void main(String[] args) {
		try {
			ducked();
			System.exit(0); // Despite the system exit the finally block still runs
		}
		catch (YouDidSomethingWrongException ex) {
			System.out.println(ex.getMessage());
		}
		finally {
			System.out.println("Bye! Have a beautiful time! <3");
		}
	}
}
