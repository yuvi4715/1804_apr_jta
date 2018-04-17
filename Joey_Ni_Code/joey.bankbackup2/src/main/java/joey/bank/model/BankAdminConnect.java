package joey.bank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.RowSetEvent;
import javax.sql.RowSetListener;

import joey.bank.ConnectDB;
import joey.bank.Log;

public class BankAdminConnect implements BankAdminInterface, RowSetListener {
	
	private static BankAdminConnect instance =null;
	//private constructor to ensure BankAdminConnect does not instantiate
	private BankAdminConnect() {}
	
	//Public method to get instance of BankUserConnect, only one connection for app
	public static BankAdminConnect getInstance()
	{
		if(instance == null) instance=new BankAdminConnect();
		return instance;
	}
	
	//get user balance by user id, known by user and admin only
	@Override
	public int getUserBalance(int userid)
	{
		try(Connection con = ConnectDB.getCon())
		{
			PreparedStatement stmt = con.prepareStatement("SELECT balance FROM JOEY_INMARS.BANK_ACCOUNT WHERE ID=?");
			stmt.setInt(1, userid);
			ResultSet rs=stmt.executeQuery();
			if(rs.next()) return rs.getInt(1);
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
		
		return 0;
	}
	

	public static BankAdmin insertAdmin(String username, String password, String lastname, String firstname)
	{
		BankAdmin admin=new BankAdmin(username, password, lastname, firstname);
	
		//Create Admin
		
		try {
			Connection con = ConnectDB.getCon();
			PreparedStatement stmt = con.prepareStatement("INSERT INTO BANKADMIN VALUES (?,?,?,?,?)");
			stmt.setString(1, admin.getUsername());
			stmt.setString(2, admin.getPassword());
			stmt.setString(3, admin.getLastname());
			stmt.setString(4, admin.getFirstname());
			stmt.setString(5, null);
			stmt.executeUpdate();
			
		} catch (SQLException e1) {
			Log.logError("At BankUserConnect 36:"+e1.getMessage());
		}
		return admin;
		
	}
	
	static void grantAdmin(BankAdmin admin)
	{
		try(Connection con = ConnectDB.getCon())
		{
			System.out.println(admin.getUsername());
			PreparedStatement stmt = con.prepareStatement("GRANT BANK_ADMIN TO "+admin.getUsername());
			stmt.execute();
			PreparedStatement stmt1 = con.prepareStatement("GRANT ALL ON JOEY_INMARS.BANKUSER TO "+admin.getUsername()+" WITH GRANT OPTION");
			PreparedStatement stmt2 = con.prepareStatement("GRANT ALL ON JOEY_INMARS.BANK_ACCOUNT TO "+admin.getUsername()+" WITH GRANT OPTION");
			//stmt.setString(1, admin.getUsername());
			stmt1.execute();
			stmt2.execute();
			Log.logInfo("At BankAdminConnect: Admin Role granted to " + admin.getUsername());
		} catch (SQLException e) {
			Log.logError("At BankAdminConnect 52:"+e.getMessage());
		}
	}

	static void createUser(String username, String password)
		{
			try(Connection con = ConnectDB.getCon())
			{
				
				PreparedStatement stmt = con.prepareStatement("CREATE USER "+username+" IDENTIFIED BY "+password);
				//stmt.setString(1, username);
				//stmt.setString(2, password);
				stmt.execute();
				Log.logError("At BankAdminConnect: User created: "+ username);
				
			} catch (SQLException e) {
				Log.logError("At BankAdminConnect 94:"+e.getMessage());
			}
				
		}
		
	public static BankUser insertUser(String username, String password, String lastname, String firstname, int admin) 
	{
			BankUser user=new BankUser(username, password, lastname, firstname);
			try(Connection con = ConnectDB.getCon())
			{
				
				PreparedStatement stmt = con.prepareStatement("INSERT INTO JOEY_INMARS.BANKUSER (username, password, lastname, firstname, admin_id) " 
						+ "VALUES (?,?,?,?,?)");

				stmt.setString(1, username);
				stmt.setString(2, password);
				stmt.setString(3, lastname);
				stmt.setString(4, firstname);
				//stmt.setInt(6, user.getAdmin_id());
				stmt.setInt(5, admin);
				stmt.executeUpdate(); 
				
				if(stmt.executeUpdate()>1) return user;
			} catch (SQLException e) {
				Log.logError("At BankAdminConnect 118:"+e.getMessage());
			}
			return user;
	}

		//Do not grant bank_user, instead used stored procedure to grant bank_user accesses. 
		//Bank_admin does not have GRANT ANY ROLE privilege
	public static void grantUserRole(BankUser user)
	{
			try(Connection con = ConnectDB.getCon())
			{
				System.out.println(user.getUsername());
				PreparedStatement stmt0 = con.prepareStatement("GRANT CREATE SESSION TO "+user.getUsername());
				stmt0.execute();
				PreparedStatement stmt = con.prepareStatement("GRANT SELECT ON JOEY_INMARS.BANK_ACCOUNT TO "+user.getUsername());
				PreparedStatement stmt1 = con.prepareStatement("GRANT SELECT ON JOEY_INMARS.BANKUSER TO "+user.getUsername());
				//stmt.setString(1, admin.getUsername());
				stmt.execute();
				stmt1.execute();
				Log.logInfo("At BankAdminConnect: BankUser Role granted to " + user.getUsername());
			} catch (SQLException e) {
				Log.logError("At BankAdminConnect 137:"+e.getMessage());
			}
			
	}
		
	@Override
	public boolean deleteUser(String username, String password) 
	{
			try(Connection con = ConnectDB.getCon())
			{
				PreparedStatement stmt = con.prepareStatement("DELETE * FROM JOEY_INMARS.BANKUSER WHERE username=? AND password=?");
				stmt.setString(1, username);
				stmt.setString(2, password);
				stmt.executeUpdate();

				//returns 1, number of row modified from the DML statement
				return stmt.executeUpdate() == 1;
			} catch (SQLException e) {
				Log.logError("At BankAdminConnect 125:"+e.getMessage());
			}
			return false;
	}
		
	@Override
	public List<BankUser> getAllUsers() 
	{
			try(Connection con = ConnectDB.getCon())
			{
				List<BankUser> users = new ArrayList<>();
				PreparedStatement stmt = con.prepareStatement("SELECT * FROM JOEY_INMARS.BANKUSER");
				ResultSet rs=stmt.executeQuery();
				while(rs.next())
				{
					users.add(new BankUser(rs.getString(1),
							rs.getString(2),rs.getString(3),rs.getString(4)));
				}
				
				return users;
			} catch (SQLException e) {
				Log.logError(e.getMessage());
			}
			
			return null;
	}
		

	@Override
	public BankAdmin createAdmin(BankAdmin admin) {
		
		return null;
	}
	//Approve method to have an admin check user to make sure user and amount are legal
	/*1. admin login to database
	 * 2. admin checks amount make sure username and password match, withdrawal < balance
	 * 3. admin updates and log out
	 * @see joey.bank.model.BankAdminInterface#approve(java.lang.String, java.lang.String, float)
	 */
	@Override
	public boolean approve(String username, String password, float amount) 
	{
		
		
		
		
		return false;
	}

	@Override
	public void rowSetChanged(RowSetEvent event) {
		Log.logInfo("Approving");
		System.out.println("Deposit/Withdrawal accepted");
	}

	@Override
	public void rowChanged(RowSetEvent event) {
		Log.logInfo("Approving");
		System.out.println("Balance updated");
	}

	@Override
	public void cursorMoved(RowSetEvent event) {
		
	}

	


}
