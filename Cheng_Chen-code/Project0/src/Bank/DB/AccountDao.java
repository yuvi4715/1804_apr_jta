package Bank.DB;

import java.util.List;

import Accounts.AdminAccount;
import Bank.UserAccount;

public interface AccountDao 
{
	boolean insertAdmin(AdminAccount admin);
	boolean insertUser(UserAccount user);
	public UserAccount getUser(String user);
	public AdminAccount getAdmin(String admin);
	public boolean updateUser(UserAccount user);
	public List<UserAccount> getAllUsers();
	public boolean deleteUser(String user);
}