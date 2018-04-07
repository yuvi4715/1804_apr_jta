package multithreading;

import java.util.HashSet;

public class _MultiThreading {
	
	static int integer;
	static HashSet<Integer> hs;
	
	public static void main(String[] args) {
		new _MultiThreading();
	}

	public _MultiThreading() {
		
		SetThread st1 = new SetThread();
		SetThread st2 = new SetThread();
		SetThread st3 = new SetThread();
		
		for (int i=0; i<1000; i++) {
			st1.storeInteger(i);
			st2.storeInteger(i);
			st3.storeInteger(i);
		}
		
		System.out.println(st1.getSet());
		System.out.println(st2.getSet());
		System.out.println(st3.getSet());
		
		for (int i=0; i<1000; i++) {
			st1.synchronizedStoreInteger(i);
			st2.synchronizedStoreInteger(i);
			st3.synchronizedStoreInteger(i);
		}
		
		System.out.println(st1.getSet());
		System.out.println(st2.getSet());
		System.out.println(st3.getSet());
	}

}
