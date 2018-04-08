package com.revature.hello;

public class CoreJava {
	public static void main(String[] args) {
		int x = 1 + 2;
		int y = 2 - 3;
		int z = 3 / 5;
		x = 5 * 7;
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
	}
}
