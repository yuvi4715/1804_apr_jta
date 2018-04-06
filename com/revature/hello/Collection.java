package com.revature.hello;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Collection {

	public static void main(String[] args) {
		// Collections
		// 21 Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3
		// objects into each.

		// 22 Iterate over each collection and print each object.

		// 23 Sort the collections and compare the original to the sorted collection.
		ArrayList<Integer> a = new ArrayList<>();
		a.add(99);
		a.add(1, 3);
		a.add(0, -7);
		System.out.println("Unsorted ArrayList:");
		for (int i : a) {
			System.out.println(i);
		}
//		Comparator<Integer> nums = (Integer x, Integer y) -> x - y;		
		a.sort((Integer x, Integer y) -> x - y);		 // LAMBDA
		System.out.println("sorted ArrayList:");
		for (int i : a) {
			System.out.println(i);
		}
		
		LinkedList<Integer> l = new LinkedList<>();
		l.addFirst(1);
		l.add(4);
		l.addLast(11);
		l.add(0, -7);
		System.out.println("Unsorted LinkedList:");
		for (int i : l) {
			System.out.println(i);
		}
		System.out.println("sorted LinkedList:");
		l.sort((Integer x, Integer y) -> x - y);		 // Java 8+
		for (int i : l) {
			System.out.println(i);
		}

		
//		HashMap<Integer, String> m = new HashMap<>();
//		m.put(9, "value1");
//		m.put(-9, "value2");
//		m.put(7, "value3");
//		System.out.println("Unsorted HashMap:");
//		for (int k : m.keySet()) {
//			System.out.println(k + " " + m.get(k));
//		}
//		System.out.println("sorted HashMap:");
//		m.sort((Integer x, Integer y) -> x - y);		 // Java 8+
//		for (int k : m.keySet()) {
//			System.out.println(k + " " + m.get(k));
//		}

		TreeSet<Integer> t = new TreeSet<>();
		t.add(1);
		t.add(7);
		t.add(3);
		t.add(0);
		t.add(67);
		t.add(-8);
		System.out.println("TreeSet is always sorted:");
		for (int i : t) {
			System.out.println(i);
		}

		
		HashSet<Integer> s = new HashSet<>();
		s.add(7);
		s.add(13);
		s.add(11);
		s.add(0);
		s.add(67);
		s.add(-8);
		System.out.println("Unsorted HashSet:");
		for (int i : s) {
			System.out.println(i);
		}
		System.out.println("sorted HashSet:");
//		s.sort((Integer x, Integer y) -> x - y);		 // Java 8+
		for (int i : s) {
			System.out.println(i);
		}

	}

}
