package com.revature.projectzero.accounts;

import java.sql.Timestamp;

public class Transaction {
	private long id;
	private long account_id;
	private double amount;
	private boolean isDeposit;
	private boolean isDeleted=false;
	private Timestamp timeDate;
	
	public Transaction() {}

	public Transaction(long id, long account_id, double amount, boolean isDeposit, boolean isDeleted,
			Timestamp timeDate) {
		super();
		this.id = id;
		this.account_id = account_id;
		this.amount = amount;
		this.isDeposit = isDeposit;
		this.isDeleted = isDeleted;
		this.timeDate = timeDate;
	}

	public boolean isDeleted() {
		return isDeleted;
	}

	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getAccount_id() {
		return account_id;
	}
	public void setAccount_id(long account_id) {
		this.account_id = account_id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public boolean isDeposit() {
		return isDeposit;
	}
	public void setDeposit(boolean isDeposit) {
		this.isDeposit = isDeposit;
	}
	public Timestamp getTimeDate() {
		return timeDate;
	}
	public void setTimeDate(Timestamp timeDate) {
		this.timeDate = timeDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (account_id ^ (account_id >>> 32));
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + (isDeposit ? 1231 : 1237);
		result = prime * result + ((timeDate == null) ? 0 : timeDate.hashCode());
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
		Transaction other = (Transaction) obj;
		if (account_id != other.account_id)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (id != other.id)
			return false;
		if (isDeposit != other.isDeposit)
			return false;
		if (timeDate == null) {
			if (other.timeDate != null)
				return false;
		} else if (!timeDate.equals(other.timeDate))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", account_id=" + account_id + ", amount=" + amount + ", "
				+ (isDeposit?"Deposit":"Withdrawl") + ", timeDate=" + timeDate + "]";
	}
	
	
}
