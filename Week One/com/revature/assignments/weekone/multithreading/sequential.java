/**
 * 
 */
package com.revature.assignments.weekone.multithreading;

/**
 * @author Ed M
 * @date Apr 5, 2018
 * @time time 11:24:45 AM
 */
public class sequential extends Thread {
	private Thread t;
	// private String threadName;
	private int i = 0;
	private int numOfThread;

	public sequential(int num) {
		numOfThread = num;
	}

	private void plusplus() {
		i++;
	}

	public void run() {
		
		System.out.println("Thread " + numOfThread + " exiting.");

	}

	public void start() {
		System.out.println("Starting " + numOfThread);

		if (t == null) {
			t = new Thread(this, String.valueOf(numOfThread));
			t.start();
		}
		for (int i1 = 1; i1 <= 1000; i1++) {
			plusplus();
			System.out.println("Thread #" + numOfThread + " | " + i + "++");
		}
	}

	public static void main(String[] args) {
		sequential T1 = new sequential(1);
		T1.start();

		sequential T2 = new sequential(2);
		T2.start();
	}

}
