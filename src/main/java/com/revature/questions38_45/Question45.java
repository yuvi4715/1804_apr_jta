package com.revature.questions38_45;

public class Question45 {

	public static void main(String[] args) {

		System.out.println(checkPrime(1));   //true
		System.out.println(checkPrime(3));   //true
		System.out.println(checkPrime(100));  //false
		System.out.println(checkPrime(131));  //true 
		System.out.println(checkPrime(144));  //false
	}
	
	
	public static boolean checkPrime(int num) {
		boolean isPrime = true;

		int i = 2;
		while (i <= num / 2) {
			if (num % i == 0) {
				isPrime = false;
				break;
			}
			i++;
		}
		return isPrime;
	}
}
