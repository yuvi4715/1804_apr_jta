package com.revature.hello;


public class Multithreading extends Thread {
	// Multithreading
	// Write a method that stores an integer. Each time the method is called,
	// increment the integer by 1. Create three threads that call this method 1000
	// times each, storing the returned result in their own set. Print out each
	// thread’s set.
	static int num = 0;
	static boolean sync = false;

	public static void main(String args[]) throws Exception {
		int size = 3;
		Thread[] tArray = new Thread[size];
		System.out.println("unsychronized:");
		for (int i = 0; i < size; ++i) {
			tArray[i] = new Multithreading();
		}
		for (int i = 0; i < size; ++i) {
			tArray[i].run();
		}
		
//		TimeUnit.SECONDS.sleep(1);
		for (int i = 0; i < size; ++i) {
			tArray[i].join();
		}

		System.out.println("sychronized:");
		Multithreading.num = 0;
		Multithreading.sync = true;
		for (int i = 0; i < size; ++i) {
			Thread t = new Multithreading();
			t.run();
		}

		// Review thread-specific methods: sleep(), wait(), yield(), suspend(), stop(),
		// resume(), interrupt(), notify(), notifyAll()
		Thread test = new Multithreading();
		test.start();
		Thread.sleep(10);
//		test.wait();
//		test.notify();
//		test.yield();
//		test.interrupt();
//		test.notifyAll();
		
		// depreciated methods
//		test.suspend();
//		test.stop();
//		test.resume();
	}

	public void run() {
		super.run();
		// System.out.println("I'm doing stuff inside a thread!");
		int result = 0;
		for (int i = 0; i < 100; ++i) {
			result = sync ? bar() : foo();
		}
		System.out.println("result: " + result);
	}

	public int foo() {
//		System.out.println("foo()");
		return ++num;
	}

	// Synchronize the method that stores and increments the integer. Execute your
	// threads again.
	public synchronized int bar() {
		return ++num;
	}

}
/*
 * new runnable blocked waiting timed wait terminated
 */