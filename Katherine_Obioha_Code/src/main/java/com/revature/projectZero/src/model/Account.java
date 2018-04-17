package com.kobio.model;

public class Account {

	private Person person;
	private  int ID =0; //generated number +1
	private  int accountnumber; //Generated number, unique, size 7
	private int balance = 0;
	private char approve = 'N';
	private int creditscore = 0;
	public Account()
	{
		
	}
	public int getAccountnumber() {
		return accountnumber;
	}
	public  void setAccountnumber(int accountnber) { //get last account number from database and add + 1
		this.accountnumber = accountnber;
	}
	public int getBalance() {
		return balance;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", approve=" + approve + ",accountnumber=" + accountnumber  + ",personid=" + person.getID()  + ",creditscore=" + creditscore +" ]";
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public char getapprove() {
		return approve;
	}
	public void setApprove(char approve) {
		this.approve = approve;
	}
	public int getID() {
		return ID;
	}
	public void setID(int Id) {
		this.ID = Id;
	}
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	public int getCreditscore() {
		return creditscore;
	}
	public void setCreditscore(int creditscore) {
		this.creditscore = creditscore;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + accountnumber;
		result = prime * result + approve;
		result = prime * result + balance;
		result = prime * result + creditscore;
		result = prime * result + ((person == null) ? 0 : person.hashCode());
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
		Account other = (Account) obj;
		if (ID != other.ID)
			return false;
		if (accountnumber != other.accountnumber)
			return false;
		if (approve != other.approve)
			return false;
		if (balance != other.balance)
			return false;
		if (creditscore != other.creditscore)
			return false;
		if (person == null) {
			if (other.person != null)
				return false;
		} else if (!person.equals(other.person))
			return false;
		return true;
	}	
	
	
}
