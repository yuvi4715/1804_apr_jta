package com.revature.Homework.ProblemFiftyOne;

public class Main {

	public static void main(String[] args) {
		MyThread01 thread01 = new MyThread01();
		MyThread01 thread02 = new MyThread01();
		thread01.setFriend(thread02);
		thread02.setFriend(thread01);
		Thread t1 = new Thread(thread01);
		Thread t2 = new Thread(thread02);
		
		t1.start();
		t2.start();
	}
	
	static interface MyThread{
		boolean hasMessage();
		String getMessage();
	}
	static class MyThread01 implements MyThread,Runnable{
		MyThread friend;
		public MyThread getFriend() {
			return friend;
		}

		public void setFriend(MyThread friend) {
			this.friend = friend;
		}

		@Override
		public boolean hasMessage() {
			return true;
		}

		@Override
		public String getMessage() {
			return "Hi";
		}

		@Override
		public void run() {
			while(friend==null)
				try {
					Thread.sleep(100);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			while(friend.hasMessage())
				friend.getMessage();
		}
		
	}
}
