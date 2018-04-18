package com.revature.service;

import com.revature.dao.PokemonDao;
import com.revature.dao.PokemonDaoImpl;
import com.revature.model.Pokemon;

/**
 * Created by bryanvillegas on 4/13/18.
 */
public class PokemonService {
    private static PokemonDao dao = new PokemonDaoImpl();
    public static boolean insertPokemon(Pokemon pokemon){
        return dao.insertPokemon(pokemon);
    }
}
