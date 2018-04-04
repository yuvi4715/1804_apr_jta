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
import java.util.Set;

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
		
		TreeSet<String> treeset = collectionOfCollections.getTset();
		TreeSet<String> ts=new TreeSet<String>(String.CASE_INSENSITIVE_ORDER);
		
		Iterator<String> iterator;
		iterator = treeset.iterator();
		while (iterator.hasNext()) {
			ts.add(iterator.next());
			//System.out.println(iterator.next());
		}
		iterator = ts.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
		
		
		//System.out.println("Tree set :: "+ts);
		return ts;
	}

	public  HashSet<String> sortHashSet() {
		HashSet<String> hset = collectionOfCollections.getHset();
		Set<String> set = hset;
		List<String> sortedhset = new ArrayList<String>(set);
		Collections.sort(sortedhset);
		Iterator<String> iterator = set.iterator();

		// check values
		while (iterator.hasNext())
			System.out.println(iterator.next());
		return (hset) ;

	}

}
