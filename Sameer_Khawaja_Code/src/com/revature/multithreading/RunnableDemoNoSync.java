package com.revature.multithreading;

public class RunnableDemoNoSync implements Runnable {
	private Thread t;
	private String threadName;
	private static int counter;

	RunnableDemoNoSync(String name) {
		threadName = name;
		System.out.println("Creating " + threadName);
	}

	public void run() {
		System.out.println("Running " + threadName);
		int threadCounter = 0;
		try {
			for (int i = 1; i <= 1000; i++) {

				
				if (threadName == "Thread-1") {
					threadCounter = incrementCounter();
				} else if (threadName == "Thread-2") {
					threadCounter = incrementCounter();
				} else if (threadName == "Thread-3") {
					threadCounter = incrementCounter();
				}
				/*
				//displays runtime counters, remove block comment to view
				System.out.print("Thread: " + threadName + ", " + i);
				System.out.println(" - " + threadCounter); 
				*/
				// let the thread sleep a while
				Thread.sleep(5);

			}
		} catch (InterruptedException e) {
			System.out.println("Thread: " + threadName + " interrupted");
		}
		System.out.println("Final value for Thread: " + threadName + " - " + threadCounter);
		System.out.println("Thread: " + threadName + " exiting");
	}

	public void start() {
		System.out.println("Starting " + threadName + "~~~~~~~~~~~");
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}

	public static int incrementCounter()  {
		counter++;
		//System.out.println(" - " + counter);
		return counter;
	}

}
