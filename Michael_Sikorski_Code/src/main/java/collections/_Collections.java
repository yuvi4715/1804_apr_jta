package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.List;

public class _Collections {
	
	static ArrayList<Integer> al;
	static LinkedList<Integer> ll;
	static HashMap<Integer,String> hm;
	static TreeSet<Integer> ts;
	static HashSet<Integer> hs;

	public static void main(String[] args) {
		Question21();
		Question22();
		Question23();
	}

	public static void Question21() {
		System.out.println("-- Question 21 --");
		
		Collection<Integer> c = Arrays.asList(2,1,0);

		al = new ArrayList<>();
		al.addAll(c);
		
		ll = new LinkedList<>();
		ll.addAll(c);
		
		hm = new HashMap<>();
		hm.put(0, String.valueOf(2));
		hm.put(1, String.valueOf(1));
		hm.put(2, String.valueOf(0));
		
		ts = new TreeSet<>();
		ts.addAll(c);
		
		hs = new HashSet<>();
		hs.addAll(c);

		System.out.println("3 objects have been added to each collection");
		System.out.println();
	}

	public static void Question22() {
		System.out.println("-- Question 22 --");
		
		System.out.print(al.getClass().getName()+" originally contains: ");
		for (Integer i : al) {
			System.out.print(i + " ");
		} System.out.println();		
		
		System.out.print(ll.getClass().getName()+" originally contains: ");
		for (Integer i : ll) {
			System.out.print(i + " ");
		} System.out.println();
		
		System.out.print(hm.getClass().getName()+" originally contains: ");
		for (int i=0; i<3; i++) {
			System.out.print(hm.get(i) + " ");
		} System.out.println();
		
		System.out.print(ts.getClass().getName()+" originally contains: ");
		for (Integer i : ts) {
			System.out.print(i + " ");
		} System.out.println();
		
		System.out.print(hs.getClass().getName()+" originally contains: ");
		for (Integer i : hs) {
			System.out.print(i + " ");
		} System.out.println();
		System.out.println();
	}

	public static void Question23() {
		System.out.println("-- Question 23 --");
		Collections.sort(al);
		Collections.sort(ll);
		System.out.print("After sorting, " + al.getClass().getName()+" contains: ");
		for (Integer i : al) {
			System.out.print(i + " ");
		} System.out.println();		
		
		System.out.print("After sorting, " + ll.getClass().getName()+" contains: ");
		for (Integer i : ll) {
			System.out.print(i + " ");
		} System.out.println();
		
		System.out.println(hm.getClass().getName() + " cannot be sorted"); 
		System.out.println(ts.getClass().getName() + " cannot be sorted");
		System.out.println(hs.getClass().getName() + " cannot be sorted");
		
		System.out.println();
	}

}
