package com.revature.service;
// this class is a singleton. primarily using Data Access Object to imteract with the database.
import java.util.List;

import com.revature.Dao.BankDAO;
import com.revature.Dao.BankDaoImpl;
import com.revature.Model.Bank;

public class BankService {
	private static BankDAO dao = BankDaoImpl.getInstance();
	
	public static List<Bank> getAllBankers() {
		return dao.getAllBankers();
	}
	
	public static Bank getBankUser(String username) {
		return dao.getBankUser(username);
	}
	
	public static boolean updateBankUser(String username) {
		return dao.updateBankUser(username);
	}
	
	public static String isBankerApproved(Bank user) {
		return dao.isBankerApproved(user);
	}
	
	public static boolean isBankerAdmin(Bank user) {
		return dao.isBankerAdmin(user);
	}
	
	public static boolean insertBanker(Bank user) {
		return dao.insertBanker(user);
	}
	
	public static boolean deleteBanker(String username) {
		return dao.deleteBanker(username);
	}
	
	public static boolean validateUser(String username) {
		return dao.validateUser(username);
	}
	
	public static boolean depositChecking(Bank user, double amount) {
		return dao.depositChecking(user, amount);
	}
	
	public static boolean depositSavings(Bank user, double amount) {
		return dao.depositSavings(user, amount);
	}
	
	public static boolean withdrawChecking(Bank user, double amount) {
		return dao.withdrawChecking(user, amount);
	}
	
	public static boolean withdrawSavings(Bank user, double amount) {
		return dao.withdrawSavings(user, amount);
	}
	
	public static boolean logOn(String username, String password) {
		return dao.logOn(username, password);
	}
	
	public static boolean checkUsername(String username) {
		return dao.checkUsername(username);
	}
	
	public static void adminInsertBanker(){// inserts user/admin via admin
		dao.adminInsertBanker();
	} 
	
	public static void userInsertBanker() {
		dao.userInsertBanker();
	}
	

}
