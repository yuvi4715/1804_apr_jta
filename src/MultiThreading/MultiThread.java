package MultiThreading;

public class MultiThread extends Thread {

	public static void main(String[] args) {
		

		MultiThread t1 = new MultiThread();
		t1.start();
		MultiThread t2 = new MultiThread();
		t2.start();
		MultiThread t3 = new MultiThread();
		t3.start();
		
		System.out.println(t1.getName());
		try {
			t1.sleep(200);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(t2.getName());
//		try {
//			t2.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		t2.stop();
		System.out.println(t3.getName());
		t3.notify();
		
		
	}

}
