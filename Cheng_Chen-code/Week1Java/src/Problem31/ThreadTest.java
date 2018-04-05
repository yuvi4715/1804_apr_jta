package Problem31;

public class ThreadTest extends Thread
{
	private Thread t;
	private String ThreadName;
	private int counter = 0;
	private int id;
	
	public ThreadTest(String name)
	{
		ThreadName = name;
		id = counter++;
		System.out.println("Creating " + ThreadName);
	}
	
	public void run()
	{
		if(id==0) 
		{
			try 
			{
				Thread.sleep(100);
			} 
			
			catch (InterruptedException e) 
			{
				e.printStackTrace();
			}
		}
		
		else if(id==1) 
		{
			while(true)
				System.out.println("Running Thread 1");
		}
		
		else if(id==2) 
		{
			Thread.yield();
		}
		
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

	public int increment(int i)
	{
		return (i+1);
	}
}
