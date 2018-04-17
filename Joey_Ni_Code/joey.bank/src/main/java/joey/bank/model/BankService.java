package joey.bank.model;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.sql.rowset.FilteredRowSet;

import com.sun.rowset.FilteredRowSetImpl;

import joey.bank.ConnectDB;
import joey.bank.IdFilter;
import joey.bank.Log;
import joey.bank.userFilter;
/**
 * BankService provides a filter to the BankUserInterface methods
 * @author joeyi
 *
 */
public class BankService {
	
	//Ensures BankService only accessible through static instance
	private BankService() {}
	
	//Instance of BankUserInterface
	private static BankUserInterface user = BankUserConnect.getInstance();
	private static BankAdminInterface admin= BankAdminConnect.getInstance();
	private static BankAccountInterface account = BankAccountConnect.getInstance();
	//open bank/connection
	public static void openBank()
	{
		ConnectDB.getInstance();
	}
	
	//close bank'connection
	public static void closeBank()
	{
		ConnectDB.close();
	}
	
	public static int selectMenu(String username, String password)
	{
		
		try {
			
			FileInputStream in = new FileInputStream("src/main/resources/db.properties");
			Properties props = new Properties();
			props.load(in);
			FilteredRowSet frs= new FilteredRowSetImpl();
			//implements cachedRowSet, a disconnected rowset object that operates on its own data
			frs.setUsername(props.getProperty("username"));
			frs.setPassword(props.getProperty("password"));
			frs.setUrl(props.getProperty("url")); //set isolation to make sure changes 
			frs.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
			if(frs.getPassword().equals(password) && frs.getUsername().equals(username))
			{	return 0; }
			frs.setCommand("SELECT * FROM JOEY_INMARS.BANKADMIN WHERE USERNAME=? AND PASSWORD=?");
			frs.setString(1, username);
			frs.setString(2, password);
			/*Connection con = DriverManager.getConnection(props.getProperty("url"), 
					 props.getProperty("username"), 
					 props.getProperty("password"));*/
			//con.setAutoCommit(false);
			frs.execute();
			/*Name filter
			 * userFilter nameFilter = new userFilter(username, 1);
			userFilter passFilter = new userFilter(password, 2);
			frs.beforeFirst();
			frs.setFilter(nameFilter); //prints balance from id in column 1
			frs.beforeFirst();
			frs.setFilter(passFilter);*/
			
			if (frs.next()) 
			{ 	System.out.println(frs.getString(1));
				System.out.println(frs.getString(2));	
				return 1;
			}
			
			frs.setCommand("SELECT * FROM JOEY_INMARS.BANKUSER WHERE USERNAME=? AND PASSWORD=?");
			frs.setString(1, username);
			frs.setString(2, password);
			frs.execute();
			//frs.setFilter(nameFilter); //prints balance from id in column 1
		//	frs.setFilter(passFilter);
			if (frs.next()) 
			{ 	//System.out.println(frs.getString(1));
				//System.out.println(frs.getString(2));	
				return 2;
			}
			
			
		        // Synchronizing the row
		        // back to the DB
					 //Auto-commit is on or turn setAutoCommit(false) then, let admin do the commit after even listener
				//frs.addRowSetListener(listener); //listener
			//	frs.acceptChanges(con);  //admin can add logic to the approval process before acceptChanges
						

		} catch (SQLException e1) {
			Log.logError("DEPOSIT:" +e1.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			Log.logError(e.getMessage());
		}
		return 3;
		
	}
	public static void createAdmin(String username, String password, String lastname, String firstname)
	{
		admin.insertAdmin(username, password, lastname, firstname);
		admin.createUser(username, password); //create user login
		admin.grantAdmin(new BankAdmin(username, password, lastname, firstname)); //grant admin role
		System.out.println("Admin created");
	}
	
	public static void createAccount(BankUser user)
	{
		account.createAccount(user);
	}
	
	public static List<BankUser> getAllUsers()
	{
		return admin.getAllUsers();
	}
	
	
	public static BankAdmin getBankAdmin(String lastname)
	{
		return BankAdminInterface.getAdmin(lastname);
	}
	
	public static void insertUser(String username, String password, String lastname, String firstname, int id)
	{
		admin.insertUser(username, password, lastname, firstname, id);		
		admin.createUser(username, password); //create user login
		admin.grantUserRole(new BankUser(username, password, lastname, firstname));//grant USER role
		System.out.println("Bankuser created");
	}
	
	public static BankUser getUser(String lastname, String firstname)
	{
		return user.getUser(lastname, firstname);
		
	}

	
	public static boolean deleteUser(String username, String password)
	{
		return admin.deleteUser(username, password);
	}
	public static int getAccountNumber(int id) 
	{
		return account.getAccountNumber(id);
	}
	public static int getAccountNumber(BankUser user)
	{
		return account.getAccountNumber(user);
	}
	public static float AccountDeposit(int acct, float balance)
	{
		return account.deposit(acct, balance);
	}
	public static float getBalance(int acct)
	{
		return account.getBalance(acct);
	}
	
	public static int getUserBalance(int userid)
	{
		return admin.getUserBalance(userid);
	}
	
	public static float AccountWithdraw(int acc, float amount)
	{
		return account.withdraw(acc, amount);
	}

	public static float deposit(BankUser user, float balance) {
		int acct= account.getAccountNumber(user);
		return account.deposit(acct, balance);
	}

	public static void deposit(int acct, float amount) {
	    user.deposit(acct, amount);
		
	}
	
	public static void withdraw(int acct, float amount) {
		user.withdraw(acct, amount);
	}
	
	public static float withdraw(BankUser user, float balance) {
		int acct= account.getAccountNumber(user);
		return account.withdraw(acct, balance);
	}

	public static float getBalance(String username, String password) {
		return user.getBalance(username, password);
	}

	public static int getId(String username, String password)
	{
		return user.getId(username, password);
	}

}
