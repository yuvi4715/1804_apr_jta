package com.revature.service;

import java.util.List;

import com.revature.dao.PokemonDao;
import com.revature.dao.PokemonDaoImpl;
import com.revature.model.Pokemon;

public class PokemonService {

	private static PokemonDao dao = new PokemonDaoImpl();
	
	public static boolean insertPokemon(Pokemon pokemon) {
		return dao.insertPokemon(pokemon);
	}
	
	public static Pokemon getPokemon(int pokedexEntry) {
		return dao.getPokemon(pokedexEntry);
	}
	
	public static List<Pokemon> getAllPokemon() {
		return dao.getAllPokemon();
	}
	
	public static boolean updatePokemon(Pokemon pokemon) {
		return dao.updatePokemon(pokemon);
	}
	
	public static boolean deletePokemon(int pokedexEntry) {
		return dao.deletePokemon(pokedexEntry);
	}
}
