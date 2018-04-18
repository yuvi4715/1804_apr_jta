package com.revature.projectzero.db;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import com.revature.projectzero.accounts.Account;
import com.revature.projectzero.accounts.AccountTypes;
import com.revature.projectzero.accounts.Transaction;
import com.revature.projectzero.accounts.User;

public class MockDB implements DatabaseSingleton {

	@Override
	public List<Account> getUserAccounts(User u, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Transaction> getAccountTransactions(Account a, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUserByID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Account getAccountByID(long accounID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(User u, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(User u, String password) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Account a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void create(Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User u) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account a) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Transaction t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User getUserByUsernameAndPassword(String username, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isUniqueUsername(String username) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getUnActivatedAccounts(int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getAllUsers(int page) {
		// TODO Auto-generated method stub
		return null;
	}

}
