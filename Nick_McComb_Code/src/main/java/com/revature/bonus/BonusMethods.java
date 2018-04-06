package com.revature.bonus;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BonusMethods {

	public String midList() {
		LinkedList<String> ll = new LinkedList();
		ll.add("First");
		ll.add("Second");
		ll.add("Third");
		ll.add("Fourth");
		ll.add("Fifth");
		ll.add("Sixth");
		ll.add("Seventh");
		int mid = (int) Math.ceil(ll.size()/2);
		String s = null;
		for(int i = 0; i <= mid; i++) {
			s = ll.get(i);
		}
		return s;
	}
	
	public int myFactorial(int n) {
		int product = 1;
		for(int i = n; i > 0; i--) {
			product *= i;
		}
		return product;
	}
	
	public boolean isEven(double n) {
		return (n/2.0 == Math.floor(n/2.0));
	}
	
	public boolean isPalindrome(String s) {
		StringBuilder s1 = new StringBuilder();
		s1.append(s);
		return s1.reverse().toString().equals(s);
	}
	
	public void numberGuess() {
		Random r = new Random();
		int value = r.nextInt(100), guess = 0, counter = 0;
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Please enter a number:");
			guess = sc.nextInt();
			if(guess < value) {
				System.out.println("Try higher");
				counter++;
			}
			else if(guess > value) {
				System.out.println("Try higher");
				counter++;
			}
			else {
				System.out.println("You got it in " + counter + " tries");
				System.exit(0);
			}
		}
	}
	
	public void numSwap(int x, int y) {
		System.out.println("Pre-swap: " + x + ", " + y +  "\nSwapping...");
		x = x + y;
		y = x - y;
		x = x - y;
		System.out.println("Post-swap: " + x + ", " + y);
	}
	
	public void distinctArrayElements(Integer n[]) {
		Set<Integer> de = new TreeSet<Integer>();
		de.addAll(Arrays.asList(n));
		System.out.println("Distinct elements: " + de);
	}
	
	public String reverseString(String s){
	    if (s.length() == 0) 
	         return s;
	    return reverseString(s.substring(1)) + s.charAt(0);
	}
	
	public int reverseNumber(Integer n){
		return Integer.parseInt(reverseString(n.toString()));
	}
	
	public void rat() {
		System.out.println("		 ‘ ____ ‘\r\n" + 
				"		  ( ©© )\r\n" + 
				"		   \\  /\r\n" + 
				"       /============\\/\r\n" + 
				"      /  ||  % %  ||\r\n" + 
				"     *   ||  ---- ||\r\n" + 
				"         ¥¥       ¥¥\r\n" + 
				"         “”       “”\r\n" + 
				"");
	}
	
}
