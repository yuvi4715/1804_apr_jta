package collections;
//problem 21 creating 4 listed collections
//problem 22 iterate and print out each collection members.
//problrm 23 sort the collections and print them out to compare them
import java.util.*;

public class SomeCollections {
	ArrayList<Integer> aList = new ArrayList<>();
	LinkedList<Integer> lList = new LinkedList<>();
	TreeSet<String> tSet = new TreeSet<>();
	HashMap<String,Integer> hMap = new HashMap<>();
	
	public SomeCollections() {
		addStuff();
		System.out.println("Before Sorting collections.");
		System.out.println();
		System.out.println("After Sorting Collections.");
		sortStuff();
		printStuff();
		sortHashMap();
	}
	
	void addStuff() { // adds 3 objects into each collection specified
		aList.add(1);
		aList.add(12);
		aList.add(3);
		
		lList.add(10);
		lList.add(2);
		lList.add(3);
		
		tSet.add("Tiger");
		tSet.add("Cat");
		tSet.add("Lion");
		
		hMap.put("One", 1);
		hMap.put("TwentySix", 26);
		hMap.put("Three", 3);
		 
		printStuff();
		System.out.println("HashMap contents" + hMap.toString());
		
	}
	
	void printStuff() {  // prints out contents of each list
		System.out.println("ArrayList contents: " + aList.toString());
		System.out.println("LinkedList contents: " + Arrays.toString(lList.toArray())); // need to use arrays function, will get memory address otherwise.
		System.out.println(("TreeSet contents" + tSet.toString()));
	}
	
	void sortStuff( ) { // 23 sort the collections and print out results
		Collections.sort(aList);
		Collections.sort(lList);
		tSet.descendingIterator(); // tree set seems to already put objects in order...
	}
	
	void sortHashMap() { //hashMaps do not have a sorting method or means implemented so I have to use a method to do so. 
		Map<String, Integer> map = new TreeMap<String, Integer>(hMap); 
        Set set2 = map.entrySet();
        Iterator iterator2 = set2.iterator();
        System.out.print("HashMap contents:{");
        int i = 0;
        while(iterator2.hasNext()) { // since the actual object cant be sorted, Consensus determined it was necessary to only print it out.
             Map.Entry me2 = (Map.Entry)iterator2.next();
             System.out.print(me2.getKey() + ": ");
             System.out.print(me2.getValue());
             if (i < 2) {
            	 System.out.print(" ,");
             }
             i++;
             
        }
        System.out.println("}");
         
	}
	
	public static void main(String[] args) {
		SomeCollections t = new SomeCollections();
		
	}
	
}
