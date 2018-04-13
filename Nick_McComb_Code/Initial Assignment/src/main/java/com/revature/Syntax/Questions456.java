package com.revature.Syntax;

public class Questions456 {
	
	public static void main(String[] args) {
		System.out.println("Question 4:");
		q4(5,10);
		
		System.out.println("\nQuestion 5:");
		Question5Methods q5 = new Question5Methods();
		System.out.println(q5.add(5, 10));
		System.out.println(q5.subtract(10, 7));
		System.out.println(q5.multiply(5, 5));
		System.out.println(q5.divide(10, 7));
		
		System.out.println("\nQuestion 6:");
		
	}
	
	static void q4(int a, int b) {
		int c = a + b;
		System.out.println(a + " plus " + b + " is " + c);
		c = a - b;
		System.out.println(a + " minus " + b + " is " + c);
		c = a*b;
		System.out.println(a + " times " +  b + " is " + c);
		double d = (double)a/(double)b;
		System.out.println(a + " divided by " + b + " is " + d);
	}
	
}
