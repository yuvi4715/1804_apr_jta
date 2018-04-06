package com.revature.advancedCodingExercises;

public class FizzBuzz {
//problem 41
	public static void main(String[] args) {
		fizz();

	}

	public static void fizz() {
		for(int i =0; i<50; i++) {
			if (((i % 5) == 0) && ((i % 3) == 0)) {
				System.out.println("FizzBuzz");
			}
			else if((i % 5) == 0) {
				System.out.println("Buzz");
			}
			else if((i % 3) == 0) {
				System.out.println("Fizz");
			}
			else {
				System.out.println(i);
			}
		}
	}
}
