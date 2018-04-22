package com.revature.BankApplication;

import bankModel.Customer;

public class CommercialCustomer extends Customer {
	
	private String contactPerson;
	private String contactPersonPhone; 
	
	public CommercialCustomer(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getContactPersonPhone() {
		return contactPersonPhone;
	}

	public void setContactPersonPhone(String contactPersonPhone) {
		this.contactPersonPhone = contactPersonPhone;
	}



}
