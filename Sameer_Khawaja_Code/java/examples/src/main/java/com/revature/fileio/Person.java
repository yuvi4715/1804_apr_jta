package com.revature.fileio;

import java.io.Serializable;
import java.util.Date;

public class Person implements Serializable {

	private static final long serialVersionUID = 8815652956369338744L;
	
	private transient int age = 20;
	private String name = "Yuvi";
	private String address = "1st, Main st";
	private transient int ssn = 1234567890;
	//private transient Date dob= 1998-Jan-01;
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Person(int age, String name, String address, int ssn, Date dob) {
		super();
		this.age = age;
		this.name = name;
		this.address = address;
		this.ssn = ssn;
		//this.dob = dob;
	}
	
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getSsn() {
		return ssn;
	}
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + ", address=" + address + "]";
	}
}
