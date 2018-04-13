package com.revature.dao;

import java.util.List;

import com.revature.model.Pokemon;

public interface PokemonDao {

	public boolean insertPokemon(Pokemon pokemon);	// Create
	public Pokemon getPokemon(int pokedexEntry);	// Read
	public List<Pokemon> getAllPokemon();
	public boolean updatePokemon(Pokemon pokemon);	// Update
	public boolean deletePokemon(int pokedexEntry);	// Delete
}
