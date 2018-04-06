package multithreading;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class threadExample implements Runnable
{
	
	public static int count = 0;
	
	public synchronized static int counter() 
	{
		count = count+1;
		return count;	
	}
	
	
	
	/*public synchronized void Run() throws InterruptedException
	{
		
	}*/
	
	public synchronized void start() 
	{
		//super.start();
		run();
	}



	@Override
	public void run() 
	{
		//super.run();
				Set<Integer> countVal = new HashSet<Integer>();
				int theCount = 0;
				for(int i =0; i < 1000; i++)
				{
					theCount = counter();
					countVal.add(theCount);
				}
				Iterator<Integer> iTHS = countVal.iterator();
				System.out.println(" Counter Set ");
				while(iTHS.hasNext())
				{
					System.out.println("Thread Count: " + iTHS.next());
				}
				
		
	}
	
}
