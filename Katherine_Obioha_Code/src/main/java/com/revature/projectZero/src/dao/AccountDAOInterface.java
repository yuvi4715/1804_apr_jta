package com.kobio.dao;

import java.sql.SQLException;
import java.util.List;

import com.kobio.model.*;

public interface AccountDAOInterface {

	public boolean CreateAccount(Account account) throws SQLException;
	public Account getAccount(int personId) throws SQLException;
	public List<Account>getAllAccount();
	public boolean updateAccount(Account account, char t);
	public boolean updateloanbalance(Transaction transaction);
	public boolean deleteAccount(Account account);
}
