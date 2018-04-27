package com.revature.model;

import java.io.Serializable;

public class Employee implements Serializable {

	private static final long serialVersionUID = -3025846853748189968L;
	private String email, firstname, lastname, loginStatus;
	
	public Employee() {}
	
	public Employee(String loginStatus) {
		super();
		this.loginStatus = loginStatus;
	}
	
	public Employee(String email, String firstname, String lastname, String loginStatus) {
		
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.loginStatus = loginStatus;
	}

	
	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((firstname == null) ? 0 : firstname.hashCode());
		result = prime * result + ((lastname == null) ? 0 : lastname.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + ", status=" + loginStatus + "]";
	}
	
	
}
