package advanced_coding;
//Kevin Rivera - Revature
//Assignment Week 1: Advanced Coding: Problem 41.
//This class prints Fizz when a number is multiple of 3, Buzz when it's
//a multiple of 5, and FizzBuzz when it's a multiple of 3 and 5.

public class FizzBuzz {
	public static void main(String[] args) {
		for(int i = 0; i < 51; i++) {
			if (i % 3 == 0 && i % 5 == 0)
				System.out.println("FizzBuzz");
			else if (i % 3 == 0)
				System.out.println("Fizz");
			else if (i % 5 == 0)
				System.out.println("Buzz");
			else
				System.out.println(i);
		}
	}
}
