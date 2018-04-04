package com.revature.hello;

public class Datatypes
{
	//Instance/Object variables
	int i;
	char c;
	double d;
	float f;
	long l;
	short s;
	byte b;
	boolean bo;
	
	public static void main(String[] args)
	{
		new Datatypes().print();
		// ThisIsAnExampleForCamel, every word has capital case letter beginning

	}
	
	void print()
	{
		System.out.println("i : " + i);
		System.out.println("i : " + c);
		System.out.println("i : " + d);
		System.out.println("i : " + f);
		System.out.println("i : " + l);
		System.out.println("i : " + s);
		System.out.println("i : " + b);
		System.out.println("i : " + bo);
	}

}
