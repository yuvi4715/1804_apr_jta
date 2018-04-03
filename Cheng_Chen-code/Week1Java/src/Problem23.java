import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

public class Problem23 {

	public static void main(String[] args) 
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		HashMap<Integer, String> c = new HashMap<Integer, String>();
		TreeSet<Integer> d = new TreeSet<Integer>();
		HashSet<Integer> e = new HashSet<Integer>();
		
		for(int i = 3; i > 0; i--)
		{
			a.add(i);
			b.add(i);
			c.put(i, "test"+i);
			d.add(i);
			e.add(i);
		}
		
		System.out.println("Arraylist entries:");
		for(int i:a)
			System.out.println(i);
		
		System.out.println("\n LinkedList entries");
		for(int i:b)
			System.out.println(i);
		
		System.out.println("\n HashMap Entries.");
		Iterator it = c.entrySet().iterator();
		while(it.hasNext())
		{
			Map.Entry pair = (Map.Entry)it.next();
			System.out.println(pair.getKey() + " = " + pair.getValue());
			it.remove();
		}
		
		System.out.println("\nTreeSet Entries:");
		for(int i:a)
			System.out.println(i);
		
		System.out.println("\nHashSet Entries:");
		for(int i:a)
			System.out.println(i);
		Collections.sort(b);
		System.out.println("\nSorted Linked List Entries:");
		System.out.println(b.toString());
		
		ArrayList<Integer> keys = new ArrayList<Integer>();
		Collections.sort(keys);
		System.out.println("\nSorted Hash Map Entries:");
		for(int i:keys)
			System.out.println(i + " = " + c.get(i));
		
		TreeSet<Integer> Sorted_D = new TreeSet<Integer>(d);
		System.out.println("\nSorted TreeSet Entries:");
		System.out.println(Sorted_D.toString());
		
		List<Integer> Sorted_E = new ArrayList<Integer>(e);
		Collections.sort(Sorted_E);
		System.out.println("\nSorted HashSet Entries:");
		System.out.println(Sorted_E.toString());
	}
}
