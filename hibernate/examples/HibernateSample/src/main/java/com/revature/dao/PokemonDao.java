package com.revature.dao;

import java.util.List;

import com.revature.model.Pokemon;
import com.revature.model.PokemonType;

public interface PokemonDao {
	public void insert(Pokemon pokemon);
	public List<Pokemon> selectAll();
	public Pokemon selectByName(Pokemon pokemon);
	public List<Pokemon> selectByType(PokemonType pokemonType);
	public List<Pokemon> selectByNameCriteria(String criteria);
}
