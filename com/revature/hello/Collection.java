package com.revature.hello;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class Collection {

	public static void main(String[] args) {

		// Collections
		// 21 Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3
		// objects into each.
		ArrayList<Integer> a = new ArrayList<>();
		LinkedList<Integer> l = new LinkedList<>();
		HashMap<Integer, String> m = new HashMap<>();
		TreeSet<Integer> t = new TreeSet<>();
		HashSet<Integer> s = new HashSet<>();

		a.add(4);
		a.add(1,3);
		a.add(0,-7);
		for(int i : a) {
			System.out.println(i);
		}
		l.addFirst(1);
		l.add(4);
		l.addLast(11);
		l.add(0,-7);
		for(int i : l) {
			System.out.println(i);
		}

	}

	// 22 Iterate over each collection and print each object.

	// 23 Sort the collections and compare the original to the sorted collection.

}
