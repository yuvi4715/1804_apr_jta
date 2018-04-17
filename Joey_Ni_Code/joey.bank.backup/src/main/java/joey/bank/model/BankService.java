package joey.bank.model;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import joey.bank.ConnectDB;
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
	
	public static BankAdmin createAdmin(String username, String password, String lastname, String firstname)
	{
		BankAdmin admin=BankAdminConnect.insertAdmin(username, password, lastname, firstname);
		
		BankAdminConnect.createUser(username, password); //create user login
		BankAdminConnect.grantAdmin(admin); //grant admin role
		return admin;
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
		return BankAdminInterface.getAdmin("firstname");
	}
	
	public static BankUser insertUser(String username, String password, String lastname, String firstname, int admin)
	{
		BankUser user=BankAdminConnect.insertUser(username, password, lastname, firstname, admin);		
		BankAdminConnect.createUser(username, password); //create user login
		BankAdminConnect.grantUserRole(user);//grant USER role
		return user;
	}
	
	public static BankUser getUser(String lastname, String firstname)
	{
		return user.getUser(lastname, firstname);
		
	}

	public static boolean updateAccount(BankUser user, float amount)
	{
		//if(BankAdminConnect.approve(user)) return instance.updateAccount(user, amount);
		return false;
		
	}
	
	public static boolean deleteUser(String username, String password)
	{
		return admin.deleteUser(username, password);
	}
	
	public static boolean insertAdmin(BankUser user)
	{
		return false;
		
	}
	
	public static boolean deleteAdmin(BankUser user) 
	{
		return false;
		
	}

	public boolean updateBalance(BankUser user) {
		// TODO Auto-generated method stub
		return false;
	}

	public int getAccountNumber(BankUser user) {
		// TODO Auto-generated method stub
		return 0;
	}

	public static float deposit(BankUser user, float balance) {
		int acct= account.getAccountNumber(user);
		return account.deposit(acct, balance);
	}

	public static void deposit(String username, String password, float amount) {
		if (admin.approve(username, password, amount)) user.deposit(amount);
	}
	
	public static void withdraw(String username, String password, float amount) {
		if (admin.approve(username, password, amount)) user.withdraw(amount);
	}
	
	public static float withdraw(BankUser user, float balance) {
		int acct= account.getAccountNumber(user);
		return account.withdraw(acct, balance);
	}

	public static float getBalance(String username, String password) {
		return user.getBalance(username, password);
	}

	public BankAdmin createAdmin(BankAdmin admin) {
		// TODO Auto-generated method stub
		return null;
	}

	public void grantUserRole(BankUser user) {
		// TODO Auto-generated method stub
		
	}

	public void createUser(BankUser user) {
		// TODO Auto-generated method stub
		
	}


}
