package com.revature.thread;

public class ExtendThread extends Thread{
	String threadName;
	public ExtendThread(String threadName) {
		this.threadName = threadName;
	}
	@Override
	public synchronized void run() {
		super.run();
		try {
			for(int i =0; i<10; i++) {
				Thread.sleep(200);
				System.out.println(this.threadName + " : " + this.getName() + " : " 
				+ this.getId());
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	@Override
	public synchronized void start() {
		super.start();
		run();
	}
}
