package com.revature.advancedCodingExercises;

public class DeterminePrime {
	//problem 45
	
	public static void main(String[] args) {
		System.out.println(determineIfPrime(10007));
	}

	public static boolean determineIfPrime(int num) {
		if(num == 2) {
			return true;
		}
		else {
			for(int i = 2; i*i<num; i++) {
				if (num % i == 0 || num == 1)
					return false;
			}
		}
		return true;
	}
}
