package com.revature.Dao;
// This is an interface listing all abstract methods to be defined in the implementation class
import java.util.List;

import com.revature.Model.Bank;

public interface BankDAO {
	public boolean logOn(String username, String password);
	
	
	public String isBankerApproved(Bank user);
	public boolean validateUser(String username);  // admin only
	public boolean checkUsername(String username);
	
	
	public boolean insertBanker(Bank user); 
	public boolean isBankerAdmin(Bank user);
	public Bank getBankUser(String username);
	public List<Bank> getAllBankers();
	public boolean updateBankUser(String username);
	public boolean deleteBanker(String username);
	
	public boolean withdrawSavings(Bank user, double amount);
	public boolean withdrawChecking(Bank user, double amount);
	public boolean depositSavings(Bank user, double amount);
	public boolean depositChecking(Bank user, double amount);
	
	public void adminInsertBanker();
	public void userInsertBanker();
	
	
}
