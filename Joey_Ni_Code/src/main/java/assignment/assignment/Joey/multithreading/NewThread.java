package assignment.Joey.multithreading;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**Multithreading
1. Write a method that stores an integer. 
Each time the method is called, increment the integer by 1. 
Create three threads that call this method 1000 times each, 
storing the returned result in their own set. Print out each thread’s set.
2. Synchronize the method that stores and increments the integer. 
Execute your threads again.
3. Review thread-specific methods: 
sleep(), wait(), yield(), suspend(), stop(), resume(), interrupt(), 
notify(), notifyAll()
*/
public class NewThread extends Thread {
	
	static int count=0;
	//private ArrayDeque <Integer> deque = new ArrayDeque <>();
	//ArrayDeque not synchronized even after synchronizing IncrementInt, because is failFast
	private ArrayList <Integer> deque1 = new ArrayList<>();
	//ArrayList Acts as expected
	private List<Integer> deque = Collections.synchronizedList(deque1);
	
	public NewThread(String name) {
		super(name);
		this.setName(name);
	}

	@Override
	public String toString() {
		return this.getName() +": [deque=" + deque + "]";
	}

	synchronized public int incrementCount() 
	{
		return count++;
	}
	
	@Override
	public void run() 
	{
		for(int i=0; i<100;i++) 
		{    //this add part is not synchronized unless using synched list
			this.deque.add(this.incrementCount());
		}
		System.out.println("The current running thread is:" +Thread.currentThread());
	}
	
	public static void main(String[] args) throws InterruptedException {
		NewThread a =new NewThread("Thread1");
		//sleep(200);
		
		//sleep(100);
		NewThread b =new NewThread("Thread2");
		NewThread c =new NewThread("Thread3");
		a.start(); 
		b.start();
		c.start();
		/*System.out.println("Thread1:"+a.deque); //happens before run?
		System.out.println("Thread2:"+b.deque);
		System.out.println("Thread3:"+c.deque);*/
		
	}
	
	

}
