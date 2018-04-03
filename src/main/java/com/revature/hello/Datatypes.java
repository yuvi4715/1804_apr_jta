package com.revature.hello;

public class Datatypes {

	//I defined these variables outside the main method. What are they called?
	
	//Instance Variable
	int i;
	char c;
	double d;
	float f;
	long l;
	short s;
	byte b;
	boolean bo; 
	
	
	public static void main(String[] args) {
		new Datatypes().print(); //when you combined words, the second one should always be in caps. Not like this.
		//This is all 0 or null because they're not objects.
		
	}
	
	
	void print() { 
		System.out.println("i: " + i);
		System.out.println("c: " + c);
		System.out.println("d: " + d);
		System.out.println("f: " + f);
		System.out.println("l: " + l);
		System.out.println("s: " + s);
		System.out.println("b: " + b);
		System.out.println("bo: " + bo);

	}
	

}
