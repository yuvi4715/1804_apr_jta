package ranieri.banque.sqlconnection;

import ranieri.project0.*;

import java.util.List;

public interface UserDao {
	
	
	public boolean insertUser();
	public boolean updateUser();
	public  User getUser(String username);
	public List<User> getAllCustomers();
	

}
