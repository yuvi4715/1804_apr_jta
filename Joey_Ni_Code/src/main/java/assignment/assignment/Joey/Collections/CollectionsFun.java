package assignment.Joey.Collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import java.util.TreeMap;
import java.util.TreeSet;

/**
1. Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3 objects into each.
2. Iterate over each collection and print each object.
3. Sort the collections and compare the original to the sorted collection.
 * @author joeyi
 *
 */
public class CollectionsFun {
	
	public static void main(String[] args) {
	
		collectionExercise();
		
	}
	public static void collectionExercise() {
		
		ArrayList<String> al = new ArrayList<>();
		LinkedList <String> LL = new LinkedList<>();
		HashMap <Integer, String> hm = new HashMap<>();
		TreeSet <String> ts =new TreeSet<>();
		HashSet <String> hs =new HashSet<>();
		String a="Hello";
		Collections.addAll(al, a, "world", "Joey");
		Collections.addAll(LL, a, "Linked", "List");
		Collections.addAll(ts, a, "Tree", "Map");
		Collections.addAll(hs, a, "Hash", "Set");
		//hm =Map.of(new Customer(), 0, new Customer(), 1); Java 9 or Groovy
		//Java has no Map literal
		String b="Hash";
		String c="Map";
		hm.put(a.length(), a); //hashcode can be used
		hm.put(b.length(), b);
		hm.put(c.length(), c);
		//Iterator it = new Iterator();
		//Iterate through map
		
		for(String i: al) System.out.println("arrayList"+i); //Arraylist iterate
		for(String i:LL) System.out.println("LinkedList"+i); //Linkedlist
		for(Entry<Integer, String> e: hm.entrySet()) {
			 System.out.println("HashMap Key:" + e.getKey() +" Value:" +e.getValue());
		}
		
		for(String i: ts) System.out.println("treeset"+i); //treeset
		for(String i: hs) System.out.println("hashset"+i); //hashset
		Collections.sort(al);
		Collections.sort(LL);
		//Map <Integer, String> tm =new TreeMap<>(new IntegerComparator());
		Map<Integer, String> ym= new TreeMap<>((s1,s2)-> {return s2.compareTo(s1);});
		ym.putAll(hm);
		for(Entry<Integer, String> e: ym.entrySet()) {
			 System.out.println("New HashMap/TreeMap Key:" + e.getKey() +" Value:" +e.getValue());
		}
		
		Set<String> sortedTS = new TreeSet<>((p1,p2) -> {return (p1.compareTo(p2));});
		sortedTS.addAll(ts);
		
		Set<String> sortedHS = new TreeSet<>((p1,p2) -> {return (p1.compareTo(p2));});
		sortedHS.addAll(hs);
		for(String i: sortedTS) System.out.println("sortedtreeset"+i); //treeset
		for(String i: sortedHS) System.out.println("sortedhashset"+i); //hashset
	//	Map<Integer, String> trainers2 = new TreeMap<>(new StringComparator());
	}
	

	
	class StringComparator implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareToIgnoreCase(o2);
		}
		
	}
	
	

}
