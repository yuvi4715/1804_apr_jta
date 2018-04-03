package com.revature.hello;

public final class MultipleArguments {

	public static void main(String[] args) {
		MultipleArguments m1 = new MultipleArguments();
		m1.display(10,11,12,13,14,15);
		m1.display(21,22,23,24);
		
		print(20,21,22,23,24);
		print(20,21,22,23,24,25);
		print(20,21,22,23);
		print(20);
		
	}

	static void print(int x, int...y) {
		for (int i:y) {
			System.out.println(i);
		}
	}
	
	void display(int...x) {
		for (int i:x) {

}
	}
}