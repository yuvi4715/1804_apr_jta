package com.revature.hello;

public class Prime {
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			if (checkPrime(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean checkPrime(int num) {
		if (num <= 1) {
			return false;
		}

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}

		return true;
	}
}