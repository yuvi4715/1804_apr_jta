package Assignment1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.TreeSet;
import java.util.HashSet;
import java.util.Iterator;

public class Q21 
{
	public static void main(String args[])
	{
		ArrayList<Integer> intVector = new ArrayList<Integer>(3);
		intVector.add(1);
		intVector.add(2);
		intVector.add(3);
		
		LinkedList<Integer> list = new LinkedList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		
		HashMap<Integer, Integer> hMap = new HashMap<Integer, Integer>();
		hMap.put(0, 1);
		hMap.put(1, 2);
		hMap.put(2, 3);
		
		TreeSet<Integer> tSet = new TreeSet<Integer>();
		tSet.add(1);
		tSet.add(2);
		tSet.add(3);
		
		HashSet<Integer> hSet = new HashSet<Integer>();
		hSet.add(1);
		hSet.add(2);
		hSet.add(3);
		
		
		Iterator iterate1 = tSet.iterator();
		Object here1=0;
		Iterator iterate2 = hSet.iterator();
		Object here2=0;
		
		System.out.println("intVector:");
		for(int i=0; i<3; i++)
		{
			System.out.println(intVector.get(i));
		}
		System.out.println("list:");
		for(int i=0; i<3; i++)
		{
			System.out.println(list.get(i));
		}
		System.out.println("hMap:");
		for(int i=0; i<3; i++)
		{
			System.out.println(hMap.get(i));
		}
		System.out.println("tSet:");
		for(int i=0; i<3; i++)
		{
			here1=iterate1.next();
			System.out.println(here1);
		}
		System.out.println("hSet:");
		for(int i=0; i<3; i++)
		{
			here2=iterate2.next();
			System.out.println(here2);
		}
		
		
		Collections.sort(intVector);
		System.out.println("Sorted intVector:");
		System.out.println(intVector);
		Collections.sort(list);
		System.out.println("Sorted list:");
		System.out.println(list);
		TreeSet<Integer> sortedHMap = new TreeSet<Integer>(hMap.values());
		System.out.println("Sorted hMap:");
		System.out.println(sortedHMap);
		TreeSet<Integer> sortedTSet = new TreeSet<Integer>(tSet);
		System.out.println("Sorted tSet:");
		System.out.println(sortedTSet);
		TreeSet<Integer> sortedHSet = new TreeSet<Integer>(hSet);
		System.out.println("Sorted hSet:");
		System.out.println(sortedHSet);		
	}
}
