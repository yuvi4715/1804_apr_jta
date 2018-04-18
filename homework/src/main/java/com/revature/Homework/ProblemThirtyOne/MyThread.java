package com.revature.Homework.ProblemThirtyOne;


public class  MyThread implements Runnable{
	private static int count=0;
	private int id;
	public MyThread() {
		id=count++;
	}
	public void run() {
		if(id==0) {
			try {
				System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getState());
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else if(id==1) {
			while(true)
				System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getState());
		}else if(id==2) {
			System.out.println(Thread.currentThread().getName()+" : "+Thread.currentThread().getState());
			Thread.yield();
		}
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		MyThread.count = count;
	}

}
