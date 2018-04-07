package com.revature.oop;

import java.io.Serializable;

	public class Bank implements Serializable{
			private static final long serialVersionUID=1L;
			private int accountNumber;
			private float accountBalance;
			private String accountName;
			private String accountType;
			public Bank() {
				//default constructor
			}
			
			public Bank(int accountNumber, float accountBalance, String accountName, String accountType) {
				super();
			this.accountNumber = accountNumber;
			this.accountBalance = accountBalance;
			this.accountName = accountName;
			this.accountType = accountType;
		}
		public int getAccountNumber() {
			return accountNumber;
		}
		public void setAccountNumber(int accountNumber) {
			this.accountNumber = accountNumber;
		}
		public float getAccountBalance() {
			return accountBalance;
		}
		public void setAccountBalance(float accountBalance) {
			this.accountBalance = accountBalance;
		}
		public String getAccountName() {
			return accountName;
		}
		public void setAccountName(String accountName) {
			this.accountName = accountName;
		}
		public String getAccountType() {
			return accountType;
		}
		public void setAccountType(String accountType) {
			this.accountType = accountType;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Float.floatToIntBits(accountBalance);
			result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
			result = prime * result + accountNumber;
			result = prime * result + ((accountType == null) ? 0 : accountType.hashCode());
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
			Bank other = (Bank) obj;
			if (Float.floatToIntBits(accountBalance) != Float.floatToIntBits(other.accountBalance))
				return false;
			if (accountName == null) {
				if (other.accountName != null)
					return false;
			} else if (!accountName.equals(other.accountName))
				return false;
			if (accountNumber != other.accountNumber)
				return false;
			if (accountType == null) {
				if (other.accountType != null)
					return false;
			} else if (!accountType.equals(other.accountType))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Bank [accountNumber=" + accountNumber + ", accountBalance=" + accountBalance + ", accountName="
					+ accountName + ", accountType=" + accountType + "]";
		}
		
		
}
