package ranieri.banque.sqlconnection;

import ranieri.project0.*;

import java.util.List;

public interface UserDao {
	
	
	public boolean insertUser();
	public boolean updateUser();
	public boolean getUser();
	public List<Customer> getAllCustomers();

}
