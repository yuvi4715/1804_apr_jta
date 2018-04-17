package Multithreading;

public class ThreadTest {

	public static void main(String[] args) {
		Thread1 t1 = new Thread1("t1");
		t1.start();
		Thread1 t2 = new Thread1("t2");
		t2.start();
		Thread t3 = new Thread1("t3");
		t3.start();

		
	}

}
