package com.revature.dao;

import com.revature.model.PokemonType;

public interface PokemonTypeDao {
	public void insert(PokemonType pokemonType);
	public PokemonType selectByName(PokemonType pokemonType);
}
