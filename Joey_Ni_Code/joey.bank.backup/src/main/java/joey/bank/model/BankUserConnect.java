package joey.bank.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import joey.bank.ConnectDB;
import joey.bank.Log;

/**
 * The implementation of the BankUserInterface. The db-accessing abstraction part of DAO model
 * @author joeyi
 *
 */
public class BankUserConnect implements BankUserInterface 
{
	private static BankUserConnect instance =null;
	
	
	//Public method to get instance of BankUserConnect, only one connection for app
	public static BankUserConnect getInstance()
	{
		if(instance == null) instance=new BankUserConnect();
		return instance;
	}

	@Override
	public BankUser getUser(String lastname, String firstname) 
	{
		try(Connection con = ConnectDB.getCon())
		{
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM JOEY_INMARS.BANKUSER WHERE lastname=? AND firstname=?");
			stmt.setString(1, lastname);
			stmt.setString(2,firstname);
			ResultSet rs=stmt.executeQuery();
			if (rs.next()) 
			{
				return new BankUser(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4));
			}
		} catch (SQLException e) {
			Log.logError(e.getMessage());
			e.printStackTrace();
		}
		
		return null;
	}


	//update balance method
	@Override
	public boolean deposit(float amount) 
	{
		
			try(Connection con = ConnectDB.getCon())
			{
				CallableStatement cs=con.prepareCall("{call JOEY_INMARS.DEPOSIT(?,?)}");
			//	cs.setInt(1, account);
				cs.setFloat(2, amount);
				cs.execute();
		
				Log.logInfo("Balance updated");
			} catch (SQLException e) 
			{
				e.printStackTrace();
				Log.logError(e.getMessage());
			}
			
		return false;
	}



	@Override
	public float getBalance(String username, String password) {
		try(Connection con=ConnectDB.getCon())
		{
			PreparedStatement stmt0 = con.prepareStatement("SELECT ID FROM JOEY_INMARS.BANKUSER WHERE username=? AND password=?");
			stmt0.setString(1, username);
			stmt0.setString(2, password);
			ResultSet rs=stmt0.executeQuery();
			Integer id=null;
			if(rs.next()) {id=rs.getInt(1);}
			PreparedStatement stmt = con.prepareStatement("SELECT balance FROM JOEY_INMARS.BANK_ACCOUNT WHERE user_id=?");
			stmt.setInt(1, id);
			//returns 1, number of row modified from the DML statement
			rs=stmt.executeQuery();
			if(rs.next()) 
			{ 
				System.out.println("Balance in account: "+rs.getInt(1));
				Log.logInfo("Got balance");
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			Log.logError(e.getMessage());

		}
		return 0;
	}

	@Override
	public boolean withdraw(float amount) {
		// TODO Auto-generated method stub
		return false;
	}



}
