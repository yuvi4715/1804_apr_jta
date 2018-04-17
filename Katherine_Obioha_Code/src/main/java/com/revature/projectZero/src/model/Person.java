package com.kobio.model;








public class Person {

	private int ID =0; ; //generated number
	private String firstname;
	private String lastname;
	private String username;//constraint unique
	private String password;  // encrypt //constraint 
	private String role;
	private String ssn;
	private String email;
	
	public Person()
	{
		
	}
	
	
	public Person(String firstname, String lastname, String username, String password,
			String role, String ssn, String email) {
		super();
	
		this.firstname = firstname;
		this.lastname = lastname;
		this.username = username;
		this.password = password;
	
		this.role = role;
		this.ssn = ssn;
		this.email = email;
	}


	public int getID() {
		return ID;
	}


	public void setID(int id) {
		this.ID = id;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
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

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		Person other = (Person) obj;
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
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
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
		return "Person [firstname=" + firstname + ", lastname=" + lastname + ", username=" + username + ", password="
				+ password  + ", role=" + role + ", ssn=" + ssn + ", email=" + email  + ",personid=" + ID + "]";
	}

	
	
	


//public static void main(String[]args)
//{
//	
//	 addperson();
//}
//
//
//private static void addperson() {
//	// TODO Auto-generated method stub
//	try(Connection conn = ConnectionProperties.getConnection())
//	{
//		PreparedStatement stmt = conn.prepareStatement("INSERT INTO Person"
//				+ "(email) VALUES (?)");
//		Person p = new Person();
//		 p.setUsername("nooo");
//		 p.setEmail("kat@me.com");
//		stmt.setString(1,p.getEmail());
//		
//		if(!stmt.execute())
//		{  
//			//executeupdate returns
//			//return stmt.getUpdateCount()>0;  
//		}
//	}
//	catch(SQLException e)
//	{
//		System.out.println(e.getMessage());
//		if(e.getMessage().contains("KATHERINE.USERNAMEUNIQUECONSTRAINT"))
//		{
//			System.out.println("Username is already in the database. Please select another username.");
//		}
//		if(e.getMessage().contains("KATHERINE.MINLENGTHCONSTRAINT"))
//		{
//			
//			System.out.println("Minimum Length for username is 4");
//		}
//		if(e.getMessage().contains("KATHERINE.EMAILPATTERNCONSTRAINT"))
//		{
//			
//			System.out.println("Email address is not valid");
//		}
//		if(e.getMessage().contains("KATHERINE.EMAILUNIQUECONSTRAINT"))
//		{
//			
//			System.out.println("Email address is already in the database, please log in");
//		}
//	}
//	}
}

