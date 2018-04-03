package com.revature.hello;

public class MultipleArguments {
	public static void main(String[] args) {
		MultipleArguments m1 = new MultipleArguments();
		m1.display(10,22,123,123);
		
//		print(20, 123, 213 ,2 , 32);
	}
	
	
	static void print(int x, int...y) {
		for(int i: y) {
			System.out.println(i);
		}	
	}
	
	void display(int...x) {	// varargs
		for (int i: x)
			System.out.println(i);
	}
	
}
