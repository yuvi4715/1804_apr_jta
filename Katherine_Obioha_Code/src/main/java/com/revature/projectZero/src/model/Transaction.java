package com.kobio.model;

import java.util.Date;

public class Transaction {
//SELECT accountid, datetime, loanrequested, loangranted, loanduedate FROM account"
	private Account account;
	private Date datetime;
	private int loanrequested;
	private char loangranted;
	private Date loanduedate;
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	public Date getDatetime() {
		return datetime;
	}
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	public int getLoanrequested() {
		return loanrequested;
	}
	public void setLoanrequested(int loanrequested) {
		this.loanrequested = loanrequested;
	}
	public char getLoangranted() {
		return loangranted;
	}
	public void setLoangranted(char loangranted) {
		this.loangranted = loangranted;
	}
	public Date getLoanduedate() {
		return loanduedate;
	}
	public void setLoanduedate(Date loanduedate) {
		this.loanduedate = loanduedate;
	}
	@Override
	public String toString() {
		return "Transaction [account=" + account + ", datetime=" + datetime + ", loanrequested=" + loanrequested
				+ ", loangranted=" + loangranted + ", loanduedate=" + loanduedate + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((datetime == null) ? 0 : datetime.hashCode());
		result = prime * result + ((loanduedate == null) ? 0 : loanduedate.hashCode());
		result = prime * result + loangranted;
		result = prime * result + loanrequested;
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
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (datetime == null) {
			if (other.datetime != null)
				return false;
		} else if (!datetime.equals(other.datetime))
			return false;
		if (loanduedate == null) {
			if (other.loanduedate != null)
				return false;
		} else if (!loanduedate.equals(other.loanduedate))
			return false;
		if (loangranted != other.loangranted)
			return false;
		if (loanrequested != other.loanrequested)
			return false;
		return true;
	}
	
	
}
