package myBankDao;

import java.util.List;

import myBankModel.Bank;

public interface BankDAO {
	
	
//		public boolean logOn(String username, String password);
//		public String isBankerApproved(Bank user);
		public boolean validateUser(String username);  // admin only
//		public boolean checkUsername(String username);
		
		
		public boolean insertBank_Account(Bank user);// create
		//public boolean isBankerAdmin(Bank user);
		public Bank getBankUser(String username); //read
		public List<Bank> getAllBankers();//read all
		public boolean updateBankUser(String username);//update
		public boolean deleteBanker(String username);// delete
		
		//public boolean updateSavings(Bank user, double amount);
		//public boolean Checking(Bank user, double amount);
		
		public boolean withdrawSavings(Bank user, double amount);
		public boolean withdrawChecking(Bank user, double amount);
		public boolean depositSavings(Bank user, double amount);
		public boolean depositChecking(Bank user, double amount);
		
	//public void adminInsertBanker();
//		public void userInsertBanker();
//		boolean insertBanker(Bank user);
		
		
	}


