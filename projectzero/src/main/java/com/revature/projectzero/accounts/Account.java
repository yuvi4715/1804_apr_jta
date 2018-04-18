package com.revature.projectzero.accounts;

import java.util.List;

public class Account {
	private List<Transaction> trans;
	private double balance = 0.0d;
	private long id = 0L;
	private User owner;
	private AccountTypes type;
	private boolean isDeleted = false;
	
	
	public Account(double balance, long id, User owner, AccountTypes type, boolean isDeleted) {
		super();
		this.balance = balance;
		this.id = id;
		this.owner = owner;
		this.type = type;
		this.isDeleted = isDeleted;
	}
	
	public List<Transaction> getTran() {
		return trans;
	}

	public void setTran(List<Transaction> tran) {
		this.trans = tran;
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		if(balance<0)
			this.balance=0;
		else
			this.balance = balance;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public AccountTypes getType() {
		return type;
	}
	public void setType(AccountTypes type) {
		this.type = type;
	}
	public boolean isDeleted() {
		return isDeleted;
	}
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	@Override
	public String toString() {
		return "Account [balance=" + balance + ", id=" + id + ", owner=" + owner + ", type=" + type + ", isDeleted="
				+ isDeleted + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isDeleted ? 1231 : 1237);
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		result = prime * result + ((trans == null) ? 0 : trans.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (id != other.id)
			return false;
		if (isDeleted != other.isDeleted)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		if (trans == null) {
			if (other.trans != null)
				return false;
		} else if (!trans.equals(other.trans))
			return false;
		if (type != other.type)
			return false;
		return true;
	}
	
	
}
