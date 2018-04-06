package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class newCollections {

	private static final Object String = null;

	public static void main(String[] args) {
		/*
		 * 21. Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert
		 * 3 objects into each. 22. Iterate over each collection and print each object.
		 * 23. Sort the collections and compare the original to the sorted collection.
		 */
		ArrayList<String> ProgrammingLanguages = new ArrayList<String>();
		ProgrammingLanguages.add("C");
		ProgrammingLanguages.add("Python");
		ProgrammingLanguages.add("Java");
		System.out.println("Unsorted ArrayList: ");
		for (String iterate : ProgrammingLanguages)
			System.out.println(iterate);
		Collections.sort(ProgrammingLanguages);
		System.out.println("Sorted ArrayList: ");
		for (String iterate : ProgrammingLanguages)
			System.out.println(iterate);

		LinkedList<String> Fruits = new LinkedList<String>();
		System.out.println("Unsorted LinkedList: ");
		Fruits.add("Banana");
		Fruits.add("Apple");
		Fruits.add("Orange");
		for (String iterate : Fruits)
			System.out.println(iterate);
		Collections.sort(Fruits);
		System.out.println("Sorted LinkedList: ");
		for (String iterate : Fruits)
			System.out.println(iterate);

		HashMap<Integer, String> Locations = new HashMap<Integer, String>();
		System.out.println("HashMap: ");
		Locations.put(7, "New York");
		Locations.put(3, "Charlotte");
		Locations.put(5, "Reston");
		newCollections.iterateMap(Locations);
		List sortedKeys = new ArrayList(Locations.keySet());
		Collections.sort(sortedKeys);
		System.out.println(sortedKeys);
		
		
		System.out.println("Ascending TreeSet: ");
		TreeSet<String> Brands = new TreeSet<String>();
		Brands.add("Nike");
		Brands.add("Puma");
		Brands.add("Asus");
		newCollections.iterateTree(Brands);
		System.out.println("Descending TreeSet: ");
		TreeSet<String> sortedBrand = new TreeSet<String>(new MyComparator());
		sortedBrand.add("Nike");
		sortedBrand.add("Puma");
		sortedBrand.add("Asus");
		for (String element : sortedBrand)
		  System.out.println(element);
		System.out.println();

		HashSet<String> drones = new HashSet<String>();
		drones.add("Drone D");
		drones.add("Drone S");
		drones.add("Drone A");
		newCollections.iterateSet(drones);
	}

	public static void iterateMap(Map locations) {
		Iterator read = locations.entrySet().iterator();
		while (read.hasNext()) {
			Map.Entry pair = (Map.Entry) read.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
		}
	}

	public static void iterateTree(TreeSet brands) {
		Iterator read = brands.iterator();
		while (read.hasNext()) {
			System.out.println(read.next());
		}
	}

	public static void iterateSet(Set numbers) {
		Iterator read = numbers.iterator();
		while (read.hasNext())
			System.out.println(read.next());
	}

}

class MyComparator implements Comparator<String> {
	  public int compare(String a, String b) {
	    String aStr, bStr;
	    aStr = a;
	    bStr = b;
	    return bStr.compareTo(aStr);
	  }
}

