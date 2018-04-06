package questions21to23;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.Collections;
import java.util.HashMap;

public class q21to23 {
	public static void main(String[] args) {
		linkList(3,1,2);
		arrList(6,4,5);
		treSet(9,7,8);
		hasSet(12,10,11);
		hashMap(14,13,15);
	}
	
	static void linkList(int...nums) {
		System.out.println("LinkedList");
		LinkedList<Integer> object = new LinkedList<Integer>();
		for(int i:nums) {
			object.add(i);
		}
		for(int z=0; z<object.size();z++) {
			System.out.println(object.get(z));
		}
		Collections.sort(object);
		System.out.println("Sorted");
		for(int z=0; z<object.size();z++) {
			System.out.println(object.get(z));
		}
	}
	
	static void arrList(int...nums) {
		System.out.println("ArrayList");
		ArrayList<Integer> object = new ArrayList<Integer>();
		for(int i:nums) {
			object.add(i);
		}
		for(int z=0; z<object.size();z++) {
			System.out.println(object.get(z));
		}
		object.sort(null);
		System.out.println("Sorted");
		for(int z=0; z<object.size();z++) {
			System.out.println(object.get(z));
		}
	}
	
	static void treSet(int...nums) {
		System.out.println("TreeSet");
		TreeSet<Integer> object = new TreeSet<Integer>();
		for(int i:nums) {
			object.add(i);
		}
		for(int z=0; z<object.size();z++) {
			System.out.println(object.toArray()[z]);
		}
		object.descendingSet();
		System.out.println("Sorted");
		for(int z=0; z<object.size();z++) {
			System.out.println(object.toArray()[z]);
		} 
		System.out.println("TreeSets are autoSorted so nothing changes");
	}
	
	static void hasSet(int...nums) {
		System.out.println("HashSet");
		HashSet<Integer> object = new HashSet<Integer>();
		for(int i:nums) {
				object.add(i);
			}
		for(int z=0; z<object.size();z++) {
				System.out.println(object.toArray()[z]);
			}
		ArrayList<Integer> sObj = new ArrayList<Integer>(object);
		Collections.sort(sObj);
		HashSet<Integer> sortHash = new HashSet<Integer>();
		System.out.println("Sorted");
		for(int i:sObj) {
			sortHash.add(i);
		}
		for(int z=0; z<object.size();z++) {
			System.out.println(sortHash.toArray()[z]);
		}
	}
	
	static void hashMap(int...nums) {
		System.out.println("HashMap");
		HashMap<Integer,Integer> object = new HashMap<Integer,Integer>();
		int count=0;
		for(int i:nums) {
				object.put(count, i);
				count++;
			}
		for(int z=0; z<object.size();z++) {
				System.out.println(object.get(z));
			}
		ArrayList<Integer> sObj = new ArrayList<Integer>(object.keySet());
		Collections.sort(sObj);
		HashMap<Integer,Integer> sortHash = new HashMap<Integer,Integer>();
		System.out.println("Sorted");
		count=0;
		for(int i:sObj) {
			sortHash.put(count, i);
			count++;
		}
		for(int z=0; z<object.size();z++) {
			System.out.println(sortHash.get(z));
		}
	}
}
