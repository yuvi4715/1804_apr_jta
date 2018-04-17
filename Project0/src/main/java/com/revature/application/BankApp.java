package com.revature.application;

import java.util.List;

import com.revature.Model.Bank;
import com.revature.service.BankService;




public class BankApp {
	public static void main(String[] args) {
//		List<Bank> users = BankService.getAllBankers();
//		for (Bank b : users) {
//			System.out.println(b);
//		}
		Bank user = BankService.getBankUser("Nate");
		System.out.println(user);

//		System.out.println(user);
		System.out.println(user.getIsApproved()); // approval check works
		
		//System.out.println(BankService.updateBankUser("Willy")); // update works call it manually with params
		
		
		// insert works
		//Bank user = new Bank("Nathan", "Drake","Nate", "explorer", "user", "false", 0 ,0);
//		System.out.println(BankService.insertBanker(user));
		//System.out.println(BankService.getBankUser(user.getUserName()));
		
		//delete nathan
//		System.out.println(BankService.deleteBanker(user.getUserName()));
//		System.out.println(BankService.validateUser("Nate")); // validate user works
		 
		// all transactions regarding depositing and withdrawing work.
//		Bank mike = BankService.getBankUser("Harty777");
//		System.out.println(BankService.withdrawChecking(mike, 4000));
//		System.out.println(BankService.getBankUser(mike.getUserName()));
		
		//Log on works
		//System.out.println(BankService.logOn("Harty777", "777sage")); 

	}
	
}
