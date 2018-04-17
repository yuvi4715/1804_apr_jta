package com.revature.application;

import com.revature.service.AccountService;

public class BankApp
{
	public static void main(String args[])
	{
		//BankActions.menu();
		System.out.println(AccountService.getAccount(12346, "Savings"));
	}
}
  