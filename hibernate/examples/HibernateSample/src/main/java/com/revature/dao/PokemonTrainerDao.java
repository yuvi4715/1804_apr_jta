package com.revature.dao;

import com.revature.model.PokemonTrainer;

public interface PokemonTrainerDao {
	public void insert(PokemonTrainer pokemonTrainer);
	public PokemonTrainer selectByName(PokemonTrainer pokemonTrainer);
	public void update(PokemonTrainer pokemonTrainer);
}
