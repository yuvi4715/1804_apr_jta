package threading;

import java.util.ArrayList;

public class ThreadRunnable implements Runnable {

	public static int i;
	
	@Override
	public void run() {
		System.out.println("Wassup from a unsycnched thread" + i);
		
		for (int k = 0; k < 1000; k++) {
			i++;
			System.out.println(i +" unsynched thread");
		}
		
	}
	
	
	// I found the multithreading very confusing but I think I figured it out
	// 
	public static void main(String[] args) throws InterruptedException  {
		
		
		// Initialize unsynchronized threads
				Thread unThread1 = new Thread(new ThreadRunnable());
				Thread unThread2 = new Thread(new ThreadRunnable());
				Thread unThread3 = new Thread(new ThreadRunnable());
				
				unThread1.start();
//				unThread2.start();
//				unThread3.start();
				
//		// Initialize synchronized threads
				Thread synThread1 = new Thread(new SynchThread());
				Thread synThread2 = new Thread(new SynchThread());
				Thread synThread3 = new Thread(new SynchThread());
			
				synThread1.start();
//				synThread2.start();
//				synThread3.start();
				
				

		
	}
	
	
	
		
	}







