package multithreading;
// class serves as means to instantiate threads and begin the processes noted in ThousanTimes.java
public class StartThreads {

	public static void main(String[] args) {
		ThousandTimes t1 = new ThousandTimes("Thread 1");
		t1.run();
		
		ThousandTimes t2 = new ThousandTimes("Thread 2");
		t2.run();
		
		ThousandTimes t3 = new ThousandTimes("Thread 3");
		t3.run();
	
	}

}
