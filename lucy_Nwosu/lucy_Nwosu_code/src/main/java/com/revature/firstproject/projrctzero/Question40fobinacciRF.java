package com.revature.projrctzero;


import java.math.*;
public class Question40fobinacciRF {
	
//		using a recursive factor:
//		we need to define a recursive function that will return the nth fibonacci number by calling itself recursively 
//		for n-1 and n-2. Note that we are using BigInteger as the value of higher fibonacci numbers can not be stored 
//		in int or long, it will overflow. Note that program will be very slow in this case unless we store the previously
//		calculate values of fibonacci series
//		
			public static void main(String[] args){
			//set initial fibonacci numbers
			BigInteger a = new BigInteger("1");
			BigInteger b = new BigInteger("1");
			int i=0;
			//print initial numbers
			System.out.print(a+ " " + b + " ");
			//prints next 98 numbers from 3 to 100
			for(i=3;i<100;i++){
			//call Fib to get ith fibonacci number
			BigInteger c = Fib(i);
			System.out.print(c+" ");
			}
			}
			public static BigInteger Fib(int n){
			if(n==1 || n==2){
			//if 1 or 2, return 1
			BigInteger x = new BigInteger("1");
			return x;
			}
			else{
			//calculate fib(n) value by recursively cal;ling itself
			BigInteger x = Fib(n-1).add(Fib(n-2));
			return x;
			}
			}
			}
