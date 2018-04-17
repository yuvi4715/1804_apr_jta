package com.kobio.dao;

import java.util.List;


import com.kobio.model.Account;
import com.kobio.model.Transaction;

public interface TransactionDAOInterface {

	public boolean createloanTransaction(int amount, Account account);
	public boolean approveloanTransaction(Transaction transaction, String approve);
	public List<Transaction> getallTransactions();
	public Transaction getTransaction(Account account);
}
