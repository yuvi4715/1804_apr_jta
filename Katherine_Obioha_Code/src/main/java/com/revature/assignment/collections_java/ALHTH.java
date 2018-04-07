package collections_java;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * @author kathe Create an ArrayList.LinkedList.HashMap.HashSet Insert 3 objects
 *         in each. Iterate over each collection and print. Lastly sort the
 *         collectionsand compare the original to the sorted collections
 * 
 */
public class ALHTH {

	public static void main(String[] args) {
		ALHTH operate = new ALHTH();
		// operate.arraylist();
		// operate.linkedlist();
		// operate.treeset();
		operate.hashmap();
		// operate.hashset();
	}

	public void arraylist() {
		ArrayList<Integer> one = new ArrayList<Integer>();
		one.add(20);
		one.add(40);
		one.add(30);

		for (int i = 0; i < one.size(); i++) {
			System.out.print(one.get(i) + ", ");
		}
		System.out.println(" ");
		// one.sort(null);
		Collections.sort(one);
		for (int i = 0; i < one.size(); i++) {
			System.out.print(one.get(i) + ", ");
		}
	}

	public void linkedlist() {
		LinkedList<String> two = new LinkedList<String>();
		two.add("Time");
		two.add("Does");
		two.add("Go");

		ListIterator<String> iterator = two.listIterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + ", ");
		}
		// since it is a list you can also get with indexes however the
		// advantage of
		// iterator is that you can insert an element in a given position

		System.out.println(" ");
		Collections.sort(two);

		// Collections.sort(two, Collections.reverseOrder());

		ListIterator<String> iterator1 = two.listIterator();
		while (iterator1.hasNext()) {
			System.out.print(iterator1.next() + ", ");
		}

	}

	public void hashmap() {
		HashMap<Integer, String> now = new HashMap<Integer, String>();
		now.put(1, "Katherine");
		now.put(4, "Tom");
		now.put(3, "Time");
		now.put(0, "Mine");

		Set<Integer> ss = now.keySet();
		for (Integer n : ss) {
			String value = now.get(n);
			System.out.println(n + " :" + value);
		}

		// or

		// Set<Entry<String, String>> entries = now.entrySet();
		// for(Entry<String, String> entry : entries)
		// { System.out.println(entry.getKey() + " ==> " + entry.getValue()); }

		System.out.println("------ ");
		// sort
		TreeMap ne = new TreeMap(now);
		Set<Entry<Integer, String>> entries = ne.entrySet();
		for (Entry<Integer, String> entry : entries) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}


	}

	public void treeset() {
		Set<String> four = new TreeSet<String>();
		four.add("Apple");
		four.add("Oranges");
		four.add("Banana");

		// TreeSet is an ordered Collection so iteration before sorted
		// will look the same as iterations after sorted
		// use iterator not ListIterator -- (diff you can not add element with
		// iterator in the current position unlike ListIterator) or enhanced
		// forloop

		for (String e : four) {
			System.out.print(e + ", ");

		}

		System.out.println("");
		// sort
		List<String> sortset = new ArrayList(four);

		Collections.sort(sortset);

		for (String e : sortset) {
			System.out.print(e + ", ");

		}

	}

	public void hashset() {
		HashSet<Integer> till = new HashSet<Integer>();
		till.add(90);
		till.add(70);
		till.add(100);

		Iterator<Integer> iterate = till.iterator();
		while (iterate.hasNext()) {
			System.out.print(iterate.next() + ", ");
		}

		System.out.println(" ");
		List<Integer> sortset = new ArrayList(till);
		Collections.sort(sortset);

		for (Integer t : sortset) {
			System.out.print(t + ", ");
		}

	}

}
