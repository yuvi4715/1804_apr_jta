package com.revature.projectzero.db;

import java.util.List;

import com.revature.projectzero.accounts.Account;
import com.revature.projectzero.accounts.Transaction;
import com.revature.projectzero.accounts.User;

public interface DatabaseSingleton {
	/**
	 * 
	 * @param u
	 * @param page
	 * @return
	 */
	List<Account> getUserAccounts(User u,int page);
	/**
	 * 
	 * @param a
	 * @param page
	 * @return
	 */
	List<Transaction> getAccountTransactions(Account a,int page);
	/**
	 * 
	 * @param id
	 * @return
	 */
	User getUserByID(long id);

	/**
	 * 
	 * @param accounID
	 * @return
	 */
	Account getAccountByID(long accounID);

	/**
	 * 
	 * @param u
	 */
	void update(User u);
	/**
	 * 
	 * @param u
	 */
	void update(User u,String password);

	/**
	 * 
	 * @param a
	 */
	void update(Account a);
	/**
	 * 
	 * @param a
	 */
	void update(Transaction t);

	/**
	 * 
	 * @param u
	 * @param password
	 */
	void create(User u,String password);

	/**
	 * 
	 * @param a
	 */
	void create(Account a);
	/**
	 * 
	 * @param a
	 */
	void create(Transaction t);

	/**
	 * 
	 * @param u
	 */
	void delete(User u);

	/**
	 * 
	 * @param a
	 */
	void delete(Account a);
	/**
	 * 
	 * @param a
	 */
	void delete(Transaction t);

	/**
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	User getUserByUsernameAndPassword(String username, String password);
	
	/**
	 * 
	 * @param username
	 * @return
	 */
	boolean isUniqueUsername(String username);

	/**
	 * 
	 * @param page
	 * @return
	 */
	List<User> getUnActivatedAccounts(int page);
	/**
	 * 
	 * @param page
	 * @return
	 */
	List<User> getAllUsers(int page);
}