package Assignment1;

public class Q27 
{
	public static void main(String args[])
	{
		RunnableThread thread1 = new RunnableThread("thread1");
		thread1.start();
		
		RunnableThread thread2 = new RunnableThread("thread2");
		thread2.start();
	}
}
