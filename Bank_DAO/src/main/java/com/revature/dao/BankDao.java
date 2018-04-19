package com.revature.dao;

import java.util.List;

import com.revature.model.Bank;

public interface BankDao {

	public boolean insertPokemon(Bank bank);	// Create
	public Bank getPokemon(String username);	// Read
	public List<Bank> getAllPokemon();
//	public boolean updatePokemon(Bank bank);	// Update
	public boolean deletePokemon(int pokedexEntry);	// Delete
	public boolean updateBank(int id, int withdrawAmount);
	//public boolean updateBank(Bank bank);
	
}