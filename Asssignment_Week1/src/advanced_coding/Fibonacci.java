package advanced_coding;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Coding: Problem 40.
//This class calculates the first 15 fibonacci numbers using recursion
//and iteration. The exercise asked for 100, but it takes too long to calculate.

public class Fibonacci {
	public static void main(String[] args) {
		//Number to be fibonacci'ed
		int number = 15;
		
		//First run is for recursive fibonacci
		System.out.println("Print fibonacci(rec) numbers up to: " + number);
		for (int i = 1; i < number; i++) {
			System.out.print(fibRec(i) + " ");
		}
		
		//Second run is for iterative fibonacci
		System.out.println("\nPrint fibonacci(it) numbers up to: " + number);
		for (int i = 1; i < number; i++) {
			System.out.print(fibIt(i) + " ");
		}
	}

	// Recursive fibonacci
	public static long fibRec(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		return fibRec(number - 1) + fibRec(number - 2);
	}

	// Iterative fibonacci
	public static long fibIt(int number) {
		// Base case
		if (number == 1 || number == 2) {
			return 1;
		}

		int fib1 = 1, fib2 = 1, fibonacci = 1;
		//Start from 3 because base case is already covered
		for (int i = 3; i <= number; i++) {

			//Fibonacci number is sum of previous two Fibonacci number
			fibonacci = fib1 + fib2;
			fib1 = fib2;
			fib2 = fibonacci;

		}
		
		return fibonacci;
	}
}
