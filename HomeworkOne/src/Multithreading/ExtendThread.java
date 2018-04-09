package Multithreading;

public class ExtendThread extends Thread{
	String threadName;
	public ExtendThread(String threadName) {
		this.threadName = threadName;
	}
	@Override
	public synchronized void run() {
		super.run();
		int countThread1 = 0;
		int countThread2 = 0;
		
		try {
			for(int i =0; i<1000; i++) {
				Thread.sleep(200);
				System.out.println(this.threadName + " : " + this.getName() + " : " 
				+ this.getId());
				if (this.threadName == "One") {
					countThread1++;
				} else if (this.threadName == "Two") {
					countThread2++;
				}
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