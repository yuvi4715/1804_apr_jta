package com.kobio.service;

import java.util.List;

import com.kobio.dao.AccountDAO;
import com.kobio.dao.AccountDAOInterface;
import com.kobio.model.Account;

public class AccountService   {

	private static AccountDAOInterface accdao = AccountDAO.getInstance();

	public static Boolean updateAccount(Account a, char c) {
		// TODO Auto-generated method stub
		return accdao.updateAccount(a, c);
		
	}

	public static List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		return accdao.getAllAccount();
	}
}
