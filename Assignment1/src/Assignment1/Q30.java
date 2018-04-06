package Assignment1;

public class Q30
{
	public static void main(String args[])
	{

		SynchronizedThread thread1 = new SynchronizedThread("thread1");
		thread1.start();
		
		SynchronizedThread thread2 = new SynchronizedThread("thread2");
		thread2.start();
			
		SynchronizedThread thread3 = new SynchronizedThread("thread3");
		thread3.start();

		/*
		Q30 here = new Q30();
		
		
		here.threadTest();
		*/
	}
/*
	public synchronized void threadTest()
	{
		synchronized(this)
		{
			for(int i=0; i<3; i++)
			{
				synchronized(this)
				{
					SynchronizedThread here = new SynchronizedThread("thread" + (i+1));
					here.start();
				}
			}
		}
		
		
		
		synchronized(this)
		{
			SynchronizedThread thread1 = new SynchronizedThread("thread1");
			thread1.start();
			
			SynchronizedThread thread2 = new SynchronizedThread("thread2");
			thread2.start();
				
			SynchronizedThread thread3 = new SynchronizedThread("thread3");
			thread3.start();
		}
		
	}
*/
}
