package com.revature.multithreading;

public class MultipleThreads extends Thread {
	public static void main(String[] args) {
		MultipleThreads firstThread = new MultipleThreads();
		firstThread.start();
		MultipleThreads secondThread = new MultipleThreads();
		secondThread.start();
		MultipleThreads thirdThread = new MultipleThreads();
		thirdThread.start();
		System.out.println(firstThread);
		System.out.println(secondThread);
		System.out.println(thirdThread);
		// Thread.sleep causes the current thread to suspend execution for a specified
		// period.
		// A wait can be "woken up" by another thread calling notify on the monitor
		// which is being waited on whereas a sleep cannot.
		// yield() basically means that the thread is not doing anything particularly
		// important and if any other threads or processes need to be run, they should
		// run.
		// Thread.suspend(): this method puts a thread in the suspended state and can be
		// resumed using resume() method.
		// Thread.stop () stops a thread completely.
		// A thread sends an interrupt by invoking interrupt on the Thread object for
		// the thread to be interrupted.
		// Number of waiting threads being waken up: one in
		// notify() and all in notifyAll().
	}

	// unsynchronized method public void run() {
	// int countCalled = 0;
	// for(int i=0; i<1000; i++) {
	// countCalled++;
	// System.out.println(countCalled);
	// try {
	// Thread.sleep(200);
	// } catch (InterruptedException e) {
	//
	// break;
	// }
	// }
	//
	// }

	public synchronized void run() {
		int countCalled = 0;
		for (int i = 0; i < 1000; i++) {
			countCalled++;
			System.out.println(countCalled);
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				break;
			}
			}

		}
	}