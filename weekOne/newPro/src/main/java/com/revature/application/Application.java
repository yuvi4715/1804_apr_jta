package com.revature.application;

import com.revature.model.Pokemon;
import com.revature.service.PokemonService;

/**
 * Created by bryanvillegas on 4/13/18.
 */
public class Application {
    public static void main(String[] args){
        Pokemon pokemon = new Pokemon(25, "pikachu", "Electric", "Poison", 1);
        System.out.println("Pokemon was inserted " + PokemonService.insertPokemon(pokemon));
    }
}
