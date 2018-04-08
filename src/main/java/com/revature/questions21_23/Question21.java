package com.revature.questions21_23;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeSet;

public class Question21 {

	public static void main(String[] args) {
		weirdArrays();
		
	}
	
	//Question 21 and Question 22
	//As for Question 23, the collections are as expected except hashsets which I can't figure out. 
	public static void weirdArrays() {
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(10);
		al.add(100);
		al.add(1000);
	
		LinkedList<Integer> ll = new LinkedList<Integer>();
		ll.add(10);
		ll.add(100);
		ll.add(1000);
			
		HashMap<Integer, Integer> mm = new HashMap<Integer, Integer>();
		mm.put(0, 10);
		mm.put(1, 100);
		mm.put(2, 1000);
		
		TreeSet<Integer> ts = new TreeSet<Integer>();
		ts.add(10);
		ts.add(100);
		ts.add(1000);
		
		HashSet<Integer> hs = new HashSet<Integer>();
		hs.add(10);
		hs.add(100);
		hs.add(1000);
		
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Arraylist: " + al.get(i));
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Linked List: " + ll.get(i));
		}
		
		for(int i = 0; i < 3; i++) {
			System.out.println("Hashmap: " + mm.get(i));		
		}
		
	    Iterator<Integer> itr = ts.iterator();
	    while (itr.hasNext()){
	        System.out.println("Treeset: " + itr.next());
			
		}
		
	    Iterator<Integer> itr2 = hs.iterator();
	    while (itr2.hasNext()){
	        System.out.println("Hashset: " + itr2.next());	
		}
	    
	}	
	
}
