package collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.TreeSet;

//Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3 objects into each.
//Iterate over each collection and print each object.
//Sort the collections and compare the original to the sorted collection.



public class CollectionsQuestions 
{

	public static void main(String[] args) 
	{
				ArrayList <Integer> arrayList = new ArrayList<Integer>();
				arrayList.add(1);
				arrayList.add(2);
				arrayList.add(3);
				
				
				
				LinkedList<Integer> linkedList = new LinkedList<Integer>();
				linkedList.add(4);
				linkedList.add(5);
				linkedList.add(6);


				
				HashMap<Integer,Integer> hashmap = new HashMap<Integer,Integer>();
				hashmap.put(100, 200);
				hashmap.put(300, 400);
				hashmap.put(500, 600);

				
				TreeSet<Integer> treeset = new TreeSet<Integer>();
				treeset.add(700);
				treeset.add(800);
				treeset.add(900);

			
				HashSet<Integer> hashset = new HashSet<Integer>();
				hashset.add(1000);
				hashset.add(2000);
				hashset.add(3000);

				
				printCollection(arrayList.iterator());
				printCollection(linkedList.iterator());
				printCollection(treeset.iterator());
				printCollection(hashset.iterator());
				printCollection(hashmap.keySet().iterator(), hashmap.values().iterator());
				
				
				TreeMap<Integer,Integer> treemap = new TreeMap<>();
				treemap.putAll(hashmap);
				
				Collections.sort(arrayList);
				Collections.sort(linkedList);
				
				TreeSet<Integer> treeSet = new TreeSet<>();
				treeSet.addAll(hashset);
				
				printCollection(arrayList.iterator());
				printCollection(linkedList.iterator());
				printCollection(treeset.iterator());
				printCollection(treemap.keySet().iterator(), treemap.values().iterator()); //treeMap, sorted HashMap
				printCollection(treeSet.iterator());
	}


		public static void printCollection(Iterator<Integer> iterator) 
		{
			while(iterator.hasNext()) 
			{
				System.out.println(iterator.next());
	        }
        }

		public static void printCollection(Iterator<Integer> iterator, Iterator<Integer> iterator2) 
		{
			while(iterator.hasNext() && iterator2.hasNext()) 
			{
				System.out.println(iterator.next() + " : " + iterator2.next());
			}
		}
}		
