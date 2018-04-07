package com.revature.compareExample;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Pokemon{
	private String type;
	private int id;
	private String name;
	
	public Pokemon(String type, int id, String name) {
		super();
		this.type = type;
		this.id = id;
		this.name = name;
	}
	
	//if not implementing Comparable, cannot use sort(1Element); must use sort(2 element);
	@Override
	public String toString() {
		return "Pokemon [type=" + type + ", id=" + id + ", name=" + name + "]";
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


/*	@Override
	public int compareTo(Pokemon o) {
		//instead of this.getId() - o.getId() 
		//for ascending order
		//return o.getId() - this.getId();
		//alphabetical order, special chars> numeric>upper alphabetics>lower case
		return this.getName().compareTo(o.getName());
		
	}*/
	
	public static void main(String[] args) {
		List<Pokemon> myPokemon = new ArrayList<>();
		myPokemon.add(new Pokemon("Fire", 5, "Charmander"));
		myPokemon.add(new Pokemon("Electric", 13, "Electabuzz"));
		myPokemon.add(new Pokemon("Grass", 1, "Bulbasaur"));
		myPokemon.add(new Pokemon("Psychic", 35, "Kadabra"));
		
		System.out.println(myPokemon.toString());
		Collections.sort(myPokemon, new PokemonHelper());
		System.out.println("sort by id");
		//lambda expression
		Collections.sort(myPokemon, (p1,p2) -> {return p1.getId() -p2.getId();});
		
		Collections.sort(myPokemon, (p1,p2) -> {return p1.getType().compareTo(p2.getType());});
		for(Pokemon p: myPokemon) {
			System.out.println(p.toString());
		}
		//Enhanced For-loop
		//right side, must be of type Iterable<T>
		//left side, type T of Iterable <T>
		for (Pokemon a: myPokemon) {
			System.out.println(a.toString());
		}
		//ex. Strings have natural ordering, hence no need to implement comparable
		/*Set<String> newSet = new TreeSet<>();
		newSet.add("hello");
		newSet.add("hello");
		newSet.add("hello");
		newSet.add("hello");
		for(String a: newSet) {
			System.out.println(a);
		}
		*/
		Set<Pokemon> myPokemonSet = new TreeSet<>((p1,p2) -> {return (p1.getId() -p2.getId());});
		myPokemonSet.add(new Pokemon("Fire", 4, "Charizar"));
		myPokemonSet.add(new Pokemon("Dragon", 140, "Dragonite"));
		myPokemonSet.add(new Pokemon("Ghost", 35, "Gengar"));
		myPokemonSet.add(new Pokemon("Ghost", 35, "Gengar"));
		myPokemonSet.add(new Pokemon("Psychic", 4, "Alakazam"));
		myPokemonSet.add(new Pokemon("Rock", 487583, "Golem"));
		myPokemonSet.add(new Pokemon("Fighting", 40, "Mankey"));
		myPokemonSet.add(new Pokemon("Fighting", 40, "mankey"));
		
		for(Pokemon a: myPokemonSet) {
			System.out.println(a.toString());
		}
		Map<String, Pokemon> trainers2 = new TreeMap<>(new TrainerHelper());
		//using trainerhelper
		Map<String, Pokemon> trainers = new TreeMap<>((s1,s2)-> {return s2.compareTo(s1);});
		trainers.put("Joey", new Pokemon("Fire", 3, "Charmander"));
		trainers.put("Ash", new Pokemon("Electric", 1, "Pikachu"));
		trainers.put("Brock", new Pokemon("Rock", 35, "Onyx"));
		trainers.put("Misty", new Pokemon("Water", 14, "Staryu"));
		trainers.put("John", new Pokemon("Psychic", 19, "Alakaza"));
		
		Iterator it = trainers.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry pair =(Map.Entry) it.next();
			System.out.println(pair.getKey()+ " => " + pair.getValue());
		}
		
		
	}
}
	
	class PokemonHelper implements Comparator<Pokemon>{

		@Override
		public int compare(Pokemon p1, Pokemon p2) {
			//return p1.getType().compareTo(p2.getType());
			//or return p1.getId() - p2.getId();
			int result = p1.getType().compareTo(p2.getType());
			if (result !=0) { return result;}
			//compared type, if type is same, compare the names
			return p1.getName().compareTo(p2.getName());
		}
		
	}
	
	class TrainerHelper implements Comparator<String>{

		@Override
		public int compare(String o1, String o2) {
			return o1.compareTo(o2);
		}
		
	}
	

