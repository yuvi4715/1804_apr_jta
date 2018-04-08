package com.revature.projrctzero;



import java.math.*;

public class Question40FibonacciIte {
	
//	Write a Java program to print the first 100 Fibonacci numbers using iteration. Rewrite using recursion.
//	
//
//	1) write a program to print first 100 fibonacci numbers using iteration
//	2) write a program to print first 100 fibonacci numbers using recursion
//	Let see the logic and then programs
//
//	what is fibnacci numbers, A fibonacci series is a series of number in which each number, except first two numbers, is sum of prceding two numbers. Firt two numbers are user defined, usually taken both 1.
//	example of fibonacci series is 1 1 2 3 5 8 13 21. . .
//	
//	using the iteration:
//	first two numbers are printed manually and next numbers will be printed by deriving as per definition. What we will do is store last two numbers in some variable and print the sum of thses two and updating both numbers.
//	Here is the program screenshot:



	
	public static void main(String[] args){
	//set initial fibonacci numbers
	BigInteger a = new BigInteger("1");
	BigInteger b = new BigInteger("1");
	int i=0;
	//print initial numbers
	System.out.print(a+ " " + b + " ");
	//prints next 98 numbers
	for(i=0;i<98;i++){
	//generate next number from preceding numbers
	BigInteger c = a.add(b);
	//print new number
	System.out.print(c+" ");
	//update last numbers
	a=b;
	b=c;
	}
	}
	}


