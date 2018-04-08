package com.revature.hello;

public class Syntax {
	public static void main(String[] args) {

		System.out.println("4:");
		add(1, 2);
		sub(1, 2);
		mult(1, 2);
		div(1, 2);

		// 5
		System.out.println("5:");
		System.out.println(A.add(1, 2));
		A.subtract(1, 2);
		A.multiply(1, 2);
		A.divide(1, 2);

		// 6
		if (1 == Math.random())
			;
		else {
			;
		}

		for (int i = 0; i < 5; ++i)
			continue;

		do {
			;
		} while (false);

		char c = 'a';
		switch (c) {
		case 'a':
			break;
		case 'b':
			;
		default:
			;

		}

		int[] i = { 0, 1 };
		for (int x : i) {
			x = x - 1;
		}

	}

	public static int add(int x, int y) {
		return x + y;
	}

	public static int sub(int x, int y) {
		return x - y;
	}

	public static int mult(int x, int y) {
		return x * y;
	}

	public static int div(int x, int y) {
		return x / y;
	}
}

class A {
	public static int add(int x, int y) {
		return x + y;
	}

	public static int subtract(int x, int y) {
		return x - y;
	}

	public static int multiply(int x, int y) {
		return x * y;
	}

	public static int divide(int x, int y) {
		return x / y;
	}

}
