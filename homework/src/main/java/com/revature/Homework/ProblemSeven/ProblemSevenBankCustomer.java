package com.revature.Homework.ProblemSeven;

import java.io.PrintStream;

public class ProblemSevenBankCustomer {
		
		private static long customerCount=0L;
		private String name;
		private double balance;
		private final long customerID;
		ProblemSevenBankCustomer(String pName){
			name=pName;
			balance = 0;
			customerID=customerCount++;
		}
		ProblemSevenBankCustomer(String pName,int pBalance){
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
		public boolean equals(ProblemSevenBankCustomer pCust) {
				return pCust.customerID==customerID;
		}
		public static long getCustomerCount() {
			return customerCount;
		}
		public static void printName(ProblemSevenBankCustomer pCust) {
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
		@Override
		public String toString() {
			return "ProblemSevenBankCustomer [name=" + name + ", balance=" + balance + ", customerID=" + customerID
					+ "]";
		}
		public static void test01(PrintStream out) {
			ProblemSevenBankCustomer cus = new ProblemSevenBankCustomer("Antonio");
			out.println(cus);
		}
		public static void main(String[] args) {
			test01(System.out);
		}
}
