package com.revature.hello;

public class StaticExample extends Main{
//	1- static variables
//	2- static blocks
//	3-non static variables
//	4-non static block
//	5-super constructor
//  6-constructor
	
	
	static int i = 10; 
	int j=20;
	final int k;
	//STATIC belongs to the class, can't declare in method,
	//forces into method scope
	
	//block, can be used as instance initializer
	{
		System.out.println("BLOCK");
		k=20; //
	}
	
	//static block
	static {
		System.out.println("Static Block");
	}
	
	public StaticExample() {
		System.out.println("Default constructor");
		//k=20;
		System.out.println("can change value of j in non-static context" + ++j);
		System.out.println("can change value of static i in static context" + ++i);
	}
	
	
	public static void main(String[] args) {
		//static int i=10;
		//can't access non-static member in a static context
		new StaticExample().myMethod1(); 
		myMethod2();
		System.out.println("can change value of static i in any context" + i++);
		
	}
	
	void myMethod1() {
		//can access non-static member in non-static context
		j=j+1;
		i=i+1;
		System.out.println("value of j =" +j);
		System.out.println("can change value of static i in any context" + i++);
	}
	
	static void myMethod2() {
		new StaticExample();
		System.out.println("can change value of static i in static context" + i++);
		
	}
}
