package com.revature.thread;

public class ImplementsRunnable implements Runnable{
	@Override
	public void run() {
		for(int i=0; i<10; i++) {
			try {
				Thread.sleep(200);
				//System.out.println();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	


}
