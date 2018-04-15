package Bank;

import java.util.List;

public interface AccountDao 
{
	boolean insertAdmin(AdminAccount admin);
	boolean insertUser(UserAccount user);
	public UserAccount getUser(String user);
	public AdminAccount getAdmin(String admin);
	public boolean updateUser(UserAccount user);
	public List<UserAccount> getAllUsers();
}