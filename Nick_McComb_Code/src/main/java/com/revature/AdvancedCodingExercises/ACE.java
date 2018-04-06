package com.revature.AdvancedCodingExercises;

public class ACE {

	public static void main(String[] args) {
		MethodsACE m = new MethodsACE();
		System.out.println("Question 38: " + m.charReplacer('a', 'z', "arthur the aardvark"));
		
		System.out.println("Question 39: ");
		
		System.out.println("Question 40: Fibonacci numbers");
		m.fibonacciIterated();
		m.fibonacciRecursive(0, 1, 0);
		
		System.out.println("Question 41: Fizzbuzz");
		m.fizzBuzz();
		
		System.out.println("Question 42: Look at Q42Comparators class");
		
		System.out.println("Question 43: Armstrong numbers");
		System.out.println(m.isArmstrong(153));
		
		System.out.println("Question 42: String reverser");
		System.out.println(m.reverseString("String reverser"));
		
		System.out.println("Question 43: Primality check");
		System.out.println(m.isPrime(11));
	}
}
