package com.revature.multithreading;

// Part of the solution to hw1 problem #29 - #31

public class MultithreadingMain {
	
	public static void main(String[] args) throws InterruptedException {
				
		// Initialize unsynchronized threads
		Thread unsyncThread1 = new Thread(new UnsynchronizedThread());
		Thread unsyncThread2 = new Thread(new UnsynchronizedThread());
		Thread unsyncThread3 = new Thread(new UnsynchronizedThread());
		
		// Initialize synchronized threads
		Thread syncThread1 = new Thread(new SynchronizedThread());
		Thread syncThread2 = new Thread(new SynchronizedThread());
		Thread syncThread3 = new Thread(new SynchronizedThread());
		
		// Start all unsynchronized threads
		unsyncThread1.start();
		unsyncThread2.start();
		unsyncThread3.start();
		
		// Join all unsynchronized threads
		unsyncThread1.join();
		unsyncThread2.join();
		unsyncThread3.join();
		
		// Start all synchronized threads
		syncThread1.start();
		syncThread2.start();
		syncThread3.start();
		
		// Join all synchronized threads
		syncThread1.join();
		syncThread2.join();
		syncThread3.join();
		
		// Output
		System.out.println("Unsynchronized Result: " + UnsynchronizedThread.i);
		System.out.println("Synchronized Result: " + SynchronizedThread.i);
	}
}
