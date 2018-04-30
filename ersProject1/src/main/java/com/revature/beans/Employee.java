package com.revature.beans;

import java.io.Serializable;

public class Employee implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1161949639339849047L;
	private int employeeId;
	private String email;
	private String userName;
	private String password;
	private String firstName;
	private String lastName;
	private boolean managerStatus;
	private boolean employmentStatus;
	
	public Employee(int employeeId, String email, String userName, String password, String firstName, String lastName,
			boolean managerStatus, boolean employmentStatus) {
		super();
		this.employeeId = employeeId;
		this.email = email;
		this.userName = userName;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.managerStatus = managerStatus;
		this.employmentStatus = employmentStatus;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
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
	public boolean getManagerStatus() {
		return managerStatus;
	}
	public void setManagerStatus(boolean managerStatus) {
		this.managerStatus = managerStatus;
	}
	public boolean getEmploymentStatus() {
		return employmentStatus;
	}
	public void setEmploymentStatus(Boolean employmentStatus) {
		this.employmentStatus = employmentStatus;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + employeeId;
		result = prime * result + (employmentStatus ? 1231 : 1237);
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (managerStatus ? 1231 : 1237);
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
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
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (employeeId != other.employeeId)
			return false;
		if (employmentStatus != other.employmentStatus)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (managerStatus != other.managerStatus)
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", email=" + email + ", userName=" + userName + ", password="
				+ password + ", firstName=" + firstName + ", lastName=" + lastName + ", managerStatus=" + managerStatus
				+ ", employmentStatus=" + employmentStatus + "]";
	}
	
	
	
}
