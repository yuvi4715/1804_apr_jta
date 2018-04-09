package Multithreading;

public class ImplementRunnableInterface implements Runnable{

	
	
	@Override
	public void run() {
		for (int i=0; i<10; i++) {
			try {
				Thread.sleep(100);
				System.out.println(i + Thread.currentThread().getName());
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}