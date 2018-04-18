package com.revature.dao;

import com.revature.Util.ConnectionUtil;
import com.revature.model.Pokemon;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by bryanvillegas on 4/13/18.
 */
public class PokemonDaoImpl implements PokemonDao {

    public boolean insertPokemon(Pokemon pokemon) {
        int index = 0;
        try (Connection conn = ConnectionUtil.getConnection()){

            CallableStatement stmt = conn.prepareCall( "{CALL insert_pokemon(?, ?, ?, ?, ?)}");
            stmt.setInt(++index, pokemon.getPokedexEntry());
            stmt.setString(++index, pokemon.getName());
            stmt.setString(++index, pokemon.getPrimaryType());
            stmt.setString(++index, pokemon.getSecondaryType());
            stmt.setInt(++index, pokemon.getGeneration());
            if(!stmt.execute())
                return stmt.executeUpdate() >0;

        } catch(SQLException sqle){

            System.err.println(sqle.getMessage());

        }
        return false;
    }

    public Pokemon getPokemon(int pokedexEntry) {
        return null;
    }

    public List<Pokemon> getAllPokemon() {
        return null;
    }

    public boolean updatePokemon(Pokemon pokemon) {
        return false;
    }

    public boolean deletePokemon(int pokedexEntry) {
        return false;
    }
}
