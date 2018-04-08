//John Eifert
package Multithreading;

//This program answers question 30 alongside SynchronizedThread.java

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
	}
}
