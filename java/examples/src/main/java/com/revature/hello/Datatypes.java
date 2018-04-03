package com.revature.hello;

public class Datatypes {

	//
	int i;
	char c;
	double d;
	float f;
	long l;
	short s;
	byte b;
	boolean bo;
	
	public static void main(String[] args) {
		new Datatypes().print();
	}
	
	void print() {
		System.out.println("i : " + i);
		System.out.println("c : " + c);
		System.out.println("d : " + d);
		System.out.println("f : " + f);
		System.out.println("l : " + l);
		System.out.println("s : " + s);
		System.out.println("b : " + b);
		System.out.println("bo : " + bo);
	}

}
