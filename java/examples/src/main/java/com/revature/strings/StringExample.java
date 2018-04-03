package com.revature.strings;

public class StringExample {

	public static void main(String[] args) {
		//example();
		
		int x = 10, y = 20;
		performanceCheck(x, y);
		System.out.println(x + " and " + y);
	}
	
	static void example() {
		String s1 = "Value of my string";
		String s5 = "Value of my string";
		String s2 = new String("Value of my string");
		StringBuffer s3 = new StringBuffer("Value of string buffer");
		StringBuilder s4 = new StringBuilder("Value of string builder");
		
//		System.out.println(s1.hashCode());
//		System.out.println(s5.hashCode());
//		System.out.println(s2.hashCode());
		
//		if (s1 == s5) {
//			System.out.println(true);
//		} 
//		
//		if (s1 != s2)
//			System.out.println(true);
		
		if (s1.equals(s2)) {
			System.out.println(true);
		} 
		
		if (s1.equals(s5))
			System.out.println(true);
	}
	
	static void performanceCheck(int x, int y) {
		//which is better performing - string or string buffer or string builder? 
		long starttime1 = System.nanoTime();
		for (int i=0; i< 10000; i++) {
			String s1 = new String("testing the performance");
		}
		long endtime1 = System.nanoTime();
		System.out.println(endtime1 - starttime1);
		
		long starttime2 = System.nanoTime();
		for (int i=0; i< 10000; i++) {
			StringBuffer s2 = new StringBuffer("testing the performance");
		}
		long endtime2 = System.nanoTime();
		System.out.println(endtime2 - starttime2);
		
		long starttime3 = System.nanoTime();
		for (int i=0; i< 10000; i++) {
			StringBuilder s3 = new StringBuilder("testing the performance");
		}
		long endtime3 = System.nanoTime();
		System.out.println(endtime3 - starttime3);
		
		x = x + 1;
		y = y + 1;
	}
	
	
	

}
