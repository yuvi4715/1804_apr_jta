package com.revature.multithreading;

// Part of the solution to hw1 problem #29 - #31

public class UnsynchronizedThread implements Runnable {

	public static int i = 0;
	
	public void run() {
				
		for (int j = 0; j < 1000; j++) {
			i++;
		}
	}
		
	public static void main(String[] args) throws InterruptedException {
		
		Thread t1 = new Thread(new UnsynchronizedThread());
		Thread t2 = new Thread(new UnsynchronizedThread());
		
		t1.start();
		t2.start();
		
		t1.join();
		t2.join();
		
		System.out.println(i);
	}
}
