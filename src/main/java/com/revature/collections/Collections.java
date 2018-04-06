package com.revature.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeSet;

public class Collections {

	public static void main(String[] args) {
		
		// Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. 
		// Insert 3 objects into each.

		ArrayList<String> theArrayList = new ArrayList<>();
		LinkedList<String> theLinkedList = new LinkedList<>();
		HashMap<String, String> theHashMap = new HashMap<>();
		TreeSet<String> theTreeSet = new TreeSet<>();
		HashSet<String> theHashSet = new HashSet<>();
		
		theArrayList.add("Jessica Jones");
		theArrayList.add("Daredevil");
		theArrayList.add("Luke Cage");
		
		theLinkedList.add("Iron Man");
		theLinkedList.add("Captain America");
		theLinkedList.add("The Hulk");
		
		theHashMap.put("Spider-Man", "Peter Parker");
		theHashMap.put("Daredevil", "Matt Murdoch");
		theHashMap.put("Black Panther", "T'Challa");
		
		theTreeSet.add("Nick Fury");
		theTreeSet.add("Black Widow");
		theTreeSet.add("Hawkeye");
		
		theHashSet.add("Vision");
		theHashSet.add("Thor");
		theHashSet.add("Scarlet Witch");

		// Iterate over the collections and print each object
		
		for (String hero : theArrayList) {
			System.out.println(hero);
		}
		
		for (String hero : theLinkedList) {
			System.out.println(hero);
		}
		
		Iterator items = theHashMap.entrySet().iterator();
		while (items.hasNext()) {
		    Map.Entry entry = (Map.Entry) items.next();
		    String key = (String) entry.getKey();
		    String value = (String) entry.getValue();
		    System.out.println("Key = " + key + ", Value = " + value);
		}
		
		for (String hero : theTreeSet) {
			System.out.println(hero);
		}
		
		for (String hero : theHashSet) {
			System.out.println(hero);
		}
		
		// Sort the collecions and compare the original to the sorted collection
		
		System.out.println("theArrayList: " + theArrayList);
		theArrayList.sort((a, b) -> a.compareTo(b));
		System.out.println("theArrayList after sort: " + theArrayList);
		
		System.out.println("theLinkedList: " + theLinkedList);
		theLinkedList.sort((a, b) -> a.compareTo(b));
		System.out.println("theLinkedList after sort: " + theLinkedList);
		
		// TODO sort the HashMap
		System.out.println("The HashMap " + theHashMap);
		ArrayList<String> al = new ArrayList();
		LinkedHashMap<String, String> lhm = new LinkedHashMap<>();
		Iterator it = theHashMap.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			al.add((String) pair.getKey());
			it.remove();
		}
		al.sort(null);
		System.out.println("List after while loop: " + al);
		for (String hero : al) {
			lhm.put(hero, theHashMap.get(hero));
		}
		System.out.println("Linked Hash Map: " + lhm);
		
		// End of HashMap Sorting experiment
		
		System.out.println("theTreeSet is already sorted " + theTreeSet);
		
		System.out.println("theHashSet: " + theHashSet);
		TreeSet<String> newTree = new TreeSet<>(theHashSet);
		System.out.println("Sorted copy of theHashSet: " + newTree);
	}
}
