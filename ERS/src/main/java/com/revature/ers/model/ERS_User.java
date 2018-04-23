package com.revature.ers.model;

import java.io.Serializable;

public class ERS_User implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int user_id;
    private String passwd;
    private String firstName;
    private String lastName;
    private String email;
    int isManager;
    
	public ERS_User(int user_id, String passwd, String firstName, String lastName, String email, int isManager) {
		super();
		this.user_id = user_id;
		this.passwd = passwd;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.isManager = isManager;
	}

	public ERS_User() {
		super();
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getIsManager() {
		return isManager;
	}

	public void setIsManager(int isManager) {
		this.isManager = isManager;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + isManager;
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + user_id;
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
		ERS_User other = (ERS_User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (isManager != other.isManager)
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (user_id != other.user_id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ERS_User [user_id=" + user_id + ", passwd=" + passwd + ", firstName=" + firstName + ", lastName="
				+ lastName + ", email=" + email + ", isManager=" + isManager + "]";
	}
    
	
	
    
}
