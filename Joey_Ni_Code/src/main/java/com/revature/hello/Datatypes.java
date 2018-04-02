package com.revature.hello;

public class Datatypes {
	//instance/object variables
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
		//camel: thisIsAnExampleForCamel
		//Pascal: ThisIsAnExampleForPascal
	}
	//Pass in src and POM
	void print() {
		System.out.println("i: "+ i);
		
	}
}
