package com.revature.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;

public class CollectionExpo {
//problem 21, 22
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		LinkedList<Integer> ll = new LinkedList<Integer>();
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		TreeSet<Integer> ts = new TreeSet<Integer>();
		HashSet<Integer> hs = new HashSet<Integer>();
		for (int i = 0; i < 3; i++) {
			al.add((int)(Math.random() * 100 +1));
			ll.add((int)(Math.random() * 100 +1));
			hm.put((int)(Math.random() * 100 +1),"This is" + (int)(Math.random() * 100 +1));
			ts.add((int)(Math.random() * 100 +1));
			hs.add((int)(Math.random() * 100 +1));
		}
		
	}

}
