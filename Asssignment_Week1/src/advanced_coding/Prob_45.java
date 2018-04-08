package advanced_coding;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Coding: Problem 45.
//This class checks if a number is prime or not.

public class Prob_45 {
	public static void main(String[] args) {
		//Number to be tested
		int num = 13;
		checkPrime(num);
	}
	
	public static void checkPrime(int num) {
		boolean prime = true;
		for (int i = 2; i < num; i++) {
			if(num % i == 0) {
				prime = false;
				break;
			}
		}
		
		if(prime)
			System.out.println("The number " + num + " is prime");
		else
			System.out.println("The number " + num + " is not prime");
	}
}
