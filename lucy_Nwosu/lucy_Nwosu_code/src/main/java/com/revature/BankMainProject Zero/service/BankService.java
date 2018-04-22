package com.revature.service;

import java.util.List;

import myBankDao.BankDAO;
import myBankDao.BankDaoImpl;
import myBankModel.Bank;

public class BankService {

	
	// this class is a singleton. primarily using Data Access Object to imteract with the database.
	

		private static BankDAO dao = BankDaoImpl.getInstance();

		public boolean insertBank_Account(Bank user)
			
		{
			return  dao.insertBank_Account(user);
		}

		public static Bank getBankUser(String entry1) {
			// TODO Auto-generated method stub
			
		return dao.getBankUser(entry1);
			
		}

//		public static boolean updateChecking(Bank bank, int amount) {
//			// TODO Auto-generated method stub
//			return dao.updateChecking(bank, amount);bank
//		}



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

public static boolean validateUser(String userSelection) {
	return dao.validateUser(userSelection);
	// TODO Auto-generated method stub
	
	
}

}