package ranieri.banque.sqlconnection;

import java.util.List;

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
	
	public static List<String> getUnAuthUsers(){		
		return dao.getAllCustomers();
	}
	
	
	public static void main(String[] args) {
//		User test = new User("tester","testpass",1,80900);
//		UserService.insertUser(test);
//		test.setPassword("jinglebells");	
//		UserService.updateUser(test);
		
//		User tony = UserService.getUser("CODEMASTER");	
//		System.out.println(tony.getPassword());
		
//		List<String> unath = UserService.getUnAuthUsers();
//		
//		for (String e : unath) {
//			System.out.println(e);
//		}

	}

}
