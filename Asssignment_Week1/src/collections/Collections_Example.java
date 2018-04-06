package collections;
//Kevin Rivera - Revature
//Assignment Week 1: Collections - Problem 21, 22, 23.
//This class contains an examples of classes that extend the Collection class,
//and how to add items, iterate, sort, and print their items.

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

public class Collections_Example {
	public static void main(String[] args) {
		// Create an ArrayList and add 3 items
		ArrayList<String> al = new ArrayList<String>();
		al.add("String 3");
		al.add("String 2");
		al.add("String 1");
		// Create a LinkedList and add 3 items
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("String 33");
		ll.add("String 22");
		ll.add("String 11");
		// Create a HashMap and add 3 items
		HashMap<String, Double> hm = new HashMap<String, Double>();
		hm.put("Kevin", 200.0);
		hm.put("Peter", 300.0);
		hm.put("Rose", 400.0);
		// Create a TreeSet and add 3 items
		TreeSet<String> ts = new TreeSet<String>();
		ts.add("Kevin");
		ts.add("Rose");
		ts.add("John");
		// Create a HashSet and add 3 items
		HashSet<String> hs = new HashSet<String>();
		hs.add("Kevin");
		hs.add("Ryan");
		hs.add("Goldo");
		//Print, then sort, then print again each collection
		printCollection(al.iterator());
		printCollection(ll.iterator());
		printCollection(ts.iterator());
		printCollection(hs.iterator());
		printCollection(hm.keySet().iterator(), hm.values().iterator());
		
		//Sort lists using Collections.sort()
		Collections.sort(al);
		Collections.sort(ll);
		
		//Put HashMap inside TreeMap which is sorted by default
		TreeMap<String,Double> tm = new TreeMap<>();
		tm.putAll(hm);
		
		//TreeSet ts is already sorted because it implements Sortedtree
		
		//Put HashSet inside TreeSet which is sorted by default
		TreeSet<String> treeSet = new TreeSet<>();
		treeSet.addAll(hs);
		
		//Now print sorted collections
		printCollection(al.iterator());
		printCollection(ll.iterator());
		printCollection(ts.iterator());
		printCollection(tm.keySet().iterator(), tm.values().iterator()); //treeMap, sorted HashMap
		printCollection(treeSet.iterator()); //treeSet, sorted HashSet
	}
	
	//Iterate through collection and print. Works with classes that implement the iterator() method.
	public static void printCollection(Iterator<String> it) {
		while(it.hasNext()) {
			System.out.println(it.next());
		}
	}
	//Iterate through collection and print. Works with classes that implement the iterator() method.
	//Overloaded for HashMap
	public static void printCollection(Iterator<String> it1, Iterator<Double> it2) {
		while(it1.hasNext() && it2.hasNext()) {
			System.out.println(it1.next() + " : " + it2.next());
		}
	}
}
