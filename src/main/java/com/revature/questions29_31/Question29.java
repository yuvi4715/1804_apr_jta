package com.revature.questions29_31;

class Question29 implements Runnable {

	private Thread t;
	private String threadName;
	private int counter = 0;
	
	Question29 (String name){
		threadName = name;
		System.out.println("Creating: " + threadName);
	}
	
	
	
	public void run() {
		System.out.println("Running " + threadName);
		for(int i = 0; i < 1000; i ++) {
			this.counter++;
			System.out.println(this.counter);
		}
		
//		try {
//			for(int i = 0; i > 1000; i++) {
//				System.out.println("Thread: " + threadName + ", " + i);
//				//let thread sleep
//				Thread.sleep(50);
//			}
//		} catch (InterruptedException e) {
//			System.out.println("Thread " + threadName + " interrupted.");
//		}
		System.out.println("Thread" + threadName + " exiting.");
	}
	
	
	public void start() {
		System.out.println("Starting " + threadName);
		if (t == null) {
			t = new Thread (this, threadName);
			t.start();
		}
	}

	
}

