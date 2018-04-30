package employee;
/**
 * Employee(BEAN)class defines fields: 
 * int id, String username(email)[PK], String password, String lastname, String firstname;
 * defines methods: constructors, getters and setters for fields, toString(), equals(), and hashCode()
 * @author joeyi
 *
 */
public class Employee {
	private int eid;
	private String username; //Must be an email and unique
	private String password;
	private String lastname;
	private String firstname;
	
	
	
	public Employee(int eid, String username, String password, String lastname, String firstname) {
		super();
		this.eid = eid;
		this.username = username;
		this.password = password;
		this.lastname = lastname;
		this.firstname = firstname;
	}



	public Employee() {
	}



	public int getEid() {
		return eid;
	}



	public void setEid(int eid) {
		this.eid = eid;
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



	public void setPassword(String password) {
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



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eid;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((username == null) ? 0 : username.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (eid != other.eid)
			return false;
		if (firstname == null) {
			if (other.firstname != null)
				return false;
		} else if (!firstname.equals(other.firstname))
			return false;
		if (lastname == null) {
			if (other.lastname != null)
				return false;
		} else if (!lastname.equals(other.lastname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", username=" + username + ", password=" + password + ", lastname=" + lastname
				+ ", firstname=" + firstname + "]";
	}
	

}
