package com.revature.corejava;

//Answer for hw1 question #2

public class GreatestOfThree {

	public static int greatestOfThree(int a, int b, int c) {
		
		if (a > b && a > c) {
			return a;
		} else if (b > a && b > c) {
			return b;
		} 
		
		return c;
	}
	
	public static void main(String[] args) {
		
		int a = 20, b = 15, c = 17;
		
		System.out.println(greatestOfThree(a,b,c));
	}
}
