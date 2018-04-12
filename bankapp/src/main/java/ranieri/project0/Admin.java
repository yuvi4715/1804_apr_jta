package ranieri.project0;

public class Admin {
	
	
	
	private String username;
	private String password;
	
		
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public void authorizeUser(Customer customer) {
		customer.setAuthorized(true);		
	}
	
	public void createAdmin(String username, String password) {
		
	}
	
	

}
