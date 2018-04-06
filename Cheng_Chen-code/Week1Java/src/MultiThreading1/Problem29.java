package MultiThreading1;

public class Problem29 {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		ThreadTest T1 = new ThreadTest("Thread 1");
		T1.start();
		
		ThreadTest T2 = new ThreadTest("Thread 2");
		T2.start();
		
		ThreadTest T3 = new ThreadTest("Thread 3");
		T3.start();

	}
	
}

class ThreadTest extends Thread 
{
	private Thread t;
	private String ThreadName;
	private int counter = 0;
	
	public ThreadTest(String name)
	{
		ThreadName = name;
		System.out.println("Creating " + ThreadName);
	}
	
	public void run()
	{
		System.out.println("Running " + ThreadName);
		for(int i = 0; i<1000; i++)
		{
			counter = increment(counter);
		}
		System.out.println("Thread " + ThreadName + "'s counter is " + counter);
		System.out.println("Thread " + ThreadName + " exiting.");
	}
	
	public void start()
	{
		System.out.println("Starting " + ThreadName);
		if (t == null) 
		{
			t = new Thread (this, ThreadName);
			t.start ();
	    }
	}

	public static int increment(int i)
	{
		return (i+1);
	}
	
}