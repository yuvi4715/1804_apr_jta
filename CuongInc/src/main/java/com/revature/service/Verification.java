package com.revature.service;

import java.util.List;
import java.util.Scanner;

import com.revature.model.BankCustomer;

public class Verification {

	//Method to check for bank customer user name within the database
	public static BankCustomer getUsername() {
		List<BankCustomer> bankCustomers = BankCustomerService.getAllBankCustomer();
		for (BankCustomer checkAll : bankCustomers) {
			System.out.println(checkAll);
		}
		Scanner user = new Scanner(System.in);
		System.out.println("username: ");
		String testUsername = user.next();
		BankCustomerService.getBankCustomer(testUsername);
		System.out.println(BankCustomerService.getBankCustomer(testUsername));
		return BankCustomerService.getBankCustomer(testUsername);
	}
	
	public static boolean userAccess() {
		boolean access = false;
		Scanner user = new Scanner(System.in);
		String accountActivate = user.nextLine();
		BankCustomer accountVerify = BankCustomerService.getBankCustomer(accountActivate);
		accountVerify.setAccesslevel(1);
		BankCustomerService.updateBankCustomer(accountVerify);
		System.out.println("The account " + accountVerify.getUsername() + "has successfully been activated and is ready for use.");
		System.out.println();
		return access;
	}
}
