package com.revature.bonus;

// Solution to hw1 bonus problem #48

public class Factorial {

	public static int factorial(int num) {
		
		int factorial = 1;;
		
		if (num == 0) {
			return 1;
		}
		
		for (int i = 1; i <= num; i++) {
			
			factorial *= i;
		}
		
		return factorial;
	}
	
	public static void main(String[] args) {
		
		//Test factorial function
		System.out.println("Factorial of 1 is: " + factorial(1));
		System.out.println("Factorial of 2 is: " + factorial(2));
		System.out.println("Factorial of 3 is: " + factorial(3));
		System.out.println("Factorial of 4 is: " + factorial(4));
		System.out.println("Factorial of 5 is: " + factorial(5));
		System.out.println("Factorial of 6 is: " + factorial(6));
		System.out.println("Factorial of 7 is: " + factorial(7));
		System.out.println("Factorial of 8 is: " + factorial(8));
		System.out.println("Factorial of 9 is: " + factorial(9));
		System.out.println("Factorial of 10 is: " + factorial(10));
	}
}
