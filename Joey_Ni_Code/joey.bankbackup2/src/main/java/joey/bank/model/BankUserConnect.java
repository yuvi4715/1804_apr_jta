package joey.bank.model;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.sql.RowSetListener;
import javax.sql.rowset.FilteredRowSet;
import com.sun.rowset.FilteredRowSetImpl;
import joey.bank.ConnectDB;
import joey.bank.Log;
import joey.bank.IdFilter;

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

	RowSetListener listener=BankAdminConnect.getInstance();
	//deposit with admin approval
	@Override
	public boolean deposit(int account, float amount) 
	{
			//create filter for rows
			
			try {
				
				FileInputStream in = new FileInputStream("src/main/resources/admindb.properties");
				Properties props = new Properties();
				props.load(in);
				FilteredRowSet frs= new FilteredRowSetImpl();
				
				frs.setCommand("SELECT * FROM JOEY_INMARS.BANK_ACCOUNT");
				frs.setUsername(props.getProperty("username"));
				frs.setPassword(props.getProperty("password"));
				frs.setUrl(props.getProperty("url")); //set isolation to make sure changes 
				frs.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
				Connection con = DriverManager.getConnection(props.getProperty("url"), 
						 props.getProperty("username"), 
						 props.getProperty("password"));
				con.setAutoCommit(false);
				frs.execute();
				
				IdFilter depositStateFilter = new IdFilter(account, account, 2);
				frs.setFilter(depositStateFilter); //prints balance from id in column 1
				if (frs.next()) 
				{ 	System.out.println("row updated?"+frs.rowUpdated());
					System.out.println("balance before:"+frs.getFloat(4));	
					frs.updateFloat(4, frs.getFloat(4)+amount);
					frs.updateRow();
					System.out.println("row updated?"+frs.rowUpdated());
					System.out.println("balance after:"+frs.getFloat(4));	
			        // Synchronizing the row
			        // back to the DB
						 //Auto-commit is on or turn setAutoCommit(false) then, let admin do the commit after even listener
						frs.addRowSetListener(listener); //listener
						frs.acceptChanges(con);  //admin can add logic to the approval process before acceptChanges
							
					}

			} catch (SQLException e1) {
				Log.logError("DEPOSIT:" +e1.getMessage());
			} catch (IOException e) {
				e.printStackTrace();
				Log.logError(e.getMessage());
			}
		/*	Alternate solution:
		 * try(Connection con = ConnectDB.getCon())
			{
				CallableStatement cs=con.prepareCall("{call JOEY_INMARS.DEPOSIT(?,?)}");
			//	cs.setInt(1, account);
				cs.setFloat(2, amount);
				cs.execute();
		
				Log.logInfo("Balance updated");
			} catch (SQLException e) 
			{
				//e.printStackTrace();
				Log.logError(e.getMessage());
			}
			*/
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
	public boolean withdraw(int account, float amount) {
		//create filter for rows
		
		try {
			
			FileInputStream in = new FileInputStream("src/main/resources/admindb.properties");
			Properties props = new Properties();
			props.load(in);
			FilteredRowSet frs= new FilteredRowSetImpl();
			
			frs.setCommand("SELECT * FROM JOEY_INMARS.BANK_ACCOUNT");
			frs.setUsername(props.getProperty("username"));
			frs.setPassword(props.getProperty("password"));
			frs.setUrl(props.getProperty("url")); //set isolation to make sure changes 
			frs.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			Connection con = DriverManager.getConnection(props.getProperty("url"), 
					 props.getProperty("username"), 
					 props.getProperty("password"));
			con.setAutoCommit(false); //turn auto-commit off
			
			frs.execute();
			
			IdFilter depositStateFilter = new IdFilter(account, account, 2);
			frs.setFilter(depositStateFilter); //prints balance from account that matches account number in column 2
			
			
			if (frs.next()) 
			{ 
				if(frs.getFloat(4) >=0 && frs.getFloat(4) >=amount)
				{	System.out.println("row updated?"+frs.rowUpdated());
					System.out.println("balance before withdrawal:"+frs.getFloat(4));	
					frs.updateFloat(4, (frs.getFloat(4)-amount));
					frs.updateRow();
					System.out.println("row updated?"+frs.rowUpdated());
					System.out.println("new balance:"+frs.getFloat(4));	
		        // Synchronizing the row
		        // back to the DB
					 //Auto-commit is on or turn setAutoCommit(false) then, let admin do the commit after even listener
					frs.addRowSetListener(listener); //listener
					frs.acceptChanges(con); 
			
				}

					
			}
		} catch (SQLException e1) {
			Log.logError("Withdraw:" +e1.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			Log.logError(e.getMessage());
		}
		return false;
	}



}
