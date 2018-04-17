package com.kobio.service;

import java.util.List;

import com.kobio.dao.TransactionDAO;
import com.kobio.dao.TransactionDAOInterface;
import com.kobio.model.Account;
import com.kobio.model.Transaction;

public class TransactionService {

	
	private static TransactionDAOInterface tdao = TransactionDAO.getInstance();
	
	public TransactionService()
	{
		
	}

	public static Transaction getTransaction(Account a) {
		// TODO Auto-generated method stub
		return tdao.getTransaction(a);
	}

	public static void createloanTransaction(int n, Account a) {
		// TODO Auto-generated method stub
		tdao.createloanTransaction(n, a);
	}

	public static List<Transaction> getallTransactions() {
		// TODO Auto-generated method stub
		return tdao.getallTransactions();
	}

	public static void approveloanTransaction(Transaction transaction, String approve) {
		// TODO Auto-generated method stub
		tdao.approveloanTransaction(transaction, approve);
	}
}
