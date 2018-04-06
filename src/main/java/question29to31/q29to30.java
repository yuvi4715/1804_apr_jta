package question29to31;

public class q29to30{
	public static void main(String[] args) {
		MultiThread t1 = new MultiThread("Thread1");
		MultiThread t2 = new MultiThread("Thread2");
		MultiThread t3 = new MultiThread("Thread3");
		t1.start();
		t2.start();
		t3.start();
	}
}
