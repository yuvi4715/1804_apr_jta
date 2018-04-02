package com.revature.hello;

public class MultipleArguments {
	public static void main(String[] args) {
	//cannot call non-static member in static
		MultipleArguments m1= new MultipleArguments();
		m1.display(10,11,12,13,14);
		m1.display(22, 23, 24);
		m1.display(30,40,70);
		print(20,21,23,24);
		print(20,21,23,24,25,26);
		print(20,21,23,24);
	}
	
	/* -block */
	/** JavaDoc can be taken care off by Java Servlet*/
	// one line comment
	
	static void print(int x, int...y) {
	//varargs=variable arguments, stored in arrays, multiple arguments defined by ...
	//size of param can be changed, only one per method
		for(int i:y) {
			System.out.println(i);
		}
	}
	
	void display(int...x) {
		for (int i:x) {
			System.out.println(i);
		}
	}
}
