package Multithreading;

public class SynchronizedIncrementor {
    static int inc = 0;
	
	public SynchronizedIncrementor() {
		
	}

	public synchronized int increase() {
		inc++;
		return inc;
	}
}
