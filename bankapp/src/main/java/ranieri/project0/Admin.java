package ranieri.project0;

public class Admin extends User {
	
	
	
	private String username;
	private String password;
	private boolean authorized = true;
	
		
	public Admin(String username, String password) {
		super(username, password);
		this.username = username;
		this.password = password;
	}
	
	public void getAllUnauthorizedUsers() {
		// method that shows all unauthorized users
		
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
	
	
	
	@Override
	public String toString() {
		return "Admin [username=" + username + ", password=" + password + ", authorized=" + authorized + "]";
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
				Admin steve = new Admin("rhino", "p4$$word");
				System.out.println("sdfsdfdsf");
				System.out.println(steve);

	}

}
