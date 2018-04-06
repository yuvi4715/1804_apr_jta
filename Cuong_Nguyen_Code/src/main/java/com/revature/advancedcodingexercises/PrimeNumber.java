package com.revature.advancedcodingexercises;
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		// 45. Write a method to determine if a number is prime.
		PrimeNumber optimus = new PrimeNumber();
		Scanner user = new Scanner(System.in);
		System.out.println("Please type a number for prime check: ");
		int primer = user.nextInt();
		optimus.primeChecker(primer);
		user.close();
	}

	boolean primeChecker(int maybePrime) {
		for (int i = 2; i < maybePrime; i++) {
			if (maybePrime % i == 0) {
				System.out.println(maybePrime + " is not a prime number.");
				return false;
			}
		}
		System.out.println(maybePrime + " is a prime number");
		return true;
	}

}
