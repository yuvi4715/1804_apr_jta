package com.revature.factory;

import java.util.ArrayList;
import java.util.List;

public class AshKetchum {

	public void callOnCurrentPokemon(String pokemonName) throws PokemonNotFoundException {
		PokemonFactory.getPokemon(pokemonName).fight();
	}
	
	// See the PokemonFactory in work
	// all you have to do to instantiate the pokemon is pass a String of the pokemon you want into the argument of 
	// PokemonFactory.getPokemon(String pokemonName)
	public static void main(String[] args) {
		AshKetchum ash = new AshKetchum();
		List<String> myPokemon = new ArrayList<>();
		myPokemon.add("charmander");
		myPokemon.add("pikaCHu");
		myPokemon.add("bulbasAUR");
		myPokemon.add("SQUIRTLE");
		myPokemon.add("mssigno");
		try {
			for (String s : myPokemon) {
				ash.callOnCurrentPokemon(s);
			}
		} catch (PokemonNotFoundException e) {
			System.err.println(e.getMessage());
		}
	}
}
