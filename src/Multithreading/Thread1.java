package Multithreading;

import java.util.ArrayList;

class Thread1 extends Thread {
	ArrayList<Integer> al = new ArrayList<Integer>();
	String threadName;
	SynchronizedIncrementor inc = new SynchronizedIncrementor();
	
	public Thread1(String name) {
		threadName = name;
	}
	
	@Override
	public void run() {
		super.run();
		try {
		for (int i=0; i<1000; i++) {
			al.add(new Integer(inc.increase()));
		}
		System.out.println(this.threadName);
		System.out.println(al);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void start() {
		super.start();
	}
}