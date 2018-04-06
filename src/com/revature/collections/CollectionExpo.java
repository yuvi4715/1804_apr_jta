package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.SortedSet;
import java.util.TreeSet;

public class CollectionExpo {
//problem 21, 22, 23
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < 3; i++) {
			al.add((int)(Math.random() * 100 +1));
			ll.add((int)(Math.random() * 100 +1));
			hm.put(i,"This is a random number: " + (int)(Math.random() * 100 +1));
			ts.add((int)(Math.random() * 100 +1));
			hs.add((int)(Math.random() * 100 +1));
		}
		for (int i = 0; i < 3; i++) {
			System.out.println(al.get(i));
			System.out.println(ll.get(i));
			System.out.println(hm.get(i));
			System.out.println(ts.toArray()[i]);
			System.out.println(hs.toArray()[i]);
		}
		
		
		Collections.sort(al);
		Collections.sort(ll); 
		Collections.synchronizedSortedSet((SortedSet<Integer>) ts);
	}

}

