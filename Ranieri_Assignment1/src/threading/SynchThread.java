package threading;

public class SynchThread implements Runnable {
	
	
public static int i;
	

@Override

public synchronized void run() {
	System.out.println("Wassup from a synched thread" + i);
	
	for (int k = 0; k < 1000; k++) {
		i++;
		System.out.println(i +" synched thread");
	}
	
}
		

}


