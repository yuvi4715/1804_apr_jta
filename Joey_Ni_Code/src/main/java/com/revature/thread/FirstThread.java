package com.revature.thread;

public class FirstThread {
	public static void main(String[] args) {
		  example();
	
		
	}
	static void example() {
		Thread t1= new Thread();
		t1.start();
		boolean isDaemon = t1.isDaemon();
		System.out.println(isDaemon);
		System.out.println("thread ID: "+t1.getId());
		System.out.println("thread name: "+t1.getName());
		System.out.println(t1.isAlive());
		
		
		try {
			Thread.sleep(200);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println(t1.isAlive());
	}

}
