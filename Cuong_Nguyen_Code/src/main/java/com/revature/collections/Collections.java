package com.revature.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Collections {

	public static void main(String[] args) {
		/*
		 * 21.Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3
		 * objects into each.
		 */
		ArrayList<String> ProgrammingLanguages = new ArrayList<String>();
		ProgrammingLanguages.add("C");
		ProgrammingLanguages.add("Java");
		ProgrammingLanguages.add("Python");
		System.out.println("Array List of Programming Languages: " + ProgrammingLanguages);

		LinkedList<String> Fruits = new LinkedList<String>();
		Fruits.add("Apple");
		Fruits.add("Banana");
		Fruits.add("Orange");
		System.out.println("Linked List of Fruits: " + Fruits);

		HashMap<Integer, String> Tolls = new HashMap<Integer, String>();
		Tolls.put(1, "Washington");
		Tolls.put(3, "Highways");
		Tolls.put(5, "Reston");
		Set TollAmount = Tolls.entrySet();
		Iterator TollCollector = TollAmount.iterator();

		while (TollCollector.hasNext()) {
			Map.Entry Gate = (Map.Entry) TollCollector.next();
			System.out.println("" + Gate.getKey() + "");
			System.out.println(Gate.getValue());
		}

	}

}
