package com.revature.model;

import java.io.Serializable;

import java.sql.Timestamp;


public class Employee implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2379432251220327674L;
	private int userid;
	private String email;
	private String fName;
	private String lName;
	private Timestamp hireDate;
	private String passphrase;
	private int status = 1;
	
	public Employee() {}
	
	public Employee(int status, String email, String passphrase) {
		this.setStatus(status);
		this.email = fName;
		this.passphrase = lName;
		
		hireDate = Timestamp.valueOf("1999-12-31 23:59:59");
		fName = "";
		lName = "";
		userid = 0;
	}

	public Employee(int userid, String email, String fName, String lName, Timestamp hireDate, String passphrase) {
		super();
		this.userid = userid;
		this.email = email;
		this.fName = fName;
		this.lName = lName;
		this.hireDate = hireDate;
		this.passphrase = passphrase;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}

	public Timestamp getHireDate() {
		return hireDate;
	}

	public void setHireDate(Timestamp hireDate) {
		this.hireDate = hireDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((fName == null) ? 0 : fName.hashCode());
		result = prime * result + ((hireDate == null) ? 0 : hireDate.hashCode());
		result = prime * result + ((lName == null) ? 0 : lName.hashCode());
		result = prime * result + userid;
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
		if (fName == null) {
			if (other.fName != null)
				return false;
		} else if (!fName.equals(other.fName))
			return false;
		if (hireDate == null) {
			if (other.hireDate != null)
				return false;
		} else if (!hireDate.equals(other.hireDate))
			return false;
		if (lName == null) {
			if (other.lName != null)
				return false;
		} else if (!lName.equals(other.lName))
			return false;
		if (userid != other.userid)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Employee [userid=" + userid + ", email=" + email + ", fName=" + fName + ", lName=" + lName
				+ ", hireDate=" + hireDate + ", getUserid()=" + getUserid() + ", getEmail()=" + getEmail()
				+ ", getfName()=" + getfName() + ", getlName()=" + getlName() + ", getHireDate()=" + getHireDate()
				+ ", hashCode()=" + hashCode() + ", getClass()=" + getClass() + ", toString()=" + super.toString()
				+ "]";
	}

	public String getPassphrase() {
		return passphrase;
	}

	public void setPassphrase(String passphrase) {
		this.passphrase = passphrase;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	
	
	

}
