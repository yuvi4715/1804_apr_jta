package Assignment1;

public class Q20
{
	public static void main(String args[])
	{
		Runtime run = Runtime.getRuntime();
		
		run.gc();
		System.out.println(run.freeMemory());
		System.out.println(run.totalMemory());
		
	}
}
