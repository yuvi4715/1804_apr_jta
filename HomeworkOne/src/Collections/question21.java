//Create an ArrayList, LinkedList, HashMap, TreeSet, and a HashSet. Insert 3 objects into each.
package Collections;

import java.util.*;

public class question21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add("C");
	    al.add("A");
	    al.add("E");
		
	    LinkedList ll = new LinkedList();
		ll.add("C");
	    ll.add("A");
	    ll.add("E");
		
		HashMap hm = new HashMap();
		hm.put("C", hm);
	    hm.put("A", hm);
	    hm.put("E", hm);
		
	    TreeSet ts = new TreeSet();
		ts.add("C");
	    ts.add("A");
	    ts.add("E");

	    HashSet hs = new HashSet();
		hs.add("C");
	    hs.add("A");
	    hs.add("E");
		
	}

}
