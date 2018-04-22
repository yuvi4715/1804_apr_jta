package com.revature.projrctzero;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Question21To23Collection {

//	Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3 objects into each.
//	Iterate over each collection and print each object.
//	Sort the collections and compare the original to the sorted collection.
	
//	ArrayList:
//	LinkedList:
//	HashMap:
//	TreeSet: 
//	HashSet:


	
	public static void main(String[] args) {
	System.out.println("Arraylist Example");
	// Arraylist
	ArrayList<Integer> arrlist= new ArrayList<Integer>();
	arrlist.add(1);
	arrlist.add(4);
	arrlist.add(2);
	//
	for(Integer i : arrlist){
	System.out.println("Iterate over list");
	System.out.println(i);
	}
	Collections.sort(arrlist);
	System.out.println("sort list");
	for(Integer i : arrlist){
	System.out.println("Iterate over sorted list");
	System.out.println(i);
	}
	System.out.println("linkedlist Example");
	System.out.println("**********");
	// linkedlist
	LinkedList<Integer> linkedlist= new LinkedList();
	linkedlist.add(1);
	linkedlist.add(4);
	linkedlist.add(2);
	//
	for(Integer i : linkedlist){
	System.out.println("Iterate over linkedlist");
	System.out.println(i);
	}
	Collections.sort(linkedlist);
	System.out.println("sort linkedlistlist");
	System.out.println("**********");
	for(Integer i : linkedlist){
	System.out.println("Iterate over sorted linkedlist");
	System.out.println(i);
	}
	System.out.println("HashMap Example");
	System.out.println("**********");
	// linkedlist
	Map<String, String> map = new HashMap<String, String>();
	map.put("J", "j");
	map.put("M", "m");
	map.put("F", "f");
	//
	for(Map.Entry<String, String> i : map.entrySet()){
	System.out.println("Iterate over map");
	System.out.println(i.getValue());
	}
	System.out.println("sort Map");
	Map<String,String> treeMap = new TreeMap<String, String>(map);
	System.out.println("**********");
	for(String i : treeMap.keySet()){
	System.out.println("Iterate over sorted map");
	System.out.println(map.get(i));
	}
	//
	System.out.println("HASH SET EXAMPLE");
	HashSet<String> hset = new HashSet<String>();
	//add elements to HashSet
	hset.add("ABC");
	hset.add("Ram");
	hset.add("Leo");
	hset.add("Sh");
	hset.add("Rck");
	// Duplicate removed
	hset.add("Rm");
	// Displaying HashSet elements
	System.out.println("HashSet contains: ");
	for(String temp : hset){
	System.out.println(temp);
	}
	// sorting hash set
	List<String> sortedHashSet = new ArrayList<String>(hset);
	// sort using Collections class
	Collections.sort(sortedHashSet);
	System.out.println("sorted HashSet contains: ");
	for(String temp : sortedHashSet){
	System.out.println(temp);
	}
	//
	// Tree set Example
	TreeSet<String> tset = new TreeSet<String>();
	//add elements to TreeSet
	tset.add("A");
	tset.add("R");
	tset.add("K");
	tset.add("S");
	tset.add("R");
	// Duplicate removed
	tset.add("R");
	  
	// Displaying TreeSet elements
	System.out.println("TreeSet contains: ");
	for(String temp : tset){
	System.out.println(temp);
	}
	}
	}

