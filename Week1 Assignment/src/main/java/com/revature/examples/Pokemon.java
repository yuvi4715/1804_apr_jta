package com.revature.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Pokemon implements Comparable<Pokemon> 
{
	private String type;
	private int id;
	private String name;
	
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
	@Override
	public int compareTo(Pokemon o) {
		//Instead of o.getId() - this.getId(); descending
		//return this.getId() - o.getId();
		return this.getName().compareTo(o.getName());
	}
	
	public static void main(String[] args) {
		List<Pokemon> myPokemon = new ArrayList<>();
		myPokemon.add(new Pokemon("Fire", 5, "Charmander"));
		myPokemon.add(new Pokemon("Electric", 13, "Electabuzz"));
		myPokemon.add(new Pokemon("Electric", 1000, "Pikachu"));
		myPokemon.add(new Pokemon("Grass", 1, "Bublbasaur"));
		myPokemon.add(new Pokemon("Psychic", 35, "Kadabra"));
		myPokemon.add(new Pokemon("Fighting", 34, "Maneky"));
		//This ArrayList was sorted by calling this method.
		Collections.sort(myPokemon);
		
	System.out.println(myPokemon);
	//Enhanced for-loop
	//On the right side of the colon, must be an Iterable<T>
	//On the left side of the colon, must be a Type T of that Iterable<T>
	
	for (Pokemon p : myPokemon) {
		System.out.println(p);
	}
	
	}
}

class PokemonHelper implements Comparator<Pokemon> {

	@Override
	public int compare(Pokemon p1, Pokemon p2) {
		return p1.getType().compareTo(p2.getType());
	}
}

