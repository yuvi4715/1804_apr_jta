package collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

import java.util.Iterator;

public class CollectionExamples 
{
	public static void main(String[] args)
	{
		ArrayList<Integer>  aL = new ArrayList<Integer>();
		LinkedList<Integer> lL = new LinkedList<Integer>();
		HashMap<Integer,String> hM = new HashMap<Integer,String>();
		TreeSet<Integer> tS = new TreeSet<Integer>();
		HashSet<Integer> hS = new HashSet<Integer>();
		
		aL.add(4);
		aL.add(23);
		aL.add(8);
		aL.add(42);
		aL.add(15);
		aL.add(16);
	
	
		lL.add(8);
		lL.add(15);
		lL.add(4);
		lL.add(16);
		lL.add(42);
		lL.add(23);
	
		

		hM.put(4,"Jack");
		hM.put(8,"Kate");
		hM.put(15,"Sawyer");
		hM.put(16,"Locke");
		hM.put(23,"Hurry");
		hM.put(42,"Smoke Monster");

		tS.add(23);
		tS.add(42);
		tS.add(4);
		tS.add(15);
		tS.add(8);
		tS.add(16);
		


		hS.add(4);
		hS.add(8);
		hS.add(15);
		hS.add(16);
		hS.add(23);
		hS.add(42);

		Iterator<Integer> iTAL = aL.iterator();
		System.out.println(" Array List ");
		while(iTAL.hasNext())
		{
			System.out.println(iTAL.next());
		}
		
		aL.sort(null);
		iTAL = aL.iterator();
		System.out.println(" Sorted Array List ");
		while(iTAL.hasNext())
		{
			System.out.println(iTAL.next());
		}
		
		
		Iterator<Integer> iTLL = lL.iterator();
		System.out.println(" Linked List ");
		while(iTLL.hasNext())
		{	
			System.out.println(iTLL.next());
		}
		
		lL.sort(null);
		iTLL = lL.iterator();
		System.out.println(" Sorted Linked List ");
		while(iTLL.hasNext())
		{	
			System.out.println(iTLL.next());
		}
			
		

		Set<Integer> theKeys= hM.keySet();
		Iterator<Integer> iTHM = theKeys.iterator();
		System.out.println(" Hash Map ");
		while(iTHM.hasNext())
		{
			int curr = iTHM.next();
			System.out.println(hM.get(curr));
			
		}
	
		/*
		 * Hash Map requires the use of another collection in order to be sorted
		 * */
		
		
		
		Iterator<Integer> iTTS = tS.iterator();
		System.out.println(" Tree Set ");
		while(iTTS.hasNext())
		{
			System.out.println(iTTS.next());
		}
		
		/*
		 * Tree set is sorted upon entry
		 * */
		
		

		Iterator<Integer> iTHS = hS.iterator();
		System.out.println(" Hash Set ");
		while(iTHS.hasNext())
		{
			System.out.println(iTHS.next());
		}
		/*
		 * Hash set requires the use of another collection in order to be sorted
		 * */
		
		
	}	
	
}
