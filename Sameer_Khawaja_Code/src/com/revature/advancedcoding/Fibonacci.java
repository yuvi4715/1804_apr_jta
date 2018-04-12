package com.revature.advancedcoding;
//problem 40
import java.math.BigInteger;

public class Fibonacci {
	static BigInteger n1 = BigInteger.ZERO, n2 = BigInteger.ONE, n3 = BigInteger.ZERO;

	static void printFibonacci(int count) {
		if (count > 0) {
			n3 = n1.add(n2);
			n1 = n2;
			n2 = n3;
			
			System.out.println(101-count+"          " + n3);
			printFibonacci(count - 1);
		}
	}

	public static void main(String args[]) {
		int count = 101;
		System.out.println("0          " + n1+ "\n1          " + n2);// printing 0 and 1
		printFibonacci(count - 2);// n-2 because 2 numbers are already printed
	}

}
