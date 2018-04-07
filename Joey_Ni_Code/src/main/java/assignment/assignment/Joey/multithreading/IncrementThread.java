package assignment.Joey.multithreading;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Set;

//For play

//a thread is started by start(), an instance of any class that implements Runnable can start a thread
public class IncrementThread{
public static void main(String[] args) {
		CountThread a = new CountThread("Thread 1");
		a.start();
		CountThread b = new CountThread("Thread 2");
		b.start();
		CountThread c = new CountThread("Thread 3");
		c.start();
		System.out.println(a.getName()+a.getThreadCount());
		System.out.println(b.getName()+b.getThreadCount());
		System.out.println(c.getName()+c.getThreadCount());
	}
}

class CountThread extends Thread
{
	
	private ArrayDeque <Integer> threadCount =new ArrayDeque<>();
	//private ArrayList <Integer> threadCount = new ArrayList<>();
	public CountThread(String name) 
	{
		this.setName(name);
	}
	public ArrayDeque<Integer> getThreadCount() 
	{
		return threadCount;
	}

	public void setThreadCount(ArrayDeque<Integer> threadCount) 
	{
		this.threadCount = threadCount;
	}

	private int count;
	
	synchronized public int countPlus()
		{
		  return ++count;
		}
	
	@Override
	public void run() 
	{
		for(int i=0;i<100;i++) 
		{
			this.threadCount.add(this.countPlus());
		}
	}
}

	
	

/**
public class IncrementThread extends Thread{


	private ArrayDeque <Integer> threadCount =new ArrayDeque<>();
	
	public IncrementThread() {
		
//each time an instance of Threading occurs, a constructor is called=>method called
		//counts num instances created
	}
	static int count =0;
	int localCount=0;
	static IncrementThread a =new IncrementThread();
	
	static IncrementThread b =new IncrementThread();
	
	static IncrementThread c =new IncrementThread();
	
	public int countPlus() {
		//int localCount =++count; //stores count
		//return ++localCount;
		return ++count;
	}//can't make constructor synchronized
	
	public static void main(String[] args) {
		//IncrementInt count = new IncrementInt();
		
		a.start();
		b.start();
		c.start();
		
		
		System.out.println(a.threadCount);
		System.out.println(b.threadCount);
		System.out.println(c.threadCount);
		
	}

	public ArrayDeque<Integer> getThreadCount() {
		return threadCount;
	}

	public void setThreadCount(ArrayDeque<Integer> threadCount) {
		this.threadCount = threadCount;
	}
	
	public String toString() {
		return "IncrementThread [threadCount=" + threadCount + "]";
	}

	
		
	
/*
	public synchronized int incrementCount(int count) {
		return count++;	
	}*/

	/*
class IncrementInt{
	
	*/
/*
	public void run() {
		for(int i=0;i<1000;i++) {
			a.threadCount.add(a.countPlus());
			b.threadCount.add(b.countPlus());
			c.threadCount.add(c.countPlus());
		}
		
	}
}*/
	/*
	public void ThreadCount() {
		Runnable a= new IncrementInt();
		Thread Thread1=new Thread(a);
		Thread1.start();
		
		for(int i=0; i<1000; i++) {
			Thread1.countPlus();
		}
	}*/


