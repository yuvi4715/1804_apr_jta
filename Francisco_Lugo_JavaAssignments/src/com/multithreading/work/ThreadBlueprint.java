package com.multithreading.work;

public class ThreadBlueprint implements Runnable{

	private Thread t = null;
	private int value = 0;
	private String name;
	
	public ThreadBlueprint(String name) {
		this.name = name;
	}
	@Override
	public void run() {
		for(int e = 0; e <1000; e++) {
			plusOne();
		}
		System.out.println("Ending thread: " + name);
		System.out.println("Final value of " +name + ": " + value);
	}

	public void start() {
		System.out.println("Starting thread: " + name);
		if(t == null) {
			t = new Thread(this,name);
			t.start();
		}
		
	}
	private synchronized void plusOne() {
		value++;
	}
}
