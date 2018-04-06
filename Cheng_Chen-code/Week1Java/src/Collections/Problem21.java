import java.util.*;

public class Problem21 
{
	public static void main(String[] args) 
	{
		ArrayList<Integer> a = new ArrayList<Integer>();
		LinkedList<Integer> b = new LinkedList<Integer>();
		HashMap<Integer, String> c = new HashMap<Integer, String>();
		TreeSet<Integer> d = new TreeSet<Integer>();
		HashSet<Integer> e = new HashSet<Integer>();
		
		for(int i = 0; i < 3; i++)
		{
			a.add(i);
			b.add(i);
			c.put(i, "test"+i);
			d.add(i);
			e.add(i);
		}
	}

}
