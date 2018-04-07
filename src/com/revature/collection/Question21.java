package com.revature.collection;

import java.util.*;
//import java.util.HashMap;
//import java.util.LinkedList;
//import java.util.Map;

public class Question21 {

	public static void main(String[] args) {
		
		ArrayList();
		LinkedList();
		HashMap();
		TreeSet();
		HashSet();
			
		}
	
	static void ArrayList() {
		ArrayList <String> info = new ArrayList<String>();
		info.add("Hello");
		info.add("everyone");
		info.add("Nice to see you all...");
		System.out.println("This is the out of ArrayList");
//		for(String i : info) {
//			System.out.println(i);
//		}
		Iterator itr = info.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	static void LinkedList() {
		LinkedList <String> msg = new LinkedList<>();
		msg.add("LinkedList");
		msg.add("is");
		msg.add("awsome");
		System.out.println("\nThis the output of LinkedList\n");
//		for(String k : msg) {
//			System.out.println(k);
//		}
		Iterator itr = msg.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	static void HashMap() {
		HashMap <Integer,String> personal_info = new HashMap<>();
		personal_info.put(1, "Ajay");
		personal_info.put(2, "Bala");
		personal_info.put(3, "Varun");
		System.out.println("\nThis is the output of HashMap\n");
//		for(Map.Entry pi : personal_info.entrySet()) {
//			System.out.println(pi.getKey() + " " + pi.getValue());
//		}
		Iterator itr = personal_info.entrySet().iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	static void TreeSet() {
		TreeSet <String> ts = new TreeSet<>();
		ts.add("This");
		ts.add("is");
		ts.add("TreeSet");
		System.out.println("\nThis is the output of TreeSet\n");
		Iterator<String> itr = ts.iterator();
		while(itr.hasNext()) {
			System.out.println(itr.next());
		}
	}
	
	static void HashSet() {
		HashSet <String> hs = new HashSet<>();
		hs.add("Last");
		hs.add("function");
		hs.add("of this class");
		System.out.println("\nThis is the output of HashSet\n");
		Iterator<String> i = hs.iterator();
		while(i.hasNext()) {
			System.out.println(i.next());
		}
	}
	
			
			
	

}
