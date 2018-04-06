package com.revature.advancedcodingexercises;

// Solution to hw1 problem #41

public class FizzBuzz {

	public static void main(String[] args) {
		
		for (int i = 1; i <= 50; i++) {
			
			if (i%3 == 0) {
				
				if (i%5 == 0) {
					System.out.println("FizzBuzz");
				}else {
					System.out.println("Fizz");
				}
			} else if (i%5 == 0){
				System.out.println("Buzz");
			} else {
				System.out.println(i);
			}
		}
	}
}
