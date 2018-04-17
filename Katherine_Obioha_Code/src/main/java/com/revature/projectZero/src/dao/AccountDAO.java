package com.kobio.dao;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.kobio.connection.ConnectionProperties;
import com.kobio.controller.Controller;
import com.kobio.model.Account;
import com.kobio.model.Person;
import com.kobio.model.Transaction;



public class AccountDAO implements AccountDAOInterface{

	final static Logger logger =Logger.getLogger(AccountDAO.class);
private static AccountDAO instance;
	
	public AccountDAO()
	{
		
	}
	
	public static AccountDAO getInstance()
	{
		if(instance == null)
		{
			instance = new AccountDAO();
		}
		return instance;
	}
	
	
	@Override
	public boolean CreateAccount(Account account) throws SQLException {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionProperties.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Account"
					+ "(balance, approve, personid, creditscore) VALUES (?,?,?,?)");
		
			stmt.setInt(1, account.getBalance());
			
			stmt.setString(2, String.valueOf(account.getapprove()));
			stmt.setInt(3, Controller.p.getID());
			stmt.setInt(4, account.getCreditscore());
			
			if(!stmt.execute())
			{  
				//executeupdate returns
				return stmt.getUpdateCount()>0;  
			}
		}
		
		return false;
	}

	public boolean updateloanbalance(Transaction transaction)
	{
		try (Connection conn = ConnectionProperties.getConnection()) {

			PreparedStatement stmt = conn.prepareStatement("UPDATE Account SET balance = ? WHERE accountid = ?");

			stmt.setInt(1, transaction.getAccount().getBalance()+transaction.getLoanrequested());

			stmt.setInt(2, transaction.getAccount().getID());

			if (!stmt.execute()) {

				return stmt.getUpdateCount() > 0;

			}

		} catch (SQLException sqle) {

			System.err.println(sqle.getMessage());

			System.err.println("SQL State: " + sqle.getSQLState());

			System.err.println("Error Code: " + sqle.getErrorCode());

		}
		return false;
	}
	@Override
	public Account getAccount(int personId) throws SQLException {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionProperties.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("SELECT balance, approve, accountid, accountnumber, creditscore FROM account where personid = ?");
			
			stmt.setInt(1, personId);
			
			ResultSet rs = stmt.executeQuery();
			
			if(rs.next())
			{	
				Controller.a.setBalance(rs.getInt("balance"));
				Controller.a.setApprove(rs.getString("approve").charAt(0));
				
				Controller.a.setID(rs.getInt("accountid"));
				
				Controller.a.setAccountnumber(rs.getInt("accountnumber"));
				Controller.a.setCreditscore(rs.getInt("creditscore"));
			}
		}
		
		return Controller.a;
	}

	@Override
	public  List<Account> getAllAccount() {
		// TODO Auto-generated method stub
		try(Connection conn= ConnectionProperties.getConnection())
		{
			List<Account>acc = new ArrayList<Account>();
			PreparedStatement stmt = conn.prepareStatement("SELECT balance, approve, personid, accountid, accountnumber, creditscore FROM account");
			ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						Account t = new Account();
						t.setBalance(rs.getInt("balance"));
						t.setApprove(rs.getString("approve").charAt(0));
						t.setPerson(new Person());
						t.getPerson().setID(rs.getInt("personid"));
						t.setID(rs.getInt("accountid"));
						t.setAccountnumber(rs.getInt("accountnumber"));
						t.setCreditscore(rs.getInt("creditscore"));
						acc.add(t);
						//System.out.println(acc.toString());
					}
			//System.out.println(acc.toString());
			return acc;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean updateAccount(Account account, char t)  {
		// TODO Auto-generated method stub
		
		try(Connection conn = ConnectionProperties.getConnection()){
			
			if(t==' ')
			{
				PreparedStatement stmt = conn.prepareStatement("Update account SET balance = ? WHERE personid=?");
				stmt.setInt(1, account.getBalance());
				stmt.setInt(2, account.getPerson().getID());
				
				if(!stmt.execute())
				{  
					
					return stmt.getUpdateCount()>0;  
				}
			}
			else
			{
				PreparedStatement stmt = conn.prepareStatement("Update account SET approve = ? WHERE personid = ?");
				stmt.setString(1, String.valueOf(t));
				stmt.setInt(2, account.getPerson().getID());
				if(!stmt.execute())
				{
					
					return stmt.getUpdateCount()>0;
				}
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			logger.error("SQLEXCEPTION");
			System.out.println(e.getMessage());
			System.out.println(e.getErrorCode());
			System.out.println(e.getSQLState());
		}
		return false;
	
	}
	
	@Override
	public boolean deleteAccount(Account account) {
		// TODO Auto-generated method stub
		return false;
	}
	

	
}
