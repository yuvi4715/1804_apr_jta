package com.revature.collections;

import java.util.*;
import java.util.Map.Entry;

public class CollectionsMethods {

	void arrayListQuestion() {
		ArrayList<Integer> al = new ArrayList<>();
		al.add(12);
		al.add(43);
		al.add(4);
		
		for(int i : al) {
			System.out.print(i + ", ");
		}
		System.out.println("\nSorting...");
		
		Collections.sort(al);
		
		for(int i : al) {
			System.out.print(i + ", ");
		}
	}
	
	void linkedListQuestion() {
		LinkedList<String> ll = new LinkedList<>();
		ll.add("hello");
		ll.add("Hello");
		ll.add("~!hello");
		
		for(String s : ll) {
			System.out.print(s + ", ");
		}
		
		System.out.println("\nSorting...");
		Collections.sort(ll);
		
		for(String s : ll) {
			System.out.print(s + ", ");
		}
		System.out.println("");
	}
	
	void hashMapQuestion() {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(12, "twelve");
		hm.put(1, "one");
		hm.put(555, "five hundred fifty-five");
		Set<Integer> s = hm.keySet();
		
		for(int i : s) {
			System.out.print("Key: " + i + " Value: " + hm.get(i) + ", ");
		}
		
		System.out.println("\nSorting...");
		Set<Map.Entry<Integer, String>> entries = hm.entrySet();
		List entriesList = new ArrayList(entries);
		Collections.sort(entriesList, new sortHelper());
		
		for(Object E : entriesList) {
			System.out.print(E + ", ");
		}
		System.out.println("");
	}
	
	void treeSetQuestion() {
		TreeSet ts = new TreeSet();
		ts.add("Hello");
		ts.add("Goodbye");
		ts.add("Words");
		
		for(Object s : ts) {
			System.out.print(s + ", ");
		}
		System.out.println("\nI would sort here, but TreeSets are automatically sorted "
				+ "by virtue of being tree-backed");
		
		
	}
	
	void hashSetQuestion() {
		HashSet hs = new HashSet();
		hs.add("Hello");
		hs.add("Goodbye");
		hs.add("Words");
		for(Object s : hs) {
			System.out.print(s + ", ");
		}
		System.out.println("\nSorting...");
		List<String> s = new ArrayList<>();
		int index = 0;
		for(Object o : hs) {
			s.add((String)o);
			index++;
		}
		Collections.sort(s);
		for(String st : s) {
			System.out.print(st + ", ");
		}
	}
	
	class sortHelper implements Comparator<Map.Entry<Integer, String>>{

		@Override
		public int compare(Entry<Integer, String> o1, Entry<Integer, String> o2) {
			return o1.getKey() - o2.getKey();
		}
		
	}
}
