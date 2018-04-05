import java.util.*;

public class CollectionsExample {
	
	public static void main(String[] args) {
		setExample();
		mapExample();
		listExample();
		queueExample();
	}
	
	
	public static void listExample() {
			System.out.println("#======== List ========#\n");
			System.out.println("#======== ArrayList ========#");
			List<Character> myArrayList = new ArrayList<>();
			System.out.println("myArrayList.add('a') => " + myArrayList.add('a'));
			System.out.println("myArrayList.add('z') => " + myArrayList.add('z'));
			System.out.println("myArrayList.add('z') => " + myArrayList.add('z'));
			System.out.println("myArrayList.add('w') => " + myArrayList.add('w'));
			System.out.println("myArrayList.add('b') => " + myArrayList.add('b'));
			System.out.println("myArrayList.add('w') => " + myArrayList.add('w'));
			for (int i = 0; i < myArrayList.size(); i++) 
				System.out.println(myArrayList.get(i));
	}
	
	
	public static void queueExample() {
		System.out.println("#======== Queue ========#\n");
		System.out.println("#======== ArrayDeque (Queue) ========#");
		Queue<String> myQueue = new ArrayDeque<>();
		System.out.println("Recall: we use offer/poll/peek when using Queues (First In, First Out)");
		System.out.println("myQueue.offer(\"Pre-heat Oven\") => " + myQueue.offer("Pre-heat Oven"));
		System.out.println("myQueue.offer(\"Mix together cake batter\") => " + myQueue.offer("Mix together cake batter"));
		System.out.println("myQueue.offer(\"Place batter in cake pan, put in oven\") => " + myQueue.offer("Place batter in cake pan, put in oven"));
		System.out.println("myQueue.offer(\"Viola! Delicious Red Velvet Cake!\") => " + myQueue.offer("Voila! Delicious Red Velvet Cake!"));
		System.out.println("Current size of myQueue = " + myQueue.size());
		while (!myQueue.isEmpty()) {
			System.out.println("Calling myQueue.poll() => " + myQueue.poll() + "\n");
			System.out.println("Current size of myQueue = " + myQueue.size());
		}
			
		Deque<String> myStack = new ArrayDeque<>();
		System.out.println("\nRecall: We use push/poll/peek when using Stacks (Last In, First Out)");
		System.out.println("myStack.push(\"Inserted First\")"); myStack.push("Inserted First");
		System.out.println("myStack.push(\"Inserted Second\")");  myStack.push("Inserted Second");
		System.out.println("myStack.push(\"Inserted Third\")"); myStack.push("Inserted Third");
		System.out.println("myStack.push(\"Inserted Fourth\")"); myStack.push("Inserted Fourth");
		System.out.println("Current size of myStack = " + myStack.size());
		while (!myStack.isEmpty()) {
			System.out.println("Calling myStack.poll() => " + myStack.poll() + "\n");
			System.out.println("Current size of myStack = " + myStack.size());
		}
	}
		
	
	
	public static void mapExample() {
		System.out.println("#======== Maps =======# \n");
		System.out.println("#======== HashMap ========#");
		Map<String, String> myHashMap = new HashMap<String, String>();
		System.out.println("myHashMap.put(\"Atlanta\", \"Georgia\") => " + myHashMap.put("Atlanta", "Georgia"));
		System.out.println("myHashMap.put(\"Sacramento\", \"California\") => " + myHashMap.put("Sacramento", "California"));
		System.out.println("myHashMap.put(\"Columbus\", \"Ohio\") => " + myHashMap.put("Columbus", "Ohio"));
		System.out.println("myHashMap.put(\"Raleigh\", \"North Carolina\") => " + myHashMap.put("Raleigh", "North Carolina"));
		System.out.println("What's in my HashMap???");
		//myHashMap.forEach((k, v) -> System.out.println(k + " => " + v));
		Iterator it = myHashMap.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " => " + pair.getValue());
		}
		System.out.println("\n#======== TreeMap ========#");
		Map<Integer, Character> myTreeMap = new TreeMap<>();
		System.out.println("myTreeMap.put(3, 'd') => " + myTreeMap.put(3, 'd'));
		System.out.println("myTreeMap.put(26, 'z') => " + myTreeMap.put(26, 'd'));
		System.out.println("myTreeMap.put(1, 'a') => " + myTreeMap.put(1, 'a'));
		System.out.println("Oh man! 'd' isnt the third letter of the alphabet. What happens when we call myTreeMap.put(3, 'c')?");
		System.out.println("myTreeMap.put(3, 'c') => " + myTreeMap.put(3, 'c'));
		System.out.println("What's in myTreeMap???");
		Iterator it2 = myTreeMap.entrySet().iterator();
		while(it2.hasNext()) {
			Map.Entry pair = (Map.Entry) it2.next();
			System.out.println(pair.getKey() + " => " + pair.getValue());
		}
		System.out.println("\nSince TreeMap implements SortedMap, can we changed how this is sorted?");
		System.out.println("Map<Integer, Character> myNewTreeMap = new TreeMap<>((Integer a, Integer b) -> { return b - a; });");
		Map<Integer, Character> myNewTreeMap = new TreeMap<>((Integer a, Integer b) -> { return b - a; });
		System.out.println("myNewTreeMap.put(3, 'c') => " + myNewTreeMap.put(3, 'c'));
		System.out.println("myNewTreeMap.put(1, 'a') => " + myNewTreeMap.put(1, 'a'));
		System.out.println("myNewTreeMap.put(26, 'z') => " + myNewTreeMap.put(26, 'z'));
		Iterator it3 = myNewTreeMap.entrySet().iterator();
		System.out.println("What's in myNewTreeMap???");
		while (it3.hasNext()) {
			Map.Entry pair = (Map.Entry) it3.next();
			System.out.println(pair.getKey() + " => " + pair.getValue());
		}
	}
	
	
	
	
	public static void setExample() {
		System.out.println("#======== Sets ========# \n");
		System.out.println("#======== HashSet ========#");
		Set<String> myHashSet = new HashSet<>();
		System.out.println("myHashSet.add(\"Java\") => " + myHashSet.add("Java"));
		System.out.println("myHashSet.add(\"SQL\") => " + myHashSet.add("SQL"));
		System.out.println("myHashSet.add(\"JavaScript\") => " + myHashSet.add("JavaScript"));
		System.out.println("myHashSet.add(\"Java\") => " + myHashSet.add("Java"));
		System.out.println("myHashSet.add(\"TypeScript\") => " + myHashSet.add("TypeScript"));
		System.out.println("myHashSet.add(null) => " + myHashSet.add(null));
		System.out.println("myHashSet.add(null) => " + myHashSet.add(null));
		System.out.println("myHashSet.remove(\"JavaScript\") => " + myHashSet.remove("JavaScript"));
		System.out.println("What's in myHashSet??");
		Iterator myHashSetIterator = myHashSet.iterator();
		System.out.print("[");
		while (myHashSetIterator.hasNext()) {
			System.out.print(myHashSetIterator.next());
			if (myHashSetIterator.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");
		System.out.println("\n#========== TreeSet =========#");
		Set<String> myTreeSet = new TreeSet<>();
		System.out.println("myTreeSet.add(\"Beta\") => " + myTreeSet.add("Beta"));
		System.out.println("myTreeSet.add(\"Epsilon\") => " + myTreeSet.add("Epsilon"));
		System.out.println("myTreeSet.add(\"Theta\") => " + myTreeSet.add("Theta"));
		System.out.println("myTreeSet.add(\"Alpha\") => " + myTreeSet.add("Alpha"));
		System.out.println("myTreeSet.add(\"Epsilon\") => " + myTreeSet.add("Epsilon"));
		System.out.println("myTreeSet.add(\"Zeta\") => " + myTreeSet.add("Zeta"));
		System.out.println("What's in myTreeSet??");
		Iterator myTreeSetIterator = myTreeSet.iterator();
		System.out.print("[");
		while (myTreeSetIterator.hasNext()) {
			System.out.print(myTreeSetIterator.next());
			if (myTreeSetIterator.hasNext())
				System.out.print(", ");
		}
		System.out.println("]");
	}
	
	
}