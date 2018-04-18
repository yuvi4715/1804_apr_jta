package com.revature.dao;
import com.revature.model.Pokemon;

import java.util.List;

/**
 * Created by bryanvillegas on 4/13/18.
 */
public interface PokemonDao {

    public boolean insertPokemon(Pokemon pokemon);
    public Pokemon getPokemon(int pokedexEntry);
    public List<Pokemon> getAllPokemon();
    public boolean updatePokemon(Pokemon pokemon);
    public boolean deletePokemon(int pokedexEntry);

}
