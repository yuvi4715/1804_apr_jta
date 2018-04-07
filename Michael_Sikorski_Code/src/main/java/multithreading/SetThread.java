package multithreading;

import java.util.HashSet;

public class SetThread implements Runnable {

	private HashSet<Integer> hs;
	private int integer;

	public SetThread() {
		hs = new HashSet<>();
		run();
	}

	@Override
	public void run() {
		for (int j=0; j<1000; j++) {
			//hs.add(storeInteger(j));
			hs.add(synchronizedStoreInteger(j));
		}
	}

	public HashSet<Integer> getSet() {
		return hs;
	}

	public int storeInteger(int i) {
		integer = i;
		//hs.add(integer);
		integer++;
		return integer;
	}

	public synchronized int synchronizedStoreInteger(int i) {
		integer = i;
		integer++;
		return integer;
	}

}
