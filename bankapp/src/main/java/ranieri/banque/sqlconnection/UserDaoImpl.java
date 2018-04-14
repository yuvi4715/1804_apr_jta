package ranieri.banque.sqlconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
	public boolean insertUser(User user) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionBanque.getConnection()){
			
			CallableStatement stmt = conn.prepareCall("INSERT INTO BANQUE_USER(username,password,balance,authorization, role) VALUES(?,?,?,?,?)");
			stmt.setString(1, user.getUsername());
			stmt.setString(2,user.getPassword() );
			stmt.setDouble(3, user.getBalance());
			stmt.setInt(4, user.getAuth());
			stmt.setString(5, user.getRole());
			System.out.println(stmt);
						
				return stmt.executeUpdate()> 0 ;
				
		
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		return false;
	}

	@Override
	public boolean updateUser(User user) {
		// TODO Auto-generated method stub
		
		
		
		
		return false;
	}

	@Override
	public User getUser(String username) {
		
		try(Connection conn = ConnectionBanque.getConnection()){
			PreparedStatement stmt = conn.prepareCall("SELECT username, password, balance, authorization FROM banque_user WHERE username = ? ");
			stmt.setString(1, username );
			
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return new User(rs.getString("username"), rs.getString("password"),rs.getInt("authorization"), rs.getDouble("balance"));
			}

						
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return null;
	}

	@Override
	public List<User> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
