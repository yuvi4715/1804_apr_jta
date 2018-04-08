package com.revature.bonus;

// Solution to hw1 bonus problem #56

public class Palindrome {

	public static boolean isPalindrome(String s) {
		
		char[] sArray = s.toCharArray();
		
		for (int i = 0; i < s.length(); i++) {
			
			if (sArray[i] != sArray[s.length()-i-1]) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		
		// Test isPalindrome method
		System.out.println("Is 'mom' a palindrome? " + isPalindrome("mom"));
		System.out.println("Is 'brother' a palindrome? " + isPalindrome("brother"));
		System.out.println("Is 'solos' a palindrome? " + isPalindrome("solos"));
		System.out.println("Is 'neveroddoreven' a palindrome? " + isPalindrome("neveroddoreven"));
	}
}
