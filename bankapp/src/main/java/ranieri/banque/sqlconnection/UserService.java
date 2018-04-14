package ranieri.banque.sqlconnection;

import ranieri.project0.User;

public class UserService{

	public static UserDao dao = UserDaoImpl.getInstance(); 
	
	private UserService() {};
	
	
	public static User getUser(String username) {
		return dao.getUser(username);
		
	}
	
	public static boolean insertUser(User user) {
		return dao.insertUser(user);
	}
	
	public static boolean updateUser(User user) {
		return dao.updateUser(user);
	}
	
	
	public static void main(String[] args) {
		User test = new User("tester","testpass",1,80900);
//		UserService.insertUser(test);
		test.setPassword("jinglebells");
		
		UserService.updateUser(test);
		
//		User tony = UserService.getUser("CODEMASTER");	
//		System.out.println(tony.getPassword());
		
		

	}

}
