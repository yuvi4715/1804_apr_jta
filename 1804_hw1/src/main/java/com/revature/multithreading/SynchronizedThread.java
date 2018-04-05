package com.revature.multithreading;

//Part of the solution to hw1 problem #29 - #31

public class SynchronizedThread implements Runnable {
	
	public static int i = 0;
	
	public void run() {
				
		for (int j = 0; j < 1000; j++) {
			increment();
		}
	}
	
	public static synchronized void increment() {
		i++;
	}
		
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new SynchronizedThread());
		Thread t2 = new Thread(new SynchronizedThread());
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(i);
	}
}
