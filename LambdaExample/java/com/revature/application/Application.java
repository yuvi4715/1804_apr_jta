package com.revature.application;

import com.revature.fi.HelloGreeting;
import com.revature.fi.Math;

public class Application {
	public static void main(String[] args) {
		Math add = (a, b) -> a + b;
		Math multiply = (int x, int y) -> x * y;
		Math divide = (first, second) -> {
			if (second == 0) {
				return 0;
			}
			return first / second;
		};
		
		HelloGreeting example = (String s) -> System.out.println("Hello " + s);
		example.hello("William");
		
//		System.out.println(divide.calculate(15, 3));
//		System.out.println(divide.calculate(15, 0));
		
		
		
//		System.out.println(add.calculate(10, 20));
//		System.out.println(multiply.calculate(10, 20));
	}
	
	/*
	 * You must include parentheses if you specify the type
	 * You do not have to include parentheses if there is only one parameter
	 * If your method body is one statement, you do not need {}
	 * If your method body is more than one statement, or has the 'return' keyword, you must
	 * use {}
	 * 
	 */
		
	
}
