package com.revature.string;

import java.util.StringTokenizer;

public class StringExample {
	public static void main(String[] args) {
		example();
		int x=10;
		int y=11;
		performanceCheck(x,y);
		System.out.println("x =" +x +"y="+y);
		new StringExample().stringTokens();
		//used for methods used just once
		//otherwise can store new object in a variable
		new StringExample().moreFunStrings();
	}

	static void example() {
		String s1="value of my string";
		String s2=new String("value of my string");
		String s5="value of my string";
		StringBuffer s3 =new StringBuffer("value of string buffer");
		StringBuilder s4= new StringBuilder("value of string builder");
		//mutable string
		
		System.out.println(s2.hashCode());
		System.out.println(s1.hashCode());
		System.out.println(s3.hashCode());
		System.out.println(s4.hashCode());
		
		if(s1!=s2) {
			System.out.println(true);
		} 
		if (s1==s5) {
			System.out.println(true);
		}
		if(s1.equals(s2)) {
			System.out.println(true);
		}
		if(s1.equals(s5)) {
			System.out.println(true);
		}
	}
	
	static void performanceCheck(int x, int y) {
		{
		//block	
		}
		//which is better performance - string, string buffer or string builder
		/*string buffer is synchonized and string builder is not synchronized 
		strings are immutable and the other two are not
		*/
		
		long startTime1 =System.nanoTime();
		for(int i=0; i<10000; i++) {
			String s1=new String("testing the performance");
		}
		long endTime1=System.nanoTime();
		System.out.println(endTime1-startTime1);
		
		//StringBuffer synchronized, slower
		long startTime2 =System.nanoTime();
		for(int i=0; i<10000; i++) {
			StringBuffer s2=new StringBuffer("testing the performance");
		}
		long endTime2=System.nanoTime();
		System.out.println(endTime2-startTime2);
		
		long startTime3 =System.nanoTime();
		for(int i=0; i<10000; i++) {
			StringBuilder s3=new StringBuilder("testing the performance");
		} //s variable is block scope
		long endTime3=System.nanoTime();
		System.out.println(endTime3-startTime3);
	     x++;
	     y++;
	}
	
	static void moreFunStrings() {
		String s= new String("Lets Learn Strings");
		System.out.println(s.substring(2, 10));
		//start from 2 char ,give 20 total
		System.out.println(s.length());
		System.out.println(s.toCharArray());
		System.out.println(s.charAt(10));
		//System.out.println(s.CASE_INSENSITIVE_ORDER);
		for(String a: s.split(" ")) {
			System.out.println(a);
		}
	}
	
	
	void stringTokens() {
		//based on the token, search through the string
		String str = "an example used for, separating, strings";
		StringTokenizer t = new StringTokenizer(str, " ");
		while(t.hasMoreTokens()) {
			System.out.println(t.nextToken());
		}
	}
	
}
