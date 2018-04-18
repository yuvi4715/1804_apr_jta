package com.revature.Homework.ProblemFifty;

public class Main {

	public static void main(String[] args) {
		Thread t1 = new Thread(new myThread01());
		Thread t2 = new Thread(new myThread02());
		t1.start();
		t2.start();
	}
	static class resource {
		public static synchronized void resource01() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			resource02();
			System.out.println("Resource 01 out of deadlock");
		}
		public static synchronized void resource02() {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			resource01();
			System.out.println("Resource 02 out of deadlock");
		}
	}
	static class myThread01 implements Runnable {

		@Override
		public void run() {
			resource.resource01();
		}
		
	}
	static class myThread02 implements Runnable {

		@Override
		public void run() {
			resource.resource02();
		}
		
	}
}
