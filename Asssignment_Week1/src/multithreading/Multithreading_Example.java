package multithreading;
//Kevin Rivera - Revature
//Assignment Week 1: Multithreading - Problem 29, 30, 31.
//This class demonstrates how to create multiple threads, how a class that
//implements Runnbale must override run(), and can implement start(), and how
//to start the threads so they execute the run() method. They all access a static
//variable inside the class simultaneously with and without the synchronized modifier
//on the method that increments the variable.

public class Multithreading_Example implements Runnable {
	static int counter = 0;
	private Thread t;
	private String threadName;
	
	Multithreading_Example(String name){
		this.threadName = name;
		System.out.println("Creating thread: " + threadName);
	}
	
	@Override
	public void run() {
		System.out.println("Running thread: " + threadName);
		try {
			for (int i = 0; i < 1000; i++) {
				incrementCounter();
				Thread.sleep(5);
			}
			System.out.println("Counter ended in: " + returnCounter() + " by " + threadName);
		} catch (InterruptedException e) {
			System.out.println("Thread " + threadName + " interrupted.");
		}
	}
	
	public void start() {
		System.out.println("Starting thread: " + threadName);
		if (t == null) {
			t = new Thread(this, threadName);
			t.start();
		}
	}
	//Remove the synchronized keyword to see different results.
	synchronized public void incrementCounter() {
		counter++;
	}
	
	public int returnCounter() {
		return counter;
	}
	
	public static void main(String[] args) {
		//Each thread will increment the static variable by 1000, 
		//so you would normally expect it to end at 3000.
		Multithreading_Example m1 = new Multithreading_Example("m1");
		m1.start();
		Multithreading_Example m2 = new Multithreading_Example("m2");
		m2.start();
		Multithreading_Example m3 = new Multithreading_Example("m3");
		m3.start();
		
	}
}
