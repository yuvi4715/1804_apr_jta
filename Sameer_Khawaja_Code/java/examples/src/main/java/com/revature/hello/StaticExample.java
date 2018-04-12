package com.revature.hello;

public class StaticExample extends Main {

	// 1 - Static variables
	// 2 - Static blocks
	// 3 - Non Static Variables
	// 4 - Non Static Block
	// 5 - Constructor
	
	static int i = 10;
	int j = 20;
	final int k;

	{
		System.out.println("BLOCK");
		k = 10;
	}
	
	public StaticExample() {
		System.out.println("Default constructor");
		System.out.println("value of i : " + ++i);
		System.out.println("value of j : " + ++j);
	}
	public static void main(String[] args) {
		//can't access non-static member in a static context
		//j = j + 1;
		new StaticExample().myMethod1();
		myMethod2();
		System.out.println("value of i : " + ++i);
		//System.out.println("value of j : " + ++j);
	}
	void myMethod1() {
		//can access non-static member in non-static context
		//j = j + 1;
		System.out.println("value of i : " + ++i);
		System.out.println("value of j : " + ++j);
	}
	static void myMethod2() {
		new StaticExample();
		System.out.println("value of i : " + ++i);
		//System.out.println("value of j : " + ++j);
	}
	static {
		System.out.println("Static block");
		System.out.println("value of i : " + ++i);
		//System.out.println("value of j : " + ++j);
	}
	

}
