package com.revature.factory;

public class PokemonFactory {

	// Since each of these classes (Bulbasaur, Charmander, Squirtle, and Pikachu) all implement the Pokemon interface, this works
	// Will return an instance of the object corresponding to the String you pass to the example
	public static Pokemon getPokemon(String pokemon) throws PokemonNotFoundException {
		switch(pokemon.toLowerCase()) {
		case "bulbasaur":
			return new Bulbasaur();
		case "charmander":
			return new Charmander();
		case "squirtle":
			return new Squirtle();
		case "pikachu": 
			return new Pikachu();
		default:
			throw new PokemonNotFoundException("Ash does not have a " + pokemon);
		}
	}
}
