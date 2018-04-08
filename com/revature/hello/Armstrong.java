package com.revature.hello;

public class Armstrong {
	// Write a Java program to check if a number is Armstrong or not.

	public static void main(String[] args) {
		for (int i = 0; i < 1000; i++) {
			if (a(i))
				System.out.println(i);
			
		}
		
//		System.out.println(a(179));
	}

	public static boolean a(int x) {
		if (x < 100) {
			return false;
		}

		int a = x % 10;
		int b = (x / 10) % 10;
		int c = (x / 100) % 10;
//		System.out.println(b);
//		System.out.println(c);

		int armstrong = (int) (Math.pow(a, 3) + Math.pow(b, 3) + Math.pow(c, 3));
//		System.out.println(armstrong);

		if (x == armstrong)
			return true;
		else

			return false;
	}

}
