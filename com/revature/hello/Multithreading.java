package com.revature.hello;

public class Multithreading extends Thread{
	// Multithreading
	// Write a method that stores an integer. Each time the method is called,
	// increment the integer by 1. Create three threads that call this method 1000
	// times each, storing the returned result in their own set. Print out each
	// thread’s set.
	static int i = 0;
	public static void main(String args[]) {
		Thread t = new Multithreading();
		t.start();
		(new Multithreading()).start();
		(new Multithreading()).start();
	}

	public void run() {
		super.run();
		System.out.println("I'm doing stuff inside a thread!");
		int result = 0;
		for (int i = 0; i < 1000; ++i) {
			result = foo();
		}
		System.out.println("result: " + result);
	}

	public synchronized int foo() {
		return ++i;
	}

	// Synchronize the method that stores and increments the integer. Execute your
	// threads again.
	// Review thread-specific methods: sleep(), wait(), yield(), suspend(), stop(),
	// resume(), interrupt(), notify(), notifyAll()

}
/*
 * new runnable blocked waiting timed wait terminated
 */