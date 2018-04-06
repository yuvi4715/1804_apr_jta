package com.revature.hello;


// 7
public class Consumer {
	final int f = 0;
	static int s = 1;

	public static void main(String args[]) {
		// 8
		Consumer a = new Consumer();
		Consumer b = new Consumer(4);
		a.buy();
		a.buy(2);
		Consumer.tax();
		Consumer.money();
	}

	public Consumer() {

	}

	public Consumer(int x) {
		;
	}

	public void buy() {

	}

	public void buy(int x) {
		;
	}

	public static int tax() {
		return ++s;
	}

	public static int money() {
		return s;
	}

}
