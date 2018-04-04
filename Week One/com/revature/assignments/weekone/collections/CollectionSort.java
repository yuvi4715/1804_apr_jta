/**
 * 
 */
package com.revature.assignments.weekone.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.TreeSet;
import java.util.Map.Entry;

/**
 * @author Ed M
 * @date Apr 4, 2018
 * @time time 1:44:21 PM
 */
public class CollectionSort {
	private CollectionCreation collectionOfCollections;

	/// Q23
	public CollectionSort(CollectionIteration ci) {
		collectionOfCollections = ci.getCollectionOfCollections();

	}

	public ArrayList<String> sortArrayList() {
		ArrayList<String> alist = collectionOfCollections.getAlist();
		Collections.sort(alist);
		for (String temp : alist)
			System.out.println(temp);
		return alist;
	}

	public ListIterator<String> sortLinkedList() {
		ListIterator<String> llist = collectionOfCollections.getLlist().listIterator();
		while (llist.hasNext())
			System.out.println(llist.next());
		return llist;
	}

	public HashMap<Integer, String> sortHashMap() {
		HashMap<Integer, String> hmap = collectionOfCollections.getHmap();
		
		// Making Hash Map into a List for the use of Collection.sort and Compare at the valuse of the string.
		List<Map.Entry<Integer, String>> list = new LinkedList<Map.Entry<Integer, String>>(hmap.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<Integer, String>>() {
			public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});
		// back into a Hashmap so i reuse the my iteration code
		Map<Integer, String> sortedMap = new LinkedHashMap<Integer, String>();
        for (Map.Entry<Integer, String> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

		for (Entry<Integer, String> entry : sortedMap.entrySet()) {
			Integer key = entry.getKey();
			String value = entry.getValue();
			System.out.println("Key: " + key.toString() + " Value: " + value);
		}
		return hmap;
	}

	public TreeSet<String> sortTreeSet() {
		TreeSet<String> tset = collectionOfCollections.getTset();
		Iterator<String> iterator;
		iterator = tset.iterator();
		while (iterator.hasNext())
			System.out.println(iterator.next());
		return tset;

	}

	public HashSet<String> sortHashSet() {
		HashSet<String> hset = collectionOfCollections.getHset();
		Iterator<String> iterator = hset.iterator();

		// check values
		while (iterator.hasNext())
			System.out.println(iterator.next());
		return hset;

	}

}
