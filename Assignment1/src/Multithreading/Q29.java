//John Eifert
package Multithreading;

//This program answers questions 29 alongside RunnableThread.java

public class Q29 
{
	public static void main(String args[])
	{
		RunnableThread thread1 = new RunnableThread("thread1");
		thread1.start();
		
		RunnableThread thread2 = new RunnableThread("thread2");
		thread2.start();
		
		RunnableThread thread3 = new RunnableThread("thread3");
		thread3.start();
	}
}
