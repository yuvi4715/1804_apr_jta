package com.revature.dao;
import java.util.Random;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.model.Bank;
import com.revature.util.ConnectionUtil;

public class BankDaoImpl implements BankDao {

	@Override
	public boolean insertPokemon(Bank bank) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL insert_pokemon(?, ?, ?, ?, ?, ?)}");
			stmt.setInt(++index, (int)(Math.random() * 100 + 1));
			stmt.setInt(++index, bank.getMoney());
			stmt.setString(++index, bank.getName());
			stmt.setString(++index, bank.getPrimaryType());
			stmt.setString(++index, bank.getSecondaryType());
			stmt.setInt(++index, bank.getGeneration());

			
			return stmt.executeUpdate() > 0;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return false;
	}

	@Override
	public Bank getPokemon(String username) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pokemon WHERE username = ?");
			stmt.setString(++index, username);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new Bank(rs.getInt("id"), rs.getInt("money"), rs.getString("username"), rs.getString("password"), rs.getString("name"), rs.getInt("status"));
			}
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public List<Bank> getAllPokemon() {
		try (Connection conn = ConnectionUtil.getConnection()) {
			List<Bank> bank = new ArrayList<>();
			PreparedStatement stmt = conn.prepareStatement("SELECT * FROM pokemon");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				bank.add(new Bank(rs.getInt("id"), 0, rs.getString("name"), rs.getString("type1"), rs.getString("type2"), rs.getInt("generation")));
			}
			return bank;
		} catch (SQLException sqle) {
			System.err.println(sqle.getMessage());
			System.err.println("SQL State: " + sqle.getSQLState());
			System.err.println("Error Code: " + sqle.getErrorCode());
		}
		return null;
	}

	@Override
	public boolean updateBank(int id, int withdraw) {
		int index = 0;
		try (Connection conn = ConnectionUtil.getConnection()) {
			CallableStatement stmt = conn.prepareCall("{CALL update_bank(?, ?)}");
			stmt.setInt(++index,  Bank.getId());
			stmt.setInt(++index,  (Bank.getMoney()-withdraw));
			

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