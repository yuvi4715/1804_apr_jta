package com.revature.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Manager {
	private String fname;
	private String lname;
	private String email;
	private boolean isDeleted = false;
	public Manager() {}
	public Manager(String fname, String lname, String email, boolean isDeleted) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.isDeleted = isDeleted;
	}
	@XmlElement
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	@XmlElement
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	@XmlElement
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@XmlElement
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Manager [fname=" + fname + ", lname=" + lname + ", email=" + email + ", isDeleted=" + isDeleted + "]";
	}
}
