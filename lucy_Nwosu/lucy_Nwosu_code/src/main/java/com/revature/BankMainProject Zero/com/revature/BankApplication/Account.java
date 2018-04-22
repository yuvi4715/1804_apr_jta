package com.revature.BankApplication;

public class Account {
	
		
		private long accountNumber;
		private double balance;
		private static long accountCounter = 20180000;//
		Transaction transactionArray[] = new Transaction[1000];
		private int tCounter=0;
		
		public Account() {
		accountNumber = ++ accountCounter;
		}
			public double getBalance() {
			return balance;
		}
		
		public void setBalance(double balance) {
			this.balance = balance;
		}
		public long getAccountNumber() {
			return accountNumber;
				
	}
		
		public Transaction[] getTransactionArray() {
			return transactionArray;
		}
		public int gettCounter() {
			return tCounter;
		}
		public Transaction deposit(double amount) {
			balance = balance+amount;
			transactionArray[tCounter] = new Transaction("Deposit", amount);
			tCounter++;
			return transactionArray[tCounter-1];
			
		}
		
		public Transaction withdraw(double amount) {
			balance = balance-amount;
			transactionArray[tCounter] = new Transaction("Withdraw", amount);
			tCounter++;
			return transactionArray[tCounter-1];
	}
		
}


