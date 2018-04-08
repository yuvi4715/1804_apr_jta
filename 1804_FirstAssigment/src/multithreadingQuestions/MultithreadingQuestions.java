package multithreadingQuestions;

public class MultithreadingQuestions implements Runnable
{

	static int CounterVariable = 0;
	private Thread t;
	private String threadName;
	
	MultithreadingQuestions(String name)
	{
		this.threadName = name;
		System.out.println("Creating thread: " + threadName);
	}
	
	@Override
	public void run() 
	{
		System.out.println("Running thread: " + threadName);
		try 
		{
			for (int i = 0; i < 1000; i++) 
			{
				incrementCounter();
				Thread.sleep(5);
			}
			System.out.println("Counter ended in: " + returnCounter() + " by " + threadName);
		} 
		catch (InterruptedException e) 
		{
			System.out.println("Thread " + threadName + " interrupted.");
		}
	}
	
	public void start() 
	{
		System.out.println("Starting thread: " + threadName);
		if (t == null) 
		{
			t = new Thread(this, threadName);
			t.start();
		}
	}
	
	synchronized public void incrementCounter() 
	{
		CounterVariable++;
	}
	
	public int returnCounter() 
	{
		return CounterVariable;
	}
	
	public static void main(String[] args) 
	{
		
		MultithreadingQuestions multi1 = new MultithreadingQuestions("Multi1");
		multi1.start();
		MultithreadingQuestions multi2 = new MultithreadingQuestions("Multi2");
		multi2.start();
		MultithreadingQuestions multi3 = new MultithreadingQuestions("Multi3");
		multi3.start();
		
	}
}

