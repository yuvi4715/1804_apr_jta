package joey.bank.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import joey.bank.ConnectDB;
import joey.bank.Log;

public class BankAccountConnect implements BankAccountInterface{
	private static BankAccountConnect instance = null;

	private BankAccountConnect() {}
	
	public void createAccount(BankUser user)
	{
		try(Connection con = ConnectDB.getCon())
		{
			PreparedStatement stmt = con.prepareStatement("SELECT ID FROM JOEY_INMARS.BANKUSER WHERE USERNAME=? AND PASSWORD=?");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPsw());
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) System.out.println(rs.getInt(1));
			PreparedStatement stmt1 = con.prepareStatement("INSERT INTO JOEY_INMARS.BANK_ACCOUNT (USER_ID) VALUES(?)");
			stmt1.setInt(1, rs.getInt(1));
			stmt1.executeUpdate();
			Log.logInfo("Account created with default balance:0, default account type: checking, and User ID: "+rs.getInt(1));
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
		
	}

	@Override
	public int getAccountNumber(BankUser user) {
		try(Connection con = ConnectDB.getCon())
		{
			PreparedStatement stmt = con.prepareStatement("SELECT ID FROM JOEY_INMARS.BANKUSER WHERE USERNAME=? AND PASSWORD=?");
			stmt.setString(1, user.getUsername());
			stmt.setString(2, user.getPsw());
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) System.out.println(rs.getInt(1));
			PreparedStatement stmt1 = con.prepareStatement("SELECT ACCOUNT_NUMBER FROM JOEY_INMARS.BANK_ACCOUNT WHERE USER_ID=?");
			stmt1.setInt(1, rs.getInt(1));
			ResultSet rs2=stmt1.executeQuery();
			if(rs2.next()) Log.logInfo("ACCOUNT NUMBER FOUND: "+rs2.getInt(1));
			return rs2.getInt(1);
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
		
		return 0;
	}

	@Override
	public int getAccountNumber(int id) {
		try(Connection con = ConnectDB.getCon())
		{
			
			PreparedStatement stmt1 = con.prepareStatement("SELECT ACCOUNT_NUMBER FROM JOEY_INMARS.BANK_ACCOUNT WHERE USER_ID=?");
			stmt1.setInt(1, id);
			ResultSet rs2=stmt1.executeQuery();
			if(rs2.next()) Log.logInfo("ACCOUNT NUMBER FOUND: "+rs2.getInt(1));
			return rs2.getInt(1);
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
		
		return 0;
	}
	@Override
	public float deposit(int account, float amount) 
	{
		try(Connection con = ConnectDB.getCon())
		{
			CallableStatement cs=con.prepareCall("{call JOEY_INMARS.DEPOSIT(?,?)}");
			cs.setInt(1, account);
			cs.setFloat(2, amount);
			cs.execute();
	
			Log.logInfo("Balance updated");
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
		
		return 0;
	}

	@Override
	public float withdraw(int account, float amount) {
		try(Connection con = ConnectDB.getCon())
		{
			CallableStatement cs=con.prepareCall("{call JOEY_INMARS.WITHDRAW(?,?)}");
			cs.setInt(1, account);
			cs.setFloat(2, amount);
			cs.execute();
	
			Log.logInfo("Balance updated");
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
		
		return 0;
	}

	public static BankAccountInterface getInstance() {
		if (instance==null) instance=new BankAccountConnect();
		return instance;
	}


	@Override
	public float getBalance(int account) {
		try(Connection con = ConnectDB.getCon())
		{
			PreparedStatement stmt1 = con.prepareStatement("SELECT BALANCE FROM JOEY_INMARS.BANK_ACCOUNT WHERE ACCOUNT_NUMBER=?");
			stmt1.setInt(1, account);
			ResultSet rs2=stmt1.executeQuery();
			if(rs2.next()) Log.logInfo("ACCOUNT BALANCE: "+rs2.getInt(1));
			return rs2.getInt(1);
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
		
		return 0;
	}

}
