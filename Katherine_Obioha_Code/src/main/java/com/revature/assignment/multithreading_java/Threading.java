package multithreading_java;

/**
 *  @author katherine Obioha
 *  
 *  29.	Write a method that stores an integer. Each time the method is called, increment the integer by 1. 
 *  Create three threads that call this method 1000 times each, storing the returned result in their own set. 
 *  Print out each thread’s set.
 *  
 *	30.	Synchronize the method that stores and increments the integer. Execute your threads again.
 *	
 *	31.	Review thread-specific methods: 
 *	sleep(), wait(), yield(), suspend(), stop(), resume(), interrupt(), notify(), notifyAll()
 */
import java.util.ArrayList;

public class Threading {

	public static void main(String[] args) {
		// Threads
		TestThread R1 = new TestThread("Thread-1");
		R1.start();

		TestThread R2 = new TestThread("Thread-2");
		R2.start();

		TestThread R3 = new TestThread("Thread-3");
		R3.start();
	}
}

class TestThread implements Runnable {

	static int i = 0;
	// staticint j;
	private Thread t;
	private String threadname;
	ArrayList<Integer> threadset1 = new ArrayList<Integer>();;

	public TestThread(String name) {
		threadname = name;
		System.out.println("Creating " + threadname);
	}

	public synchronized int increment() {
		i = i + 1;
		return i;

	}

	public void start() {
		System.out.println("Starting " + threadname);
		if (t == null) {

			t = new Thread(this, threadname);
			t.start();
		}
	}

	// @SuppressWarnings({ "static-access", "deprecation" })
	public void run() {
		try {
			for (int i = 0; i < 10; i++) {

				int r = increment();
				threadset1.add(r);
			}
		} finally {
			System.out.println(threadname + " - " + threadset1.toString());
		}

		// t.sleep(millis); // causes the currently executing thread to sleep
		// t.notify(); // Wakes up a single thread that is waiting on this
		// object's monitor
		// t.notifyAll();//Wakes up all threads that are waiting on this
		// object's monitor
		// t.wait();//Causes the current thread to wait until another thread
		// invokes the notify() method or the notifyAll() method for this object
		// t.yield();//A hint to the scheduler that the current thread is
		// willing to yield its current use of a processor
		// t.suspend();//This method has been deprecated, as it is inherently
		// deadlock-prone
		// t.resume(); // This method exists solely for use with suspend(),
		// which has been deprecated because it is deadlock-prone
		// t.stop(); //This method is inherently unsafe. Stopping a thread with
		// Thread.stop causes it to unlock all of the monitors that it has
		// locked (as a natural consequence of the unchecked ThreadDeath
		// exception propagating up the stack).
		// t.interrupt(); //Interrupts this thread.
	}

}
