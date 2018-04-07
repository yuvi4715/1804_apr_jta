package multithreading;
// This class establishes the process and objects to be used by another class.
// problem 29 - Method is developed and stored as an integer, a method is used to increment it by 1 each time its called
//				the threads in StartThreads.java then call this method 1000 times as directed by the overrided run() method
// problem 30 - The run and increment methods are now synchronized, and the threads are run again. Remove Synchronize from 
//				methods to get unsynchronized results
// Problem 31 - Simply reviewing methods specific to thread. As of Java 8, some of them are deprecated. They are still listed.
import java.util.HashSet;
import java.util.Set;

public class ThousandTimes implements Runnable{
	static int j;  // this is static for persistence between threads
	String name;
	Set<Integer> threadSet = new HashSet<Integer>(); // used to store individual sets
	// 31
	/* Methods specific to threads.
	 * sleep() - Used to tell the thread to temporarily cease execution for specified amount to time.
	 * 			Can be really useful, especially when ensuring stability or a specific purposes.
	 * Wait() - Wait is similar to sleep() but not quite. A wait()-ing thread can be woken up where 
	 * 			as a sleeping thread can't. Sleep() doesn't have to be in the same block though. I 
	 * 			would use this in cases similar to using sleep(), but when the thread needs to be
	 * 			active even when it is not doing anything, so that it can continue. 
	 * yield()- Tells to the scheduler to be willing to yield a processor, can be very useful
	 * 			in multi-threaded applications where there is a risk of over-utilization of 
	 * 			resources.
	 * suspend()- A method that appears to be deprecated in Java 8, where it puts the thread on hold 
	 * 			until a resume() is given. A sort of red light green light deal here.However using this
	 * 			can cause a thread to be dead-lock prone. Cannot use it now unless using Java 7 or before.
	 * Resume() - Resume has been deprecated, read suspend()
	 * Stop() - Deprecated as of Java 8, was used to actually stop a thread process, could not be resumed.
	 * 			May have used it to check if a critical condition occurred and stop the process.
	 * notify()-Used for waking up a single thread that was waiting on a monitor. Useful for stability
	 * 			and procedural processes requiring a thread to wait until a condition is met
	 * notifyAll() - Same as notify, but it wakes all waiting threads waiting on a monitor.
	 * 			
	 */
	
	public ThousandTimes(String name) {
		this.name = name;
	
	}
	
	int getInt() {
		return j;
	}
	
	synchronized void increment(){
		j = j + 1;
		
	}


	// remove or add synchronized to witness results from the start threads class
	// results are dependent on cpu
	@Override
	public synchronized void run() {
		for (int i = 0; i < 1000 ; i++) {
			increment();
			threadSet.add(getInt());
		}
		
		System.out.println(name + " contains "+ threadSet.toString());
	}
	
	
	
}
		
