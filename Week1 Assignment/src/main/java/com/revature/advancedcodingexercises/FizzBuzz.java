package com.revature.advancedcodingexercises;

public class FizzBuzz {

	public static void main(String[] args) {
		/*
		 * 41. Write a Java program that prints the numbers from 1 to 50. But for
		 * multiples of three print "Fizz" instead of the number and for the multiples
		 * of five print "Buzz". For numbers which are multiples of both three and five
		 * print "FizzBuzz"
		 */
		int numberPrinter = 0;
		while (numberPrinter < 50) {
			++numberPrinter;
			int MultipleThree, MultipleFive;
			MultipleThree = numberPrinter % 3;
			MultipleFive = numberPrinter % 5;
			if (MultipleThree != 0 && MultipleFive != 0)
				System.out.println(numberPrinter);
			if (MultipleThree == 0 & MultipleFive != 0)
				System.out.println("Fizz");
			if (MultipleFive == 0 & MultipleThree != 0)
				System.out.println("Buzz");
			if (MultipleFive == 0 & MultipleThree == 0)
				System.out.println("FizzBuzz");
		}
	}

}
