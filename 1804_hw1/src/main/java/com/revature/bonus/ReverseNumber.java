package com.revature.bonus;

// Solution to hw1 bonus problem #52

public class ReverseNumber {

	public static int reverseNumber(int num) {
		
		String numString = String.valueOf(num);
		char[] numArray = numString.toCharArray();
		char[] reversedArray = new char[numString.length()];
		
		for (int i = 0; i < numString.length(); i++) {
			
			reversedArray[i] = numArray[numString.length()-i-1];
		}
		
		return Integer.parseInt(String.valueOf(reversedArray));
	}
	
	public static void main(String[] args) {
		
		// Test reverseNumber method
		System.out.println("The reverse of 123 is: " + reverseNumber(123));
		System.out.println("The reverse of 456 is: " + reverseNumber(456));
		System.out.println("The reverse of 123456 is: " + reverseNumber(123456));
		System.out.println("The reverse of 67859 is: " + reverseNumber(67859));
		System.out.println("The reverse of 789 is: " + reverseNumber(789));
		System.out.println("The reverse of 123657 is: " + reverseNumber(123657));
	}
}
