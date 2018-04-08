//John Eifert
package Multithreading;

//This program answers question 31 alongside Q31.java

public class MyThread implements Runnable
{
	private Thread thisThread;
	private String threadName;
	
	MyThread(String n)
	{
		threadName=n;
		System.out.println(threadName + " has been created.");
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public void run()
	{
		int num=0;
		
		for(int i=0; i<30; i++)
		{
			num++;
			System.out.println(threadName + "   " + num);
			if(i==4)
			{
				try
				{
					sleep();
				}
				catch (Exception e)
				{
					System.out.println(threadName + " slept.");
				}

			}
			if(i==9)
			{
				try
				{
					sit();
				}
				catch (Exception e)
				{
					System.out.println(threadName + " waited.");
				}
			}
			if(i==17)
			{
				Thread.yield();
			}
			if(i==19)
			{
				try
				{
					thisThread.notifyAll();
				}
				catch(Exception e)
				{
					System.out.println("All have been notified.");
				}
			}
			if(i==21)
			{
				thisThread.resume();
			}
			if(i==23)
			{
				thisThread.interrupt();
			}
			if(i==25)
			{
				try
				{
					thisThread.notify();
				}
				catch(Exception e)
				{
					System.out.println("One has been notified.");
				}
			}
			if(i==27)
			{
				thisThread.stop();
			}
			if(i==30)
			{
				thisThread.suspend();
			}
		}
	}
	
	public void sleep() throws InterruptedException
	{
		thisThread.sleep(20);
	}
	public void sit() throws InterruptedException
	{
		thisThread.wait(200);
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
