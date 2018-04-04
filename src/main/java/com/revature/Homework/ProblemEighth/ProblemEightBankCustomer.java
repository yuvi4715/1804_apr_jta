package com.revature.Homework.ProblemEighth;


public class ProblemEightBankCustomer {

		private static long customerCount=0L;
		private String name;
		private double balance;
		final private long customerID;
		ProblemEightBankCustomer(String pName){
			name=pName;
			balance = 0;
			customerID=customerCount++;
		}
		ProblemEightBankCustomer(String pName,int pBalance){
			this(pName);
			balance = pBalance;
		}
		public void raiseBalanceByPercentage(double percent) {
			balance += balance*(percent);
		}
		public void raiseBalanceByPercentage(double newBalance,double percent) {
			balance = newBalance;
			raiseBalanceByPercentage(percent);
		}
		public void raiseBalanceByFlatAmount(double amount) {
			balance += amount;
		}
		public void raiseBalanceByFlatAmount(double newBalance,double amount) {
			balance = newBalance;
			raiseBalanceByFlatAmount(amount);
		}
		public boolean equals(ProblemEightBankCustomer pCust) {
				return pCust.customerID==customerID;
		}
		public static long getCustomerCount() {
			return customerCount;
		}
		public static void printName(ProblemEightBankCustomer pCust) {
			System.out.println(pCust.name+" ID: "+pCust.customerID+" has a balance of "+pCust.balance);
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public double getBalance() {
			return balance;
		}
		public double getBalance(double newBalance) {
			double temp = balance;
			balance = newBalance;
			return temp;
		}
		public void setBalance(double balance) {
			this.balance = balance;
		}
		
}
