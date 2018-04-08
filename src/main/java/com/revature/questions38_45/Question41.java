package com.revature.questions38_45;

public class Question41 {

	public static void main(String[] args) {

		fizzBuzz();
	}

	public static void fizzBuzz() {

		for (int i = 1; i <= 50; i++) {

			if (i % 15 == 0) {
				System.out.println("FizzBuzz");

			} else if (i % 3 == 0) {
				System.out.println("Fizz");

			} else if (i % 5 == 0) {
				System.out.println("Buzz");

			} else {
				System.out.println(i);
			}

		}

	}

}
