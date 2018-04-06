package com.revature.AdvancedCodingExercises;

import java.util.Calendar;

import com.revature.FileIO.Employee;

public class MethodsACE {

	//Question 38
	public String charReplacer(char toReplace, char replaceWith, String target) {
		return target.replace(toReplace, replaceWith);
	}

	//Question 39
	public void dateCheck() {
		Calendar c = Calendar.getInstance();
	}
	
	//Question 40
	public void fibonacciIterated() {
		long current = 1, prev = 0, storage = 0;
		for(int i = 0; i < 100; i++) {
			storage = current;
			current += prev;
			System.out.print(current + ", ");
			prev = storage;
		}
	}
	
	public void fibonacciRecursive(long prev, long current, int i) {
		long storage = current;
		if(i<100) {
			current += prev;
			System.out.print(current + ", ");
			fibonacciRecursive(storage, current, ++i);
		}
		else {
			return;
		}
	}
	
	//Question 41
	public void fizzBuzz() {
		for(int i = 1; i <= 50; i++) {
			if(i%3 == 0 && i%5 != 0) {
				System.out.print("fizz, ");
			}
			else if(i%3 != 0 && i%5 == 0) {
				System.out.print("buzz, ");
			}
			else if(i%3 ==0 && i%5 == 0) {
				System.out.print("fizzbuzz, ");
			}
			else {
				System.out.print(i + ", ");
			}
		}
	}
	
	//Question 43
	public boolean isArmstrong(int n) {
		int starter = n;
		int sum = 0;
		while(n>0) {
			sum += Math.pow((n%10), 3);
			n /= 10;
		}
		System.out.println(sum);
		String s = "Hello";
		return (sum ==starter);
	}
	
	//Question 44
	public String reverseString(String s){
	    if (s.length() == 0) 
	         return s;
	    return reverseString(s.substring(1)) + s.charAt(0);
	}
	
	//Question 45
	public boolean isPrime(int n) {
		if(n<= 1) {
			return false;
		}
		
		for(int i = 2; i < n/2; i++) {
			if(n%i == 0) {
				return false;
			}
		}
		
		return true;
	}
	
	
	
}

