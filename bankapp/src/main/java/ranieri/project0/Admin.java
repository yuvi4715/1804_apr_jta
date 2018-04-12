package ranieri.project0;

public class Admin {
	
	
	
	private String username;
	private String password;
	
		
	public Admin(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public void getAllUnauthorizedUsers() {
		// method that shows all unauthorized users
		
	}

	public void authorizeUser(Customer customer) {
		//
		
		customer.setAuthorized(true);		
	}
	
	public void createAdmin(String username, String password) {
		
		// method that creates a sql insert for new admin
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	
	

}
