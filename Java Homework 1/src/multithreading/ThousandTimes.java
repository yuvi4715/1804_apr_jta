package multithreading;

import java.util.HashSet;
import java.util.Set;

public class ThousandTimes implements Runnable{
	int j = 0;
	Set<Integer> threadSet1 = new HashSet<Integer>();
	Set<Integer> threadSet2 = new HashSet<Integer>();
	Set<Integer> threadSet3 = new HashSet<Integer>();
	
	public ThousandTimes() {

		System.out.println(threadSet1.toString());
		System.out.println(threadSet2.toString());
		System.out.println(threadSet3.toString());
		
	}
	
	
	public static void main(String[] args) {
		ThousandTimes t = new ThousandTimes();
		
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
