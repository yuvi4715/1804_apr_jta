//John Eifert
package Multithreading;

//This program answers questions 29 alongside Q29.java

public class RunnableThread implements Runnable
{
	private Thread thisThread;
	private String threadName;
	
	RunnableThread(String n)
	{
		threadName=n;
		System.out.println("Made " + threadName);
	}
	
	@Override
	public void run()
	{
		System.out.println("run() has been called for " + threadName + ".");
		
		int num=0;

		for(int i=0; i<1000; i++)
		{
			num++;
			System.out.println(num);
		}
		
		System.out.println("Exiting " + threadName + ".");
	}
	
	public void start()
	{
		System.out.println("Starting " + threadName + ".");
		
		if(thisThread == null)
		{
			thisThread = new Thread(this, threadName);
			thisThread.start();
		}
	}	
}
