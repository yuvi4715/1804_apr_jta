package question29to31;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class MultiThread implements Runnable{
	
	private Thread t;
	private String tName;
	Set<Integer> set1 = new HashSet<Integer>();
	Set<Integer> set2 = new HashSet<Integer>();

	public MultiThread(String tName) {
		super();
		this.tName = tName;
	}

	public void run() {
		System.out.println("Running"+tName);
		for(int i=0;i<1000;i++) {
			set1.add(IncrementInteger.increment());
			set2.add(SycronizedIncrementedInteger.increment());
			//System.out.println(tName+": i equals: "+ IncrementInteger.getI());
			//System.out.println(tName+": i equals: "+ SycronizedIncrementInteger.getI());
		}
		System.out.println(tName+": Exiting");
		List<Integer> sSet1 = new ArrayList<Integer>(set1);
		List<Integer> sSet2 = new ArrayList<Integer>(set2);
		Collections.sort(sSet1);
		Collections.sort(sSet2);
		System.out.println(tName+": Not Sycronized in Order: "+sSet1);
		System.out.println(tName+": Sycronized in Order: "+sSet2);
		System.out.println(tName+": Not Sycronized: "+set1);
		System.out.println(tName+": Sycronized: "+set2);
	}
	
	public void start() {
		System.out.println("Starting: "+tName);
		if(t==null) {
			t=new Thread(this,tName);
			t.start();
		}
	}
	
}
