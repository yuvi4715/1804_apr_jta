package com.revature.application;

import com.revature.model.Pokemon;
import com.revature.service.PokemonService;

public class Application {

	public static void main(String[] args) {
		System.out.println("Current total pokemon: " + PokemonService.getAllPokemon().size());
		Pokemon pokemon = new Pokemon(800, "Test", "Test", "Test", 1);
		System.out.println("Test Pokemon was inserted: " + PokemonService.insertPokemon(pokemon));
		System.out.println(PokemonService.getPokemon(pokemon.getPokedexEntry()));
		pokemon = new Pokemon(800, "Updated", "Updated", "Updated", 7);
		System.out.println("Test Pokemon was updated: " + PokemonService.updatePokemon(pokemon));
		System.out.println(PokemonService.getPokemon(pokemon.getPokedexEntry()));
		System.out.println("Test Pokemon was deleted: " + PokemonService.deletePokemon(pokemon.getPokedexEntry()));
		System.out.println("Current total pokemon: " + PokemonService.getAllPokemon().size());
	}
}
