/**
 * 
 */
package com.revature.assignments.weekone.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.TreeSet;

/**
 * @author Ed M
 * @date Apr 4, 2018
 * @time time 11:46:13 AM
 */

/// Q22
public class CollectionIteration {
	private CollectionCreation collectionOfCollections;

	/**
	 * 
	 */
	public CollectionIteration() {
		collectionOfCollections = new CollectionCreation();
	}

	public ArrayList<String> iterateArrayList() {
		ArrayList<String> alist = collectionOfCollections.getAlist();
		for (String temp : alist)
			System.out.println(temp);
		return alist;
	}

	public ListIterator<String> iterateLinkedList() {
		ListIterator<String> llist = collectionOfCollections.getLlist().listIterator();
		while (llist.hasNext())
			System.out.println(llist.next());
		return llist;
	}

	public HashMap<Integer,String> iterateHashMap() {
		HashMap<Integer, String> hmap = collectionOfCollections.getHmap();
		for (Entry<Integer, String> entry : hmap.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key.toString() + " Value: " + value);
		}
		return hmap;
	}

	public TreeSet<String> iterateTreeSet() {
		TreeSet<String> tset = collectionOfCollections.getTset();
		Iterator<String> iterator;
		iterator = tset.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		return tset;

	}

	public HashSet<String> iterateHashSet() {
		HashSet<String> hset = collectionOfCollections.getHset();
		Iterator<String> iterator = hset.iterator();

		// check values
		while (iterator.hasNext()) 
			System.out.println(iterator.next());
		return hset;
		
	}

	public CollectionCreation getCollectionOfCollections() {
		return collectionOfCollections;
	}

}
