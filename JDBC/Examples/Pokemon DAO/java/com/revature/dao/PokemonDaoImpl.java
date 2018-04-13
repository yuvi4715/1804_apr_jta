package com.revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Pokemon;
import com.revature.util.ConnectionUtil;

public class PokemonDaoImpl implements PokemonDao {

	@Override
	public boolean insertPokemon(Pokemon pokemon) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_pokemon(?, ?, ?, ?, ?)}");
			stmt.setInt(++index, pokemon.getPokedexEntry());
			stmt.setString(++index, pokemon.getName());
			stmt.setString(++index, pokemon.getPrimaryType());
			stmt.setString(++index, pokemon.getSecondaryType());
			stmt.setInt(++index, pokemon.getGeneration());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Pokemon getPokemon(int pokedexEntry) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pokemon WHERE pokedexEntry = ?");
			stmt.setInt(++index, pokedexEntry);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Pokemon(rs.getInt("id"), rs.getString("name"), rs.getString("type1"), rs.getString("type2"), rs.getInt("generation"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Pokemon> getAllPokemon() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Pokemon> pokemon = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pokemon");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				pokemon.add(new Pokemon(rs.getInt("id"), rs.getString("name"), rs.getString("type1"), rs.getString("type2"), rs.getInt("generation")));
			}
			return pokemon;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean updatePokemon(Pokemon pokemon) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL update_pokemon(?, ?, ?, ?, ?)}");
			stmt.setInt(++index, pokemon.getPokedexEntry());
			stmt.setString(++index, pokemon.getName());
			stmt.setString(++index, pokemon.getPrimaryType());
			stmt.setString(++index, pokemon.getSecondaryType());
			stmt.setInt(++index, pokemon.getGeneration());
			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public boolean deletePokemon(int pokedexEntry) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL delete_pokemon(?)}");
			stmt.setInt(++index, pokedexEntry);
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

}
