package multithreading3;

import java.util.LinkedList;
import java.util.List;

public class Problem31 {

	public static void main(String[] args) {
		
		//create three threads that call incrementNum 1000
		//times each. Store those numbers
		
		LearnToRun r1 = new LearnToRun("Thread 1");
		
		//LearnToRun r2 = new LearnToRun("Thread 2");
		
		//LearnToRun r3 = new LearnToRun("Thread 3");
		
		r1.start();
		
		//r2.start();
		
		//r3.start();
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	

	
	
	
}

class LearnToRun implements Runnable {
	
	private Thread t;
	private String threadName;
	int storedNum;
	List<Integer> numList = new LinkedList<>();
	
	
	
	public LearnToRun(String name) {
		
		threadName = name;
		storedNum = 0;
		
		
		
	}

	@Override
	public void run() {
		
		try {
			
			//make a call to incrimentNum
			for(int i = 0; i < 10000; i++) {
				
				//synchronized(this) {
					numList.add(storeInt());
				//}
				System.out.println(threadName + " listing: " + i);
				Thread.sleep(5);
				
				if(i == 9001) {
					
					t.stop();
					
				}
				
			}
			
			printList();
			
		} catch (InterruptedException e) {
			
			System.out.println(threadName + " done goofed on " + storedNum + ".");
			
		}
		
		
	}
	
	
	public synchronized void start() {
		
		t = new Thread (this, threadName);
		t.start();
		
	}
	
	
	public void printList() {
		
		for(Integer i : numList) {
			
			System.out.println(threadName + " printing: " + i.intValue());
			
		}
	
	}
	
	public int storeInt() {
		
		storedNum++;
		return storedNum;
		
		
		
		
		
	}
	
	
	
	
	
}
