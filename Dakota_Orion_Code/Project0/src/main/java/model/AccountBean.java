package model;

import java.io.Serializable;

public class AccountBean implements Serializable{

	private static final long serialVersionUID = 1L;
	private int AccountBeanId;
	private String status;
	private int balance;
	private int limit;
	private String type;
	
	public AccountBean() {
		super();
	}

	public AccountBean(String status, int balance, int limit, String type) {
		super();
		this.status = status;
		this.balance = balance;
		this.limit = limit;
		this.type = type;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + AccountBeanId;
		result = prime * result + balance;
		result = prime * result + limit;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
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
		AccountBean other = (AccountBean) obj;
		if (AccountBeanId != other.AccountBeanId)
			return false;
		if (balance != other.balance)
			return false;
		if (limit != other.limit)
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AccountInfo [AccountBeanId=" + AccountBeanId + ", status=" + status + ", balance=" + balance
				+ ", limit=" + limit + ", type=" + type + "]";
	}

	public int getAccountBeanId() {
		return AccountBeanId;
	}

	public void setAccountBeanId(int accountBeanId) {
		AccountBeanId = accountBeanId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
