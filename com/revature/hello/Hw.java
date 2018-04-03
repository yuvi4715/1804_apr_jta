// import java.util.*;

package com.revature.hello;

class Hw {
	// class Inner{

	// }
	public static void main(String args[]) {
		// 1
		int x = 1 + 2;
		int y = 2 - 3;
		int z = 3 / 5;
		int w = 5 * 7;
		System.out.println("1: finished.");

		// 2
		int ans;
		if ((x > y) && (x > z))
			ans = x;
		else if (y > z)
			ans = y;
		else
			ans = z;
		System.out.println("2:  " + ans);

		System.out.println("3:");
		boolean a = true, b = false;
		System.out.println(!a);
		System.out.println(a | b);
		System.out.println((!a & b) | (a & !b));

		System.out.println("3:");
		add(1, 2);
		sub(1, 2);
		mult(1, 2);
		div(1, 2);

		// 5
		// A.add(1,2);
		// A.subtract(1,2);
		// A.multiply(1,2);
		// A.divide(1,2);
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
