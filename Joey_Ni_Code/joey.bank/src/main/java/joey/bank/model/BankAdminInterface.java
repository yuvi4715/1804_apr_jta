package joey.bank.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import joey.bank.ConnectDB;
import joey.bank.Log;

public interface BankAdminInterface {
	int getUserBalance(int userid);

	BankAdmin insertAdmin(String username, String password, String lastname, String firstname);
	void grantAdmin(BankAdmin admin);
	
	void createUser(String username, String password);
	
	BankUser insertUser(String username, String password, String lastname, String firstname, int admin);
	void grantUserRole(BankUser user);
	
	List<BankUser> getAllUsers();
	boolean deleteUser(String username, String password);

	static BankAdmin getAdmin(String lastname) {
		try(Connection con = ConnectDB.getCon())
		{
			PreparedStatement stmt = con.prepareStatement("SELECT * FROM BANKADMIN WHERE lastname=?");
			ResultSet rs=stmt.executeQuery();
			if(rs.next())
			{
				return new BankAdmin(rs.getString(1),
						rs.getString(2),rs.getString(3),rs.getString(4));
			}
			
		} catch (SQLException e) {
			Log.logError(e.getMessage());
		}
		return null;
	}
	
	
	
}
