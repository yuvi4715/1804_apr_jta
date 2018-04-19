package com.revaure.service;

import java.util.List;

import com.revature.dao.BankDao;
import com.revature.dao.BankDaoImpl;
import com.revature.model.Bank;

public class BankService {

	private static BankDao dao = new BankDaoImpl();
	
	public static boolean insertPokemon(Bank bank) {
		return dao.insertPokemon(bank);
	}
	
	public static Bank getPokemon(String username) {
		return dao.getPokemon(username);
	}
	
	public static List<Bank> getAllPokemon() {
		return dao.getAllPokemon();
	}
	
//	public static boolean updateBank(Bank bank) {
//		return dao.updateBank(bank);
//	}
	
	public static boolean deletePokemon(int pokedexEntry) {
		return dao.deletePokemon(pokedexEntry);
	}

	public static boolean updateBank(int id, int withdrawAmount) {
		// TODO Auto-generated method stub
		return dao.updateBank(id, withdrawAmount);
	}
}