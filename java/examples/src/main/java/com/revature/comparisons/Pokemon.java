package com.revature.comparisons;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Pokemon {//implements Comparable<Pokemon> {
	
	/*
	 * 
	 * Given that:
	 * 		List<Pokemon> myPokemon = new ArrayList<>();
	 * 
	 * NOTE: Sorting a list WILL not work, unless
	 * 		=> The Generic passed to the List does not have a defined means of sorting
	 * 			e.g. List<Pokemon> WILL NOT BE SORTABLE until you make Pokemon implement Comparable<T>, and override the compareTo() method
	 * 			Then, Collections.sort(myPokemon) will work
	 * 	
	 * 		=> You pass a Comparator<T>, or an instance of a class that implements Comparator<T> and overrides the compare() method,
	 * 			 to the overloaded Collections.sort() method
	 * 			e.g. At the bottom of this file, the PokemonHelper implements Comparator<Pokemon>
	 * 			Then, Collections.sort(myPokemon, new PokemonHelper()) will work
	 */
	
	private String type;
	private int id;
	private String name;
	
	public Pokemon() {
		
	}

	public Pokemon(String type, int id, String name) {
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
		return "Pokemon [type=" + type + ", id=" + id + ", name=" + name + "]";
	}

//	@Override
//	public int compareTo(Pokemon o) {
	
	
	
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
		List<Pokemon> myPokemon = new ArrayList<>();
		myPokemon.add(new Pokemon("Fire", 5, "Charmander"));
		myPokemon.add(new Pokemon("Electric", 13, "Electabuzz"));
		myPokemon.add(new Pokemon("Electric", 1000, "1Pikachu"));
		myPokemon.add(new Pokemon("Electric", 1000, "!Pikachu"));
		myPokemon.add(new Pokemon("Electric", 1000, "Pikachu"));
		myPokemon.add(new Pokemon("Grass", 1, "Bulbasaur"));
		myPokemon.add(new Pokemon("Psychic", 35, "Kadabra"));
		myPokemon.add(new Pokemon("Fighting", 34, "Mankey"));
		myPokemon.add(new Pokemon("Fighting", 36, "mankey"));
		
		//This ArrayList was sorted by using the PokemonHelper, which implements Comparator<Pokemon>, therefore "IS-A" Comparator
//		Collections.sort(myPokemon, new PokemonHelper());
//		System.out.println("Sorting by ID");
//		Collections.sort(myPokemon, (p1, p2) -> { return p1.getId() - p2.getId();});
		
		//Enhanced for-loop
		//On the right side of the colon, must be an Iterable<T>
		//On the left side of the colon, must be a Type T of that Iterable<T>
		
//		for (Pokemon p : myPokemon) {
//			System.out.println(p);
//		}
		
//		System.out.println("Sorting by Type");
		
		/* This example was sorted by using a lambda expression using the Comparator interface */
//		Collections.sort(myPokemon, (p1, p2) -> { return p1.getType().compareTo(p2.getType());});
		
//		for (Pokemon p : myPokemon) {
//			System.out.println(p);
//		}
		
		
		
		/*
		 * Similar to calling Collections.sort() on a Generic type that does not have a defined means of sorting,
		 * The Pokemon instances may not be inserted into either a TreeMap or a TreeSet unless you
		 * 
		 * 		=> Define a means of sorting, aka have Pokemon implement Comparable
		 * 
		 * 		=> Pass an instance of a Comparator into the constructor
		 * 
		 * 
		 * Why is this? Because both TreeMap and TreeSet order the insertion of objects into the collection based on a sorting method,
		 * whether it be implicit (Strings, primitives) or explicit (Having the class to be inserted to the TreeMap/TreeSet implement Comparable,
		 * or passing an instance of a Comparator to the constructor)
		 */
		
		
		
		
		
//		Set<String> myExampleTreeSet = new TreeSet<>();
//		myExampleTreeSet.add("hello");
//		myExampleTreeSet.add("1hello");
//		myExampleTreeSet.add("!hello");
//		myExampleTreeSet.add("world");
//		
//		for (String s : myExampleTreeSet) {
//			System.out.println(s);
//		}
		
		
		
//		Set<Pokemon> myPokemonSet = new TreeSet<>(new PokemonHelper());
//		myPokemonSet.add(new Pokemon("Fire", 4, "Charizard"));
//		myPokemonSet.add(new Pokemon("Dragon", 140, "Dragonite"));
//		myPokemonSet.add(new Pokemon("Ghost", 35, "Gengar"));
//		myPokemonSet.add(new Pokemon("Ghost", 35, "Gengar"));
//		myPokemonSet.add(new Pokemon("Physic", 47, "Alakazam"));
//		myPokemonSet.add(new Pokemon("Rock", 1500000, "Golem"));
//		myPokemonSet.add(new Pokemon("Poison", 13, "Nidoking"));
//		myPokemonSet.add(new Pokemon("Flying", 100, "Pidgeot"));
		
//		for (Pokemon p : myPokemonSet) {
//			System.out.println(p);
//		}
		
		Map<String, Pokemon> trainers = new TreeMap<>(new TrainerHelper());
		trainers.put("William", new Pokemon("Fire", 14, "Charizard"));
		trainers.put("Ash", new Pokemon("Electric", 1, "Pikachu"));
		trainers.put("Brock", new Pokemon("Rock", 35, "Onyx"));
		trainers.put("Misty", new Pokemon("Water", 14, "Staryu"));
		trainers.put("Yuvi", new Pokemon("Psychic", 14, "Alakaza"));
		
		
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

class PokemonHelper implements Comparator<Pokemon> {
	@Override
	public int compare(Pokemon p1, Pokemon p2) {
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