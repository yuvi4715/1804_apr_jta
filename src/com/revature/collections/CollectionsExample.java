package com.revature.collections;

//problems 21-23

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ThreadLocalRandom;

public class CollectionsExample {

	public static void main(String[] args) {

		// Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3
		System.out.println("Creating collections");
		// ArrayList
		List<String> al = new ArrayList<>(3);
		for (int i = 1; i <= 3; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(10, 100 + 1);
			al.add("al" + randomNum);
		}

		// LinkedList
		List<String> ll = new LinkedList<>();
		for (int i = 1; i <= 3; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(10, 100 + 1);
			ll.add("ll" + randomNum);
		}

		// HashMap
		// keys are random int 1-100
		Map<Integer, String> hm = new HashMap<>();
		for (int i = 1; i <= 3; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(10, 100 + 1);
			hm.put(randomNum, "hm" + i);
		}

		// TreeSet
		Set<String> ts = new TreeSet<>();
		for (int i = 1; i <= 3; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(10, 100 + 1);
			ts.add("ts" + randomNum);
		}

		// HashSet
		Set<String> hs = new HashSet<>();
		for (int i = 1; i <= 3; i++) {
			int randomNum = ThreadLocalRandom.current().nextInt(10, 100 + 1);
			hs.add("hs" + randomNum);
		}
		System.out.println(al);
		System.out.println(ll);
		System.out.println(hm);
		System.out.println(ts);
		System.out.println(hs);

		System.out.println("\nIterating through lists");
		// iterate through collections
		// arraylist
		Iterator<String> alIterator = al.iterator();
		while (alIterator.hasNext()) {
			System.out.print(alIterator.next() + " ");
		}
		System.out.println();

		// linkedlist
		Iterator<String> llIterator = ll.iterator();
		while (llIterator.hasNext()) {
			System.out.print(llIterator.next() + " ");
		}
		System.out.println();

		// hashmap
		Set<Integer> hmKeys = hm.keySet();
		for (int key : hmKeys) {
			System.out.print(key + "=>" + hm.get(key) + " ");
		}
		System.out.println();

		// treeset
		for (String s : ts) {
			System.out.print(s + " ");
		}
		System.out.println();

		// hashset
		for (String s : hs) {
			System.out.print(s + " ");
		}
		System.out.println("\n");

		// sorting collections
		System.out.println("Sorted collections");
		Collections.sort(al); // arraylist
		System.out.println(al);
		Collections.sort(ll); // linked list
		System.out.println(ll);

		// hashmap
		TreeMap<Integer, String> sortedhm = new TreeMap<>(); // use TreeMap to store HashMap
		sortedhm.putAll(hm); // Copy all data from hashMap into TreeMap
		
		System.out.println(sortedhm);
		

		// treeset
		System.out.println(ts);// already sorted

		// hashset
		TreeSet<String> sortedhs = new TreeSet<>(); // use TreeMap to store HashMap
		sortedhs.addAll(hs); // Copy all data from hashset into treeset
		hs = sortedhs;// copy treeset to hashset
		System.out.println(hs);

	}

}
