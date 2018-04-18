package com.revature.Homework.ProblemEighth;

import java.io.PrintStream;

public class ProblemEighth {
	public static void main(String... strings) {
		test01(System.out);
	}
	public static void test01(PrintStream out) {
		ProblemEightBankCustomer customer = new ProblemEightBankCustomer("Jerry");
		customer.setBalance(35000d);
		customer.setName("Lerry");
		customer.raiseBalanceByPercentage(5);
		customer.raiseBalanceByPercentage(30000,5);
		ProblemEightBankCustomer.getCustomerCount();
		ProblemEightBankCustomer.printName(customer,out);
		customer.raiseBalanceByFlatAmount(30);
		customer.raiseBalanceByFlatAmount(35000, 5000);
		ProblemEightBankCustomer customer2 = new ProblemEightBankCustomer("Terry",50000);
		customer2.setBalance(35000d);
		customer2.setName("Terry");
		customer2.raiseBalanceByPercentage(5);
		customer2.raiseBalanceByPercentage(30000,5);
		ProblemEightBankCustomer.printName(customer2,out);
		customer2.raiseBalanceByFlatAmount(30);
		customer2.raiseBalanceByFlatAmount(35000, 5000);
		
		out.println(customer);
		out.println(customer2);
	}
}
