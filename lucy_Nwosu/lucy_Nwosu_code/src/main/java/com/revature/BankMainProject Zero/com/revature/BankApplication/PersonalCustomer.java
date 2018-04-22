package com.revature.BankApplication;

import bankModel.Customer;

public class PersonalCustomer extends Customer {
	
	private String homePhone;
	private String workPhone;
	
public PersonalCustomer(String name) {
	super(name);
}

public String getHomePhone() {
	return homePhone;
	
}

public void setHomePhone(String homePhone) {
	this.homePhone = homePhone;
	
}
public String getWorkPhone() {
	return workPhone;
	
	}
public void setWorkPhone(String workPhone) {
	this.workPhone = workPhone;
}
}
