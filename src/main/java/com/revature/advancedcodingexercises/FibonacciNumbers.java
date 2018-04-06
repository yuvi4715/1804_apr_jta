package com.revature.advancedcodingexercises;

public class FibonacciNumbers {

	public static void main(String[] args) {
		// 40. Write a Java program to print the first 100 Fibonacci numbers using
		// iteration. Rewrite using recursion.

		int firstFibonacci = 0;
		int secondFibonacci = 1;
		int numberFibonacci = 100;
		System.out.print(firstFibonacci + " " + secondFibonacci);

		for (int i = 2; i < numberFibonacci; ++i) {
			int thirdFibonacci = firstFibonacci + secondFibonacci;
			System.out.print(" " + thirdFibonacci);
			firstFibonacci = secondFibonacci;
			secondFibonacci = thirdFibonacci;
		}
		System.out.println();
		System.out.println("Recursion in progress...");
		FibonacciNumbers Recursion = new FibonacciNumbers();
		int recursionNumber = Recursion.recursion(15);
		System.out.println(recursionNumber);
	}
    public int recursion(int numberFibonacci)
    {
        if(numberFibonacci <= 1){
            return numberFibonacci;
        }
      
        return recursion(numberFibonacci-1) + recursion(numberFibonacci -2);
    }

}