/**
 * 
 */
package com.revature.assignments.weekone.multithreading;

/**
 * @author Ed M
 * @date Apr 5, 2018
 * @time time 1:07:48 PM
 */
// Q30 - Q31
public class Synchronize extends Thread {
	private Thread t;
	// private String threadName;
	private int i = 0;
	private int numOfThread;

	public Synchronize(int num) {
		numOfThread = num;
	}

	private synchronized void plusplus() {
		i++;
	}

	public void run() {

		//System.out.println("Thread " + numOfThread + " exiting.");

	}

	public void start() {
		System.out.println("Starting " + numOfThread);

		if (t == null) {
			t = new Thread(this, String.valueOf(numOfThread));
			t.start();
		}
		for (int i1 = 1; i1 <= 100; i1++) {
			plusplus();
			System.out.println("Thread #" + numOfThread + " | " + i + "++");
		}
	}

	public static void main(String[] args) {
		Synchronize T1 = new Synchronize(1);
		Synchronize T2 = new Synchronize(2);
		Synchronize T3 = new Synchronize(3);
		
		
		T1.start();		
		T2.start();
		T3.start();
		
	    try {
	         T1.join();
	         T2.join();
	         T3.join();
	      } catch ( Exception e) {
	         System.out.println("Interrupted");
	}

}}