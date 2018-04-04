package com.revature.Homework.ProblemEighth;


public class ProblemEighth {
	public static void main(String... strings) {
		ProblemEightBankCustomer customer = new ProblemEightBankCustomer("Jerry");
		customer.setBalance(35000d);
		customer.setName("Lerry");
		customer.raiseBalanceByPercentage(5);
		customer.raiseBalanceByPercentage(30000,5);
		ProblemEightBankCustomer.getCustomerCount();
		ProblemEightBankCustomer.printName(customer);
		customer.raiseBalanceByFlatAmount(30);
		customer.raiseBalanceByFlatAmount(35000, 5000);
		ProblemEightBankCustomer customer2 = new ProblemEightBankCustomer("Terry",50000);
		customer2.setBalance(35000d);
		customer2.setName("Terry");
		customer2.raiseBalanceByPercentage(5);
		customer2.raiseBalanceByPercentage(30000,5);
		ProblemEightBankCustomer.printName(customer2);
		customer2.raiseBalanceByFlatAmount(30);
		customer2.raiseBalanceByFlatAmount(35000, 5000);
		
		System.out.println("Are accounts equal? "+customer.equals(customer2));
	}
}
