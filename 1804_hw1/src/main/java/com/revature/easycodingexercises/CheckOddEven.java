package com.revature.easycodingexercises;

// Solution to hw1 problem #33

public class CheckOddEven {

	public static void oddEven(int number) {
		
		if (number%2 == 0) {
			System.out.println("Even Number");
		} else {
			System.out.println("Odd Number");
		}
	}
	
	public static void main(String[] args) {
		
		oddEven(1);
		oddEven(3);
		oddEven(10);
		oddEven(22);
		oddEven(17);
		oddEven(44);
		oddEven(45);
		oddEven(108);
		oddEven(1000);
	}
}
