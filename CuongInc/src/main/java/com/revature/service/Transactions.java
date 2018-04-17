package com.revature.service;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.revature.application.Driver;
import com.revature.model.BankCustomer;

//class for transaction methods
public class Transactions {
	final static Logger log = Logger.getLogger(Driver.class);
	// Method to deposit money
	public static void Deposit(BankCustomer accountToDeposit) {
		BankCustomer userDeposit = BankCustomerService.getBankCustomer(accountToDeposit.getUsername());
		Scanner user = new Scanner(System.in);
		String accountType = userDeposit.getAccountType();
		String firstName = userDeposit.getFirstName();
		String lastName = userDeposit.getLastName();
		String userName = userDeposit.getUsername();
		String password = userDeposit.getPassword();
		int accesslevel = userDeposit.getAccesslevel();
		float currentBalance = userDeposit.getBalance();
		System.out.println();
		System.out.println("How much would you like to deposit?: ");
		float deposit = user.nextFloat();
		float newBalance = currentBalance + deposit;
		BankCustomer inputCustomer = new BankCustomer(accountType, firstName, lastName, userName, password, accesslevel,
				newBalance);
		BankCustomerService.updateBankCustomer(inputCustomer);
		System.out.println();
		System.out.println(accountToDeposit.getFirstName().toUpperCase() + ", you have successfully added $" + deposit
				+ " into your account.");
		System.out.println("You now have: $" + newBalance);
		System.out.println();
	}

	// Method to withdraw money
	public static void Withdraw(BankCustomer accountToWithdraw) {
		BankCustomer userDeposit = BankCustomerService.getBankCustomer(accountToWithdraw.getUsername());
		Scanner user = new Scanner(System.in);
		String accountType = userDeposit.getAccountType();
		String firstName = userDeposit.getFirstName();
		String lastName = userDeposit.getLastName();
		String userName = userDeposit.getUsername();
		String password = userDeposit.getPassword();
		int accesslevel = userDeposit.getAccesslevel();
		float currentBalance = userDeposit.getBalance();
		System.out.println();
		System.out.println("How much would you like to withdraw?: ");
		float withdraw = user.nextFloat();
		float newBalance = currentBalance - withdraw;
		BankCustomer inputCustomer = new BankCustomer(accountType, firstName, lastName, userName, password, accesslevel,
				newBalance);
		BankCustomerService.updateBankCustomer(inputCustomer);
		System.out.println();
		System.out.println(accountToWithdraw.getFirstName().toUpperCase() + ", you have successfully withdrawn $"
				+ withdraw + " from your account.");
		System.out.println("You now have: $" + newBalance);
		System.out.println();
	}
}
