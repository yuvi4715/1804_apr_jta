/**
 * 
 */
package com.revature.assignments.weekone.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
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

	public void iterateArrayList() {
		ArrayList<String> alist = collectionOfCollections.getAlist();
	}

	public void iterateLinkedList() {
		LinkedList<String> llist = collectionOfCollections.getLlist();
	}

	public void iterateHashMap() {
		HashMap<Integer, String> hmap = collectionOfCollections.getHmap();
	}

	public void iterateTreeSet() {
		TreeSet<String> tset = collectionOfCollections.getTset();
	}

	public void iterateHashSet() {
		HashSet<String> hset = collectionOfCollections.getHset();
	}

}
