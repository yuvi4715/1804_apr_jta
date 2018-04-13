package ranieri.banque.sqlconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;


import ranieri.project0.*;

public class UserDaoImpl implements UserDao{
	
	
private static UserDaoImpl instance;
	
	private UserDaoImpl() {}
	
	public static UserDaoImpl getInstance() {
		if(instance == null) {
			instance = new UserDaoImpl();
		}
		return instance;
	}
	
	

	@Override
	public boolean insertUser() {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionBanque.getConnection()){
			CallableStatement stmt = conn.prepareCall("CALL {insert_user(?,?,?,?,?)}");
			
			

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return false;
	}

	@Override
	public boolean updateUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getUser(User user) {
		try(Connection conn = ConnectionBanque.getConnection()){
			PreparedStatement stmt = conn.prepareCall("SELECT * from banque_user WHERE username = ? ;");
			stmt.setString(1, user.getUsername() );

			return stmt.executeUpdate()> 0 ;
						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		return false;
	}

	@Override
	public List<User> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
