package com.kobio.dao;

import java.sql.Connection;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import com.kobio.connection.ConnectionProperties;
import com.kobio.controller.Controller;
import com.kobio.model.Account;
import com.kobio.model.Person;
import com.kobio.model.Transaction;


public class TransactionDAO implements TransactionDAOInterface{

	final static Logger logger =Logger.getLogger(TransactionDAO.class);
private static TransactionDAO instance;
	
	public TransactionDAO()
	{
		
	}
	
	public static TransactionDAO getInstance()
	{
		if(instance == null)
		{
			instance = new TransactionDAO();
		}
		return instance;
	}
	
	
	@Override
	public boolean createloanTransaction(int amount, Account account) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionProperties.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("INSERT INTO Transaction"
					+ "(loanrequested, accountid) VALUES (?,?)");
			System.out.println("setting prepared statement in transaction values");
			
			stmt.setInt(1, amount);
			stmt.setInt(2, account.getID());
			
			System.out.println("Done setting account values. executing now");
			if(!stmt.execute())
			{  
				//executeupdate returns
				return stmt.getUpdateCount()>0;  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean approveloanTransaction( Transaction transaction, String answ) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionProperties.getConnection())
		{
			PreparedStatement stmt = conn.prepareStatement("UPDATE transaction SET loangranted = ?, loanduedate=? WHERE accountid = ?");
			System.out.println("setting prepared statement in transaction values");
			
			stmt.setString(1, String.valueOf((answ).charAt(0)));

				Calendar cal = Calendar.getInstance();
				cal.setTime(transaction.getDatetime());
				cal.add(Calendar.YEAR, 2); // add 10 days
				transaction.setLoanduedate(cal.getTime()); 
				java.sql.Date sqlStartDate = new java.sql.Date(transaction.getLoanduedate().getTime());
				
			stmt.setDate(2,sqlStartDate);
			stmt.setInt(3, transaction.getAccount().getID());
			
			if(answ.equalsIgnoreCase("yes"))
			{
				AccountDAO.getInstance().updateloanbalance(transaction);
			}
			System.out.println("Done setting account values. executing now");
			if(!stmt.execute())
			{  
				//executeupdate returns
				return stmt.getUpdateCount()>0;  
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	@Override
	public List<Transaction> getallTransactions() {
		// TODO Auto-generated method stub
		try(Connection conn= ConnectionProperties.getConnection())
		{
			List<Transaction>transactions = new ArrayList<Transaction>();
			PreparedStatement stmt = conn.prepareStatement("SELECT accountid, datetime, loanrequested, loanduedate FROM transaction");
			ResultSet rs = stmt.executeQuery();
					while(rs.next()){
						Transaction t = new Transaction();
						t.setAccount(new Account());
						t.getAccount().setID(rs.getInt("accountid"));
						t.setDatetime(rs.getDate("datetime"));
						t.setLoanrequested(rs.getInt("loanrequested"));
					//	t.setLoangranted(rs.getString("loangranted").charAt(3));
						t.setLoanduedate(rs.getDate("loanduedate"));
						transactions.add(t);
						//System.out.println(acc.toString());
					}
			//System.out.println(acc.toString());
			return transactions;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Transaction getTransaction(Account account) {
		// TODO Auto-generated method stub
		try(Connection conn= ConnectionProperties.getConnection())
		{
			Transaction t = new Transaction();
			PreparedStatement stmt = conn.prepareStatement("SELECT  loangranted, loanrequested, loanduedate FROM transaction WHERE accountid = ?");
			stmt.setInt(1, account.getID());
			ResultSet rs = stmt.executeQuery();
					if(rs.next()){
						if(rs.getString("loangranted").charAt(0) == ' ')
						{
						//t.setLoangranted(rs.getString("loangranted").charAt(3));
						}
						else
						{
							t.setLoangranted(rs.getString("loangranted").charAt(0));
						}
						t.setLoanrequested(rs.getInt("loanrequested"));
						t.setLoanduedate(rs.getDate("loanduedate"));
				
					}
	
			return t;
		}
		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(NullPointerException t)
		{
			logger.error("NullPointer");
		}
		finally
		{
			
		}
		return null;
	}

}
