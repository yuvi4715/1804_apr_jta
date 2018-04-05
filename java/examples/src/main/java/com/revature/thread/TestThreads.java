package com.revature.thread;

public class TestThreads {

	public static void main(String[] args) {
//		ExtendThread t1 = new ExtendThread("One");
//		t1.start();
//		ExtendThread t2 = new ExtendThread("Two");
//		t2.start();
		
		
		Thread i1 = new Thread(new ImplementRunnableInterface());
		i1.start();
		Thread i2 = new Thread(new ImplementRunnableInterface());
		i2.start();
//		try {
//			t1.join();
//			t2.join();
//		} catch (InterruptedException e) {
//			e.printStackTrace();
//		}
	}
}
