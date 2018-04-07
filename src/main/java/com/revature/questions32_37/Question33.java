package com.revature.questions32_37;

public class Question33 {

	public static void main(String[] args) {
		
		int a = 2;
		int b = 3;
		
		checkOddEven(a);  //Even
		checkOddEven(b);  //Odd
		
	}
	
	
	
	public static void checkOddEven(int number) {
		
		if ((number % 2) == 1) {
			System.out.println("Odd");
		}
		else {
			System.out.println("Even");
		}
	}
	
}
