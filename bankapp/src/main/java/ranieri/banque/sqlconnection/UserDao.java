package ranieri.banque.sqlconnection;

import ranieri.project0.*;

import java.util.List;

public interface UserDao {
	
	
	public boolean insertUser(User user);
	public boolean updateUser(User user);
	public  User getUser(String username);
	public List<User> getAllCustomers();
	

}
