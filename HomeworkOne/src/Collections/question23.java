// Sort the collections and compare the original to the sorted collection.


package Collections;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;



public class question23 {//implements Comparable<question23> {

	private String type;
	private int id;
	private String name;
	
	public question23() {
		
	}

	public question23(String type, int id, String name) {
		super();
		this.type = type;
		this.id = id;
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "question23 [type=" + type + ", id=" + id + ", name=" + name + "]";
	}

//	@Override
//	public int compareTo(question23 o) {
	
	
	
//		/* For ascending order, use 'this' first */
//		return this.getId() - o.getId();

		/* For descending order, use the parameter name first */
//		return o.getId() - this.getId();
	
	
		/* REMEBER STRINGS HAVE THEIR OWN IMPLEMENTATION OF compareTo() */
		/* For ascending, use 'this' first */
//		return this.getName().compareTo(o.getName());
	
		/* For descending order, use the parameter name first */
//		return o.getName().compareTo(this.getName());
	
//	}
	
	public static void main(String[] args) {
		List<question23> myquestion23 = new ArrayList<>();
		myquestion23.add(new question23("Fire", 5, "Charmander"));
		myquestion23.add(new question23("Electric", 13, "Electabuzz"));
		myquestion23.add(new question23("Electric", 1000, "1Pikachu"));
		myquestion23.add(new question23("Electric", 1000, "!Pikachu"));
		myquestion23.add(new question23("Electric", 1000, "Pikachu"));
		myquestion23.add(new question23("Grass", 1, "Bulbasaur"));
		myquestion23.add(new question23("Psychic", 35, "Kadabra"));
		myquestion23.add(new question23("Fighting", 34, "Mankey"));
		myquestion23.add(new question23("Fighting", 36, "mankey"));
		
		//This ArrayList was sorted by using the question23Helper, which implements Comparator<question23>, therefore "IS-A" Comparator
		Collections.sort(myquestion23, new question23Helper());
		System.out.println("Sorting by ID");
		Collections.sort(myquestion23, (p1, p2) -> { return p1.getId() - p2.getId();});
		
		//Enhanced for-loop
		//On the right side of the colon, must be an Iterable<T>
		//On the left side of the colon, must be a Type T of that Iterable<T>
		
//		for (question23 p : myquestion23) {
//			System.out.println(p);
//		}
		
//		System.out.println("Sorting by Type");
		
		/* This example was sorted by using a lambda expression using the Comparator interface */
		Collections.sort(myquestion23, (p1, p2) -> { return p1.getType().compareTo(p2.getType());});
		
//		for (question23 p : myquestion23) {
//			System.out.println(p);
//		}
		
		
		Map<String, question23> trainers = new TreeMap<>(new TrainerHelper());
		trainers.put("William", new question23("Fire", 14, "Charizard"));
		trainers.put("Ash", new question23("Electric", 1, "Pikachu"));
		trainers.put("Brock", new question23("Rock", 35, "Onyx"));
		trainers.put("Misty", new question23("Water", 14, "Staryu"));
		trainers.put("Yuvi", new question23("Psychic", 14, "Alakaza"));
		
		
		/* Example of how to iterate through a Map, getting each Key/Value pair */
		Iterator it = trainers.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			System.out.println(pair.getKey() + " => " + pair.getValue());
		}
		
		
		/* Or, this lambda expression is equivalent */
		
		trainers.forEach((k, v) -> System.out.println(k + " => " + v));
		
	}
}

class question23Helper implements Comparator<question23> {
	@Override
	public int compare(question23 p1, question23 p2) {
//		return p1.getType().compareTo(p2.getType());
//		return p1.getId() - p2.getId();
		int result = p1.getType().compareTo(p2.getType());
		if (result != 0) {
			return result;
		}
		return p1.getName().compareTo(p2.getName());
	}
}


class TrainerHelper implements Comparator<String> {
	@Override
	public int compare(String s1, String s2) {
		return s2.compareTo(s1);
	}
}