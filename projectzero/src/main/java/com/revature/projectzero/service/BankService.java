package com.revature.projectzero.service;
import java.util.List;

import com.revature.projectzero.accounts.Account;
import com.revature.projectzero.accounts.Transaction;
import com.revature.projectzero.accounts.User;
import com.revature.projectzero.db.BankDB;
import com.revature.projectzero.db.DatabaseSingleton;

public class BankService {
	private BankService() {}
	private static DatabaseSingleton db = BankDB.getInstance();
	
	public static DatabaseSingleton getDb() {
		return db;
	}

	public static void setDb(DatabaseSingleton db) {
		BankService.db = db;
	}

	public static List<Account> getUserAccounts(User u,int page){
		return db.getUserAccounts(u, page);
	}

	public static User getUserByID(long id) {
		return db.getUserByID(id);
	}

	
	public static Account getAccountByID(long accounID) {
		return db.getAccountByID(accounID);
	}

	public static void update(User u) {
		db.update(u);
	}

	public static void update(User u, String pass) {
		db.update(u, pass);
	}
	
	public static void update(Account a) {
		db.update(a);
	}

	public static void create(User u,String password){
		db.create(u,password);
	}

	public static void create(Account a){
		db.create(a);
	}

	public static void delete(User u){
		db.delete(u);
	}

	public static void delete(Account a) {
		db.delete(a);
	}

	public static User getUserByUsernameAndPassword(String username, String password) {
		return db.getUserByUsernameAndPassword(username, password);
	}
	
	public static boolean isUniqueUsername(String username){
		return db.isUniqueUsername(username);
	}

	public static List<User> getUnActivatedAccounts(int page){
		return db.getUnActivatedAccounts(page);
	}
	public static void delete(Transaction t) {
		db.delete(t);
	}
	
	public static void create(Transaction t) {
		db.create(t);
	}
	
	public static void update(Transaction t) {
		db.update(t);
	}
	public static List<Transaction> getAccountTransactions(Account a, int page) {
		return db.getAccountTransactions(a, page);
	}
	public static List<User> getAllUsers(int page){
		return db.getAllUsers(page);
	}
}
