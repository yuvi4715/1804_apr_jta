package com.revature.strings;

import java.util.StringTokenizer;

public class StringExample {

	public static void main(String[] args) {
		// example();

		int x = 10, y = 20;
		performanceCheck(x, y);
		System.out.println(x + " and " + y);
		StringExample s1 = new StringExample();
		s1.stringTokens();
		s1.moreFunStrings();
	}

	static void example() {
		String s1 = "Value of my string";
		String s5 = "Value of my string";
		String s2 = new String("Value of my string");
		StringBuffer s3 = new StringBuffer("Value of string buffer");
		StringBuilder s4 = new StringBuilder("Value of string builder");

		// System.out.println(s1.hashCode());
		// System.out.println(s5.hashCode());
		// System.out.println(s2.hashCode());

		// if (s1 == s5) {
		// System.out.println(true);
		// }
		//
		// if (s1 != s2)
		// System.out.println(true);

		if (s1.equals(s2)) {
			System.out.println(true);
		}

		if (s1.equals(s5))
			System.out.println(true);
	}

	static void performanceCheck(int x, int y) {
		// which is better performing - string or string buffer or string builder?
		// string buffer is synchronized where as string builder is not
		// strings are immutable where as buffer and builder are mutable
		long starttime1 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			String s1 = new String("testing the performance");
		}
		long endtime1 = System.nanoTime();
		System.out.println(endtime1 - starttime1);

		long starttime2 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			StringBuffer s2 = new StringBuffer("testing the performance");
		}
		long endtime2 = System.nanoTime();
		System.out.println(endtime2 - starttime2);

		long starttime3 = System.nanoTime();
		for (int i = 0; i < 10000; i++) {
			StringBuilder s3 = new StringBuilder("testing the performance");
		}
		long endtime3 = System.nanoTime();
		System.out.println(endtime3 - starttime3);

		x = x + 1;
		y = y + 1;
	}

	void moreFunStrings() {
		String s = new String("lets learn strings for next 10 weeks");
		System.out.println(s.substring(2, 20));
		System.out.println(s.length());
		System.out.println(s.toCharArray());
		System.out.println(s.charAt(10));
		// System.out.println(s.CASE_INSENSITIVE_ORDER);
		
		for (String a : s.split(" ")) {
			System.out.println(a);
		}
	}

	void stringTokens() {

		String s1 = "i like to play pokemon, while walking on the street, while driving, everywhere else";
		StringTokenizer t = new StringTokenizer(s1, ",");
		while (t.hasMoreTokens()) {
			System.out.println(t.nextToken());
		}
	}

}
