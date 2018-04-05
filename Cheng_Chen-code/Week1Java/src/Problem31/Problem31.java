package Problem31;

import Problem31.ThreadTest;

public class Problem31 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws InterruptedException 
	{
		// TODO Auto-generated method stub
		ThreadTest T1 = new ThreadTest("Thread 1");
		T1.start();
		
		ThreadTest T2 = new ThreadTest("Thread 2");
		T2.start();
		
		ThreadTest T3 = new ThreadTest("Thread 3");
		T3.start();
		
		
		T2.suspend();
		for(int i=0;i<100;i++);
		
		T2.resume();		
		T2.notify();
		
		T2.stop();
	}

}
