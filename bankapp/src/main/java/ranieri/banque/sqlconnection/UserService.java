package ranieri.banque.sqlconnection;

public class UserService{

	public static UserDao dao = UserDaoImpl.getInstance(); 
	
	private UserService() {};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
