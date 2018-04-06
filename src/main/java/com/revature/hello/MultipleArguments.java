package com.revature.hello;

public class MultipleArguments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultipleArguments m1 = new MultipleArguments();
		m1.display(10, 11, 12, 13, 14, 15);
	}
	
	// line comment
	
	/*
	 * multi line comment
	 * */
	
	/**
	 * Java Doc
	 *  */
	
	static void print(int x, int...y) {
		for (int i : y) {
			System.out.println(i);
		}
	}
	
	void display(int...x) {
		for (int i : x) {
			System.out.println(i);
		}
	}

}
