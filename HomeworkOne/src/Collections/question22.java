// Iterate over each collection and print each object.

package Collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class question22 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList al = new ArrayList();
		al.add("C");
	    al.add("A");
	    al.add("E");
	    for (int i = 0; i < al.size(); i++) {
		    System.out.println(al.get(i));	    	
	    }
		
	    LinkedList ll = new LinkedList();
		ll.add("C");
	    ll.add("A");
	    ll.add("E");
	    for (int i = 0; i < ll.size(); i++) {
		    System.out.println(ll.get(i));	    	
	    }

		
		HashMap hm = new HashMap();
		hm.put("C", hm);
	    hm.put("A", hm);
	    hm.put("E", hm);
	    for (int i = 0; i < hm.size(); i++) {
		    System.out.println(hm.get(i));	    	
	    }

		
	    TreeSet ts = new TreeSet();
		ts.add("C");
	    ts.add("A");
	    ts.add("E");
	    for (int i = 0; i < ts.size(); i++) {
		    System.out.println(((List) ts).get(i));	    	
	    }


	    HashSet hs = new HashSet();
		hs.add("C");
	    hs.add("A");
	    hs.add("E");
	    System.out.println(hs);

	}

}
