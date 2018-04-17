package Bank;

import java.util.List;

import Accounts.AdminAccount;
import Bank.DB.AccountDao;
import Bank.DB.AccountDaoImpl;

public class BankService {

	private static AccountDao dao = new AccountDaoImpl();
	
	public static boolean insertUser(UserAccount user)
	{
		return dao.insertUser(user);
	}
	
	public static boolean insertAdmin(AdminAccount admin)
	{
		return dao.insertAdmin(admin);
	}
	
	public static UserAccount getUser(String user)
	{
		return dao.getUser(user);
	}
	
	public static AdminAccount getAdmin(String admin)
	{
		return dao.getAdmin(admin);
	}
	
	public static boolean updateUser(UserAccount user)
	{
		return dao.updateUser(user);
	}
	
	public static void getAllUsers()
	{
		dao.getAllUsers();
	}
	
	public static boolean deleteUser(String delete)
	{
		return dao.deleteUser(delete);
	}
}
