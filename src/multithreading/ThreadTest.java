package multithreading;
/**
 * Dominick Sermeno
 * Batch 1804
 * Tester for Q's: 24-28
 */
public class ThreadTest 
{
	
	public static void main(String arg[])
	{
		threadExample t1 = new threadExample();
		threadExample t2 = new threadExample();
		threadExample t3 = new threadExample();
		
		t1.start();
		t2.start();
		t3.start();
			
	}
}
