//John Eifert
package Multithreading;

//This program answers question 30 alongside Q30.java

public class SynchronizedThread implements Runnable
{
	public static Object Lock = new Object();
	
	private Thread thisThread;
	private String threadName;
	
	SynchronizedThread(String n)
	{
		threadName=n;
		System.out.println("Made " + threadName);
	}
	
	@Override
	public synchronized void run()
	{
		System.out.println("run() has been called for " + threadName + ".");
		
		int num=0;
		
		synchronized(Lock)
		{
			for(int i=0; i<1000; i++)
			{
				num = incr(num);
				System.out.println(num);
			}
		}
		
		System.out.println("Exiting " + threadName + ".");
	}
	
	public int incr(int n)
	{
		return(n+1);
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
