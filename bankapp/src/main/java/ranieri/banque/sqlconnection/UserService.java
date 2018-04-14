package ranieri.banque.sqlconnection;

import ranieri.project0.User;

public class UserService{

	public static UserDao dao = UserDaoImpl.getInstance(); 
	
	private UserService() {};
	
	
	public static User getUser(String username) {
		return dao.getUser(username);
		
	}
	
	
	
	public static void main(String[] args) {
		
		User tony = UserService.getUser("not Tony Soprano");
		
		System.out.println(tony.getBalance());

	}

}
