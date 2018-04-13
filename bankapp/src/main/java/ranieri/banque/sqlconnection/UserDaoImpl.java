package ranieri.banque.sqlconnection;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ranieri.project0.Customer;

public class UserDaoImpl implements UserDao{

	@Override
	public boolean insertUser() {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionBanque.getConnection()){
			CallableStatement stmt = conn.prepareCall("CALL {insert_user(?,?,?,?,?)}");
			stmt.setString(Customer.g, arg1);
			
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
	public boolean getUser() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

}
