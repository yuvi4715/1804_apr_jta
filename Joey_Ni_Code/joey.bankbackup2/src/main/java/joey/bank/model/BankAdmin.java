package joey.bank.model;

public class BankAdmin {
	
	private String username;
	private String password;
	private String lastname;
	private String firstname;
	//private Integer id=null;
	
	
	
	public BankAdmin(String username, String password, String lastname, String firstname) 
	{
		super();
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	private void setPassword(String password) {
		this.password = password;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

}
