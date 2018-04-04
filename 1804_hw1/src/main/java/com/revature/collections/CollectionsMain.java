package com.revature.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

// Solution to hw1 problem #

public class CollectionsMain {
		
	public static void main(String[] args) {
		
		// Create, iterate through and sort an ArrayList
		
		ArrayList<String> arrayList = new ArrayList<String>();
	
		arrayList.add("New York");
		arrayList.add("Baltimore");
		arrayList.add("Chicago");
		
		Iterator<String> iter = arrayList.iterator();
		
		System.out.println("Original print from ArrayList: ");
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		arrayList.sort(null);
		
		iter = arrayList.iterator();
		
		System.out.println("\nAfter sorting ArrayList: ");
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// Create, iterate through and sort a LinkedList
		
		LinkedList<String> linkedList = new LinkedList<String>();
	
		linkedList.add("New York");
		linkedList.add("Baltimore");
		linkedList.add("Chicago");
		
		iter = linkedList.iterator();
		
		System.out.println("\nOriginal print from LinkedList: ");
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		linkedList.sort(null);
		
		iter = linkedList.iterator();
		
		System.out.println("\nAfter sorting LinkedList: ");
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		// Create, iterate through and sort a HashMap
		
		HashMap<Integer, String> hashMap = new HashMap<Integer, String>();
		
		hashMap.put(1, "New York");
		hashMap.put(2, "Baltimore");
		hashMap.put(3, "Chicago");
		
		Set<Integer> hashMapKeySet = hashMap.keySet();
		
		Iterator<Integer> intIter = hashMapKeySet.iterator();
		
		System.out.println("\nOriginal print from HashMap: ");
		
		while (intIter.hasNext()) {
			int currKey = intIter.next();
			
			System.out.println(hashMap.get(currKey));
		}
		
		System.out.println("\nAfter sorting HashMap: \nHashMap cannot be sorted "
				+ "without using a different collection.");
	
		// Create, iterate through and sort a TreeSet
		
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("New York");
		treeSet.add("Baltimore");
		treeSet.add("Chicago");
		
		iter = treeSet.iterator();
		
		System.out.println("\nOriginal print from TreeSet: ");
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("\nAfter Sorting TreeSet:\nTreeSet is "
				+ "sorted on insertion so there is no need to sort it again.");
		
		// Create, iterate through and sort a HashSet
		
		HashSet<String> hashSet = new HashSet<String>();
		
		hashSet.add("New York");
		hashSet.add("Baltimore");
		hashSet.add("Chicago");
		
		iter = hashSet.iterator();
		
		System.out.println("\nOriginal print from HashTree: ");
		
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("\nAfter sortering HashSet:\nHashSet cannot be "
				+ "sorted without the use of another collection.");
	}
}
